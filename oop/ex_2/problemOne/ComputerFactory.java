package oop.ex_2.problemOne;

public class ComputerFactory implements BaseFactory{
    @Override
    public BaseProduct produce() {
        return new Computer();
    }
}
