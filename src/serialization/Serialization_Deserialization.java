package serialization;

import java.io.*;
//OUS objeleri serileştirerek, Java objelerini kodlar ve byte akışına yazdırır.
public class Serialization_Deserialization {

    public static void main(String[] args) {

        //writeObjects();
        readObjects();

    }

    public static void writeObjects(){
          System.out.println("Objeler oluşturuluyor....");
          User user1=new User(1,"Yavuz",32);
          User user2=new User(2,"Hakan",28);
          User user3=new User(3,"Yusuf",28);
          User user4=new User(4,"Bahadır",27);


        try {
            //FOS,Javada dosyaya veri yazabilmemizi sağlar.
            //nesnelerin yazıldığı dosyayı oluşturmak için
            FileOutputStream fos=new FileOutputStream("user.ser");
            //objeleri yazdırmak için
            //objelerin yazılabilmesi için serileştirilmesi gerekir.
            ObjectOutputStream output=new ObjectOutputStream(fos);
            output.writeObject(user1);
            output.writeObject(user2);
            output.writeObject(user3);
            output.writeObject(user4);

            output.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readObjects(){
        //Javada dosyadakileri okuma işlemlerinde FIS kullanılır
        try {
            FileInputStream fis=new FileInputStream("user.ser");
            //objelerin de-serialization okunması için OIS
            ObjectInputStream input=new ObjectInputStream(fis);

            User user1=(User)input.readObject();
            User user2=(User)input.readObject();
            User user3=(User)input.readObject();
            User user4=(User)input.readObject();

            //readobject dosyanın sonuna geldiğinde EOFException fırlatır.

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);

            input.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }





}
