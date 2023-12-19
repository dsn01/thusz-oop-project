package oop.ex_3.decoratorPattern;

public class WuLongDecorator extends BaseDecorator{
    public WuLongDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "乌龙茶 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 2;
    }
}
