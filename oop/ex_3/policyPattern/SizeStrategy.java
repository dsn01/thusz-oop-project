package oop.ex_3.policyPattern;

public class SizeStrategy extends BaseStrategy{
    private BaseSize size;

    public SizeStrategy(BaseSize size) {
        this.size = size;
    }

    @Override
    public int CalculatePrice() {
        System.out.println(this.size);
        return this.size.getPrice();
    }
}
