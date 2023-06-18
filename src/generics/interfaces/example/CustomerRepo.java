package generics.interfaces.example;

//customer DB işlemleri
public class CustomerRepo implements Repository<Customer>{
    @Override
    public void save(Customer object) {

    }

    @Override
    public Customer get() {
        return null;
    }
}
