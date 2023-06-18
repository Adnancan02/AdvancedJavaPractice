package EnumTypes;

public enum TransactionTypeEnum {
    DEPOSIT(10),//0:ordinal
    WITHDRAW(20),//1
    TRANSFER(30),//2
    PAYMENT(40),//3
    OTHER(50);//
    private final int code;//field

    public int getCode() {
        return code;
    }

    TransactionTypeEnum(int code) {//default : private
        this.code = code;
    }
}
