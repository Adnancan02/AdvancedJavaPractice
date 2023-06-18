package threads;

public class ThreadCreationways {
    public static void main(String[] args) {

        System.out.println("Mevcut thread: "+Thread.currentThread().getName());

        //Thread extend ederek
        MyThread thread1=new MyThread();
        // thread1.run();//run içindeki kodlar çalıştırılır. ancak thread oluşturulmaz.
        thread1.start();//override edilen run metodunu çağırır ve threadi başlatır.


        //Runnable implemente ederek
        MyRunnable myRunnable=new MyRunnable();
        Thread thread2=new Thread(myRunnable);
        thread2.start();
        thread2.setName("yeni thread");

        //Runnable(functional) implemente ederek
        //annonymous(isimsiz) class ile Thread oluşturma
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);//thread3 başladıktan sonra işlemler için 5 sn beklesin
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Mevcut thread: "+Thread.currentThread().getName());
                System.out.println("Bu thread isimsiz class ile oluşturuldu.");
            }
        },"threadcik");
        thread3.start();

        Thread thread4=new Thread(()->{
            System.out.println("Mevcut thread: "+Thread.currentThread().getName());
            System.out.println("Bu thread lambda expression ile oluşturuldu.");
        }
        );
        thread4.start();


        try {
            Thread.sleep(10000);//main thread 10 sn bekler.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main threadin işlemi burada bitti");


    }

}
//Thread oluşturma
//1.Yöntem: Thread classını extend ederek

class MyThread extends Thread{

    @Override//threade yaptırmak istediğimiz işlemi
    public void run() {
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());
        System.out.println("MyThread threadi çalışıyor.");
    }
}

//2.yöntem: Runnable interface ini implemente ederek
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());
        System.out.println("MyRunnable ile oluşturduğumuz thread çalışıyor.");
    }
}