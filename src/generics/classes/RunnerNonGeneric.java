package generics.classes;

public class RunnerNonGeneric {

    public static void main(String[] args) {
        //classtan 2 tane nesne olsun

        NonGenericType nonGenericType1=new NonGenericType();
        NonGenericType nonGenericType2=new NonGenericType();

        nonGenericType1.setObject("Advanced Java");
        //String ile set edildi

        nonGenericType2.setObject(123);
        //Integer ile set edildi.

        //-------------------------------------

        String str1=(String) nonGenericType1.getObject();
        //!!!CAST problemi

        System.out.println(str1);

//        String str2=(String) nonGenericType2.getObject();
//        System.out.println(str2);
//        //!!!!!RTE:ClassCastException

        //olması gereken
        Integer num=(Integer) nonGenericType2.getObject();
        System.out.println(num);




    }

}
