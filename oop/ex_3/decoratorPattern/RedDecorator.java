package oop.ex_3.decoratorPattern;

public class RedDecorator extends BaseDecorator{
    public RedDecorator(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "红茶 ";
    }

    @Override
    public int getCost() {
        return super.getCost() + 4;
    }
}
