package threads;
/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.

wait ve notify: bir yada daha fazla threadin işlemini tamamlayabilmesi için
diğer threadin yapacağı işlemin tamamlanmasının gerektiği durumlarda
monitör edilen obje için kullanılır.

 */
public class WaitNotify {

    public static int balance=0;//her iki threadde bakiyeyi değiştirmeye çalışıyor.

    public static void main(String[] args) {

        WaitNotify obj=new WaitNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("öğrenci");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(200);
            }
        });
        thread2.setName("veli");
        thread2.start();


    }

    //para çekme işlemi
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if (balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz. Mevcut bakiye: "+balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//monitor edilen obje geçici olarak serbest kalır.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //....notify çağrılınca bekleme sona erer.


        if(balance>=amount){
            balance=balance-amount;
            System.out.println("Para çekme işlemi gerçekleşti. Mevcut bakiye: "+balance);
        }else {
            System.out.println("Umudunu kaybetme, yarın yine gel:)");
        }

    }

    //para yatırma işlemi
  /*  public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi gerçekleşti. Mevcut bakiye :"+balance);
        notify();//bekleyen threade bildirim gönderir.
        //notifyAll(); birden fazla bekleyen varsa
    }*/

    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi gerçekleşti. Mevcut bakiye :"+balance);
        notify();//bekleyen threade bildirim gönderir.
        //notifyAll(); birden fazla bekleyen varsa
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("(notify metod tamamlanana kadar objeyi serbest bırakmaz.)");
    }


}
