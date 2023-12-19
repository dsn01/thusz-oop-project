package oop.ex_3.decoratorPattern;

public class GreenDecorator extends BaseDecorator{
    public GreenDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "绿茶 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 3;
    }
}
