package generics.interfaces;
//generic interfacein data tipine karar verilirse classın generic olmasına gerek yoktur.
public class GenericInterfaceStringImpl implements GenericInterface<String>{
    @Override
    public void printValue(String value) {

    }

    @Override
    public String getValue() {
        return null;
    }
}
