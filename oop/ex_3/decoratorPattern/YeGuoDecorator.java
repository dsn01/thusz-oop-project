package oop.ex_3.decoratorPattern;

public class YeGuoDecorator extends BaseDecorator{
    public YeGuoDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "加椰果 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 2;
    }
}
