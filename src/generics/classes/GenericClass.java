package generics.classes;
//syntax public class GenericClass<T>

//!!!ÖNEMLİ:Generics primitive data tipleri ile KULLANILAMAZ...
public class GenericClass<T> {

    /*
E --> Element, collection gibi yapılarda kullanılır
K --> Key
V --> Value
N --> Number
T --> Type
S,U,V , vb --> 2., 3. ve 4. tipler için
 */

    private String name;
    private T type;//her data tipini referans alabilen bir field

    //getter-setter


    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
