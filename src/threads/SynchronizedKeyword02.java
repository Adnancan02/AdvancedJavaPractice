package threads;
//synchronized ; metod veya bloklar için kullanılır
//bloğa erişen thread hangi obje ile erişirse bu objeyi monitör etmek için this kullanlır.
//
public class SynchronizedKeyword02 {

    public static void main(String[] args) {


        Brackets2 brackets=new Brackets2();

        Long start=System.currentTimeMillis();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9; i++){
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9; i++){
                    brackets.generateBrackets();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Long finish=System.currentTimeMillis();

        System.out.println("Geçen süre: "+(finish-start));

//synchronized metodu ile geçen süre:5585
//synchronized bloğu ile geçen süre: 2803


    }

}

//aynı anda ulaşılan metod içerisinde asenkron çalışmasında problem olmayacak kodlar varsa
class Brackets2{
    //synchronized ile metoda ulaşan threadin objeyi monitör(kilitlemek) etmesini sağladık
    public void generateBrackets(){

        synchronized (this){
            for (int i=1;i<=10;i++){
                if(i<=5){
                    System.out.print("[ ");
                }else{
                    System.out.print("] ");
                }
            }
            System.out.println();
        }

//
        //başka kodlar var,sıra önemli değil
        for (int i=0;i<5;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}