package generics.bounding;
//parametre olarak aldığımız data tipini sınırlandırabiliriz.
//T:Integer,Double,Float,Long...,Number
//Sadece Number ve childları kullanılsın diyerek ÜSTTEN sınırlandırabiliriz
public class GenericUpperBound<T extends Number> {

    private T[] numberArray;//field,özellik

    //param const.
    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //array içindeki değerlerin ortalamasını bulan metod
    public double getAverage(){
        double sum=0;

        for(T t:numberArray){
            sum+=t.doubleValue();//t yi double tipine döndür ve sum a ekle
        }

        double avg=sum/this.numberArray.length;
        return avg;
    }

//main metod
    public static void main(String[] args) {

         Integer[] intArr={3,5,10,8,9};
         GenericUpperBound<Integer> obj1=new GenericUpperBound<>(intArr);
         System.out.println(obj1.getAverage());

         Double[] doubles={3.0,0.5,1.5,2.5};
         GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubles);
        System.out.println(obj2.getAverage());

//         String[] strings={"Java","generics","üstten","sınırlandırılabilir."};
//         GenericUpperBound<String> obj3=new GenericUpperBound<>(strings);//CTE
//         //T data tipini Number ile sınırlandırdık, String olmaz.

    }


}
