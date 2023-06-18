package generics.classes;
//birden fazla referans data tipini alan generic class
public class GenericClassTwoParam<S,U> {

    //2 tane field olsun farklı data tiplerini ref. alsın
    private S field;

    private U type;

    //getter setter


    public S getField() {
        return field;
    }

    public void setField(S field) {
        this.field = field;
    }

    public U getType() {
        return type;
    }

    public void setType(U type) {
        this.type = type;
    }
}
