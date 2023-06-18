package generics.methods;

import java.util.Arrays;

//generic metodlar bize nasıl bir kolaylık sağlıyor
public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArr={5,23,68,99,45};
        String[]  strArr={"Java","generics","hayatımızı","kolaylaştırır."};
        Double[] doubleArr={0.2,3.5,99.8,66.0};

        System.out.println("---------generic olmayan metod------------------");
        printArr(intArr);
        printArr(strArr);
        printArr(doubleArr);


        System.out.println("---------generic metod------------------");
        printAllArray(intArr);
        printAllArray(strArr);
        printAllArray(doubleArr);

        System.out.println("---------sonuç döndüren generic metod------------------");
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(strArr));
        System.out.println(getFirst(doubleArr));

        System.out.println("----------birden fazla parametre ile generic metod-------------------");

        Integer number=88;
        printArrAndObject(strArr,number);


    }
    //arrayleri yazdırmak için metod
    public static void printArr(Integer[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //overloading...
    public static void printArr(String[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArr(Double[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //generic metod
    public static <T> void printAllArray(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //sonuç döndüren generic metod
    public static <T> T getFirst(T[] arr){
        T first=arr[0];
        return first;
    }


    //birden fazla parametre ile generic metod
    public static <T,U> void printArrAndObject(T[] arr, U object){

       // arr[0]=object;-->farklı türler olabilir, CTE--->ikisi de T olmalı

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println("------------"+object);

    }


}
