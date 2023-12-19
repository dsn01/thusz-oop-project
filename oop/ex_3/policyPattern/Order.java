package oop.ex_3.policyPattern;

public class Order {
    private BaseStrategy size;
    private BaseStrategy chaDi;
    private BaseStrategy ingredient;

    public Order(BaseStrategy size, BaseStrategy chaDi, BaseStrategy ingredient) {
        this.size = size;
        this.chaDi = chaDi;
        this.ingredient = ingredient;
    }
    public void print() {
        int sum_price = 0;
        sum_price += this.size.CalculatePrice();
        sum_price += this.chaDi.CalculatePrice();
        System.out.println("加入配料：");
        sum_price += this.ingredient.CalculatePrice();
        System.out.println("===总价为: " + sum_price + "元===");
    }

    public BaseStrategy getSize() {
        return size;
    }

    public void setSize(BaseStrategy size) {
        this.size = size;
    }

    public BaseStrategy getChaDi() {
        return chaDi;
    }

    public void setChaDi(BaseStrategy chaDi) {
        this.chaDi = chaDi;
    }

    public BaseStrategy getIngredient() {
        return ingredient;
    }

    public void setIngredient(BaseStrategy ingredient) {
        this.ingredient = ingredient;
    }
}
