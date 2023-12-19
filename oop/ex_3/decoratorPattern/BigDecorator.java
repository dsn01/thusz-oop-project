package oop.ex_3.decoratorPattern;

public class BigDecorator extends BaseDecorator{
    public BigDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "大杯 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 8;
    }
}
