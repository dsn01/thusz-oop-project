package oop.ex_3.decoratorPattern;

public class PearlDecorator extends BaseDecorator{
    public PearlDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "加珍珠 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 1;
    }
}
