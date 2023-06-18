package generics.interfaces;
//generic interface i implemente eden class da generic olmak zorundadır.
public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    @Override
    public void printValue(T value) {
        System.out.println("Bu metodda istediğimiz data tipini parametre olarak alabiliriz:"+value);
    }

    @Override
    public T getValue() {
        return null;
    }
}
