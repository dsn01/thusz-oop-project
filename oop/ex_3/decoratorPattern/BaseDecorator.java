package oop.ex_3.decoratorPattern;

public abstract class BaseDecorator implements MilkTea{
    protected MilkTea decorated;
    public BaseDecorator(MilkTea milkTea) {
        this.decorated = milkTea;
    }
    @Override
    public String getDescription() {
        return decorated.getDescription();
    }

    @Override
    public int getCost() {
        return decorated.getCost();
    }
}
