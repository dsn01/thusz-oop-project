package oop.ex_3.decoratorPattern;

public class BaseTea implements MilkTea{
    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getCost() {
        return 0;
    }
}
