package threads;

import java.util.concurrent.Semaphore;

/*
Semaphore, birden fazla threadin ortak bir kaynağa erişmek istediği durumlarda
erişen threadlerin sayısının sınırlandırılmasını sağlar.

Synchronized aynı anda sadece 1 threadin erişimine izin verirken,
semaphore n tane threadin erişimine izin verir.
*/
public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore=new Semaphore(3);

        Car car1=new Car("Honda",5000,semaphore);
        Car car2=new Car("BMW",6000,semaphore);
        Car car3=new Car("Toyota",6000,semaphore);
        Car car4=new Car("Volvo",4000,semaphore);
        Car car5=new Car("Tofaş",10000,semaphore);
        Car car6=new Car("Audi",7000,semaphore);
        Car car7=new Car("Anadol",9000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();

    }
}
class Car extends Thread{
    private  String carName;
    private int duration;
    private Semaphore semaphore;

    //param const
    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        System.out.println(carName+" park etmek istiyor.");
        try {
            semaphore.acquire();//erişim için izin talep edilir, izin verilecek thread sayısı dolmamışsa izin verilir.
            //ortak kaynak
            Thread.sleep(2000);
            System.out.println(carName + " park etti.");
            System.out.println(carName + " park yerinde bekliyor.");
            Thread.sleep(duration);
            System.out.println(carName + " park yerini terk ediyor....");
            //ortak kaynak
            semaphore.release();//erişim için 1 threadlik alan serbest bırakıldı.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
