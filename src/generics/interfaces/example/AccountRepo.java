package generics.interfaces.example;
//account DB işlemleri
public class AccountRepo implements Repository<Account> {
    @Override
    public void save(Account object) {

    }

    @Override
    public Account get() {
        return null;
    }
}
