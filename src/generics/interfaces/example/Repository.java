package generics.interfaces.example;
//tüm repolar bu standarda uymalı
public interface Repository<T> {

    void save(T object);
    T get();


}
