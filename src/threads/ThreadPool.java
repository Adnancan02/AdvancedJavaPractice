package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Threadler oldukca maliyetli yapilardir.
CPU, memoryde kaynak ayrilir.
Bu sebeple aktif olarak kullanmak istedigimiz threadlerin sayisini sinirlandirabiliriz
Thread havuzu maliyeti azaltir, CPU ya asiri yuklenmeyi önler.
Belirtilen sayidaki threadin bir kare baslatilarak tekrar tekrar kullanimasini saglar
 */
public class ThreadPool {

    public static void main(String[] args) {

       ExecutorService service = Executors.newFixedThreadPool(3);

        ThreadCreator thread1=new ThreadCreator("A");
        ThreadCreator thread2=new ThreadCreator("B");
        ThreadCreator thread3=new ThreadCreator("C");
        ThreadCreator thread4=new ThreadCreator("D");
        ThreadCreator thread5=new ThreadCreator("E");
        ThreadCreator thread6=new ThreadCreator("F");

        //thread leri baslatma
//        thread1.start();;
//        thread2.start();
//        thread3.start();;
//        thread4.start();
//        thread5.start();;
//        thread6.start();

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);

        service.shutdown();//aksi taktirde threadler havuzda beklemeye devam eder


    }




}

class ThreadCreator extends Thread{

    private String name;

    public ThreadCreator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName+" çalışmaya başladı.");
        System.out.println(threadName+" "+name+" işi yapıyor.");
        //thread bir süre çalışıyor.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+" işini bitirdi.");

    }
}