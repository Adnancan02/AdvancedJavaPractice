package threads;

public class WithoutDeadlock {

    public static void main(String[] args) {
        String kahve="kahve";
        String seker="şeker";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (kahve){
                    System.out.println(Thread.currentThread().getName()+" "+kahve+" yi kullanıyor.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i istiyor.");
                    synchronized (seker){
                        System.out.println(Thread.currentThread().getName()+" "+seker+" yi kullanıyor.");
                    }//seker serbest
                }//kahve serbest
                System.out.println(Thread.currentThread().getName()+" sıcak suyu da ekledi, kahvesini içiyor...");
            }
        },"Tom");
        //thread1.setName();
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (kahve){
                    System.out.println(Thread.currentThread().getName()+" "+kahve+" i kullanıyor.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i istiyor.");
                    synchronized (seker){
                        System.out.println(Thread.currentThread().getName()+" "+seker+" yi kullanıyor.");
                    }//kahve serbest
                }//seker serbest
                System.out.println(Thread.currentThread().getName()+" sıcak suyu da ekledi, kahvesini içiyor...");

            }
        });
        thread2.setName("Jerry");
        thread2.start();


    }
}
