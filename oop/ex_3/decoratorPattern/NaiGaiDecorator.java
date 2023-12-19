package oop.ex_3.decoratorPattern;

public class NaiGaiDecorator extends BaseDecorator{
    public NaiGaiDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "加奶盖 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 3;
    }
}
