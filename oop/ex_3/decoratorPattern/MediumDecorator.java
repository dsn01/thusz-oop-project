package oop.ex_3.decoratorPattern;

public class MediumDecorator extends BaseDecorator{
    public MediumDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "中杯 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 6;
    }
}
