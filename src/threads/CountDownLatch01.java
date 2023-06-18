package threads;

import java.util.concurrent.CountDownLatch;

/*
bazı threadlerin önce çalışmasını ve
bu arada diğer threadlerin ve main threadin beklemesini
istediğimizde COuntDownLatch ile bir sayaç oluşturulur. Öncelike verdiğimiz
threadler işini tamamladıkça sayaç 0 olana kadar azaltılır.
0 olduğunda ise diğer threadlerin çalışmaya devam etmesine izin verilir.

*/
public class CountDownLatch01 {
    public static void main(String[] args) {

        CountDownLatch latch=new CountDownLatch(4);
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread-1 başladı");
                try {
                    latch.await();//worker threadleri bekle
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread1 çalışıyor.");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 çalışıyor.");
            }
        });

        WorkersThreads worker1=new WorkersThreads("worker-1",latch,7000);
        WorkersThreads worker2=new WorkersThreads("worker-2",latch,8000);
        WorkersThreads worker3=new WorkersThreads("worker-3",latch,5000);
        //WorkersThreads worker4=new WorkersThreads("worker-4",latch,9000);
        Thread worker4=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("worker4 başladı");
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("worker4 bitirdi");
                latch.countDown();
            }
        });



        thread1.start();
        thread2.start();
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        try {
            latch.await();//bu satırdan sonra workerları bekle
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread çalışıyor.");


    }

}
class WorkersThreads extends Thread{

    private int duration;
    private CountDownLatch latch;

    public WorkersThreads(String name, CountDownLatch latch, int duration) {
        super(name);
        this.latch = latch;
        this.duration=duration;
    }



    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  başladı.");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"  bitirdi.");
        latch.countDown();//4->3->2->1->0
    }


}