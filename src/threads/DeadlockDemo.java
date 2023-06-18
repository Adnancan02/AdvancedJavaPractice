package threads;
/*
Ölümcül kilitlenme(deadlock), iki veya daha fazla thread işlemlerini tamamlamak için
birbirinin monitör etmiş olduğu objeyi kullanmak istemesi gibi durumlarda meydana gelir.
Bu da uygulamayı olumsuz etkiler hatta uygulamayı cevap veremez hale getirebilir.
Genellikle iç içe synchronized blok kullanıldığında yaşanır.
*/
public class DeadlockDemo {
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

                synchronized (seker){
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i kullanıyor.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+kahve+" i istiyor.");
                    synchronized (kahve){
                        System.out.println(Thread.currentThread().getName()+" "+kahve+" yi kullanıyor.");
                    }//kahve serbest
                }//seker serbest
                System.out.println(Thread.currentThread().getName()+" sıcak suyu da ekledi, kahvesini içiyor...");

            }
        });
        thread2.setName("Jerry");
        thread2.start();




    }
}