package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunnerGenericType {
    public static void main(String[] args) {

       // GenericClass<String> obj1=new GenericClass<String>();
        GenericClass<String> obj1=new GenericClass<>();//Java 7 ile birlikte sağ tarafta kullanmak opsiyonel oldu
        obj1.setType("Generic Type");

        String str=obj1.getType();//CASTING e gerek kalmadı.

        GenericClass<Integer> obj2=new GenericClass<>();//Java 7 ile birlikte sağ tarafta kullanmak opsiyonel oldu
        obj2.setType(12);

        Integer num=obj2.getType();

//        GenericClass<String> obj3=new GenericClass<>();
//        obj3.setType(12);//CTE, tür güvenliği sağlanır.-->ClassCastExc. önlüyor.


   //     List list=new ArrayList<>();--raw kullanımı--Java 5 ten önce
        List<String> list=new ArrayList<>();
        list.add("Advanced");
        list.add("Java");
      //  list.add(12);//CTE, tür güvenliği sağlanır.-->ClassCastExc. önlüyor.


        Map<String,Integer> map=new HashMap<>();
        map.put("generic",2);
    //    map.put(1,1);//CTE, tür güvenliği sağlanır.-->ClassCastExc. önlüyor.


        //============================ÇOKLU PARAMETRELİ CLASS================================

        GenericClassTwoParam<String,Integer> mymap=new GenericClassTwoParam<>();
        mymap.setField("java");
        mymap.setType(12);

        System.out.println(mymap.getField()+"-----"+mymap.getType());

    }
}
