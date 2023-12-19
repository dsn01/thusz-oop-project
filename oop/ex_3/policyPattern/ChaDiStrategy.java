package oop.ex_3.policyPattern;

public class ChaDiStrategy extends BaseStrategy{
    private BaseTea tea;

    public ChaDiStrategy(BaseTea tea) {
        this.tea = tea;
    }

    @Override
    public int CalculatePrice() {
        System.out.println(this.tea);
        return this.tea.getPrice();
    }
}
