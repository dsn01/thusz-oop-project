package oop.ex_2.problemOne;

public class PhoneFactory implements BaseFactory{
    @Override
    public BaseProduct produce() {
        return new Phone();
    }
}
