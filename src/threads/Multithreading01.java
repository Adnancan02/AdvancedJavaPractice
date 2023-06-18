package threads;

public class Multithreading01 {
    public static void main(String[] args) {

        //TASK: 1 den 10 a kadar 2 defa consola yazdırma

        Long start=System.currentTimeMillis();
        CounterWithoutMultiThread counter1=new CounterWithoutMultiThread("Yavuz");
        counter1.countMe();
        System.out.println("--------------------------------------------------");
        CounterWithoutMultiThread counter2=new CounterWithoutMultiThread("Bahadır");
        counter2.countMe();
        Long finish=System.currentTimeMillis();
        System.out.println("CounterWithoutMultiThread ile geçen süre: "+(finish-start));//10249

        System.out.println("--------------------------------------------------");
        Long startTime=System.currentTimeMillis();
        CounterWithMultiThread counter3=new CounterWithMultiThread("Muhammed Emin");
        counter3.start();
        // counter3.join();
        CounterWithMultiThread counter4=new CounterWithMultiThread("Enes");
        counter4.start();

        try {
            counter3.join();//içinde bulunduğu threadi(main) counter3 threadinin işi bitene kadar bekletir.
            counter4.join();//içinde bulunduğu threadi(main) counter4 threadinin işi bitene kadar bekletir.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //sleep süreyi doğru hesaplamak için çözüm olmadı
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Long finishTime=System.currentTimeMillis();
        System.out.println("CounterWithMultiThread ile geçen süre : "+(finishTime-startTime));//5090


    }
}


class CounterWithoutMultiThread{
    public String name;

    //constructor
    public CounterWithoutMultiThread(String name) {
        this.name = name;
    }

    //thread kullanmadan 1 den 10 a kadar sayıları yazdıran metod
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0.5 sn bekle
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+this.name);
        }
    }
}

//multithreading ile aynı görevleri yapalım
class CounterWithMultiThread extends Thread{

    public String name;

    //const
    public CounterWithMultiThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        countMe();
    }

    // 1 den 10 a kadar sayıları yazdıran metod
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0.5 sn bekle
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+this.name);
        }
    }

}

