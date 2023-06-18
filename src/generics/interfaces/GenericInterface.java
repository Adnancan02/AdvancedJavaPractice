package generics.interfaces;
//örn:repository->customer,account,user
public interface GenericInterface<T> {

    void printValue(T value);
    T getValue();

}
