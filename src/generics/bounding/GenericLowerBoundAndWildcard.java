package generics.bounding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericLowerBoundAndWildcard {
    public static void main(String[] args) {

        System.out.println("------------wildcard ile alltan sınırlama-----------------");
        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        List<Object> objectList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();

        addElements(integerList);
        System.out.println(integerList);

       // addElements(doubleList);
        addElements(numberList);
        addElements(objectList);

        System.out.println("------------wildcard ile üstten sınırlama-----------------");
        multiplyBy2(integerList);
        multiplyBy2(doubleList);
        multiplyBy2(numberList);
     //   multiplyBy2(objectList);//listin data tipini üstten Number ile sınırlandırdık.
        System.out.println();


        System.out.println("----------------List<?>----------------------");
        printElements(integerList);
        printElements(doubleList);
        printElements(stringList);

        System.out.println("----------------List<Object>----------------------");
//        printObjectElements(objectList);
//        printObjectElements(integerList);
//        printObjectElements(stringList);//List<Object> List<String> in parentı değildir.


    }

    //alttan sınırlama
    //parameterede verilen listeye 1..10 a kadar eleman ekleme
    //Listin data tipi Integer,Number veya Object olsun

    //wildcard(joker):?:bilinmeyen data tipi
    public static void addElements(List<? super Integer> list){

        for (int i=1;i<=10;i++){
            list.add(i);
        }

    }

    //wildcard ile üstten sınırlama
    public static void multiplyBy2(List<? extends Number> list){
        list.stream().map(t->2*t.doubleValue()).forEach(t-> System.out.print(t+"  "));
    }
    //T:herhangibir data tipi, ?:bilinmeyen data tipi
    //wildcard ın bazı kısıtlamaları var
    public static void printElements(List<?> unknownList ){

//        unknownList.add(1);//listin data tipi NETleşmeden add yapmaz.
//        unknownList.add("java");

        //NOT:? okumaya izin verir. değişikliğe izin vermez.
        //Data tipinden bağımsız metodlara izin verir:size,remove,get

        unknownList.add(null);
        unknownList.forEach(t-> System.out.print(t+" "));

    }

    //List<?> vs List<Object>
    public static void printObjectElements(List<Object> objectList ){

        objectList.add("String");
        objectList.add(12);

        objectList.add(null);
        objectList.forEach(t-> System.out.print(t+" "));

    }

    //NOT:? ve T tamamen aynı değildir.




}
