package threads;

/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.

 */

public class WaitInterrupt {

    public static int balance=0;

    public static void main(String[] args) {

        WaitInterrupt object=new WaitInterrupt();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {

                object.withdraw(1000);

            }
        });
        thread1.setName("tüketici");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                object.deposit(2000);


                thread1.interrupt();//thread1 in çalışmasını zorla durdurur.
                //wait(bekleme) işlemi durduruldu.

            }
        });
        thread2.setName("üretici");
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
                System.out.println("(tüketici threadin çalışması kesildi.)");
                System.out.println("Lütfen bakiyenizi tekrar kontrol ediniz.");
            }
        }

        if(balance>=amount){
            balance=balance-amount;
            System.out.println("Para çekme işlemi gerçekleşti. Mevcut bakiye: "+balance);
        }else {
            System.out.println("Umudunu kaybetme, yarın yine gel:)");
        }

    }

    //para yatırma işlemi
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi gerçekleşti. Mevcut bakiye :"+balance);

    }
    //deposit metodu tamamlanınca monitör edilen nesne serbest bırakılır.

}