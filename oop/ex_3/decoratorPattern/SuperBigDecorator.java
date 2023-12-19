package oop.ex_3.decoratorPattern;

public class SuperBigDecorator extends BaseDecorator{
    public SuperBigDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "超大杯 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 10;
    }
}
