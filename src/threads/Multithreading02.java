package threads;

public class Multithreading02 {
    public static int counter=0;

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalışmaya başladı.");
                Counter.count();//1000
                System.out.println("burada başka kodlar var.");
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                //  thread1.join();---tüm işlemlerin bitmesini beklemeye gerek yok.
                System.out.println(Thread.currentThread().getName()+" çalışmaya başladı.");
                Counter.count();
                System.out.println("burada ortak dataya erişmeyen kodlar var.");
            }
        });
        thread2.setName("Jerry");
        thread2.start();
    }
}
class Counter{
    //counter değişkeninin değerini 1000 kez artırıp yazdıralım
    //synchronized ile metoda erişen threadleri sıraya koymuş oluruz.
    //yani aynı anda bu metoda sadece bir thread erişebilsin
    public synchronized static void count(){
        for (int i=1;i<=1000;i++){
            Multithreading02.counter++;
            System.out.println(Thread.currentThread().getName()+"---Counter : "+ Multithreading02.counter);//beklenen değer 1000+1000=2000
        }
    }
}








