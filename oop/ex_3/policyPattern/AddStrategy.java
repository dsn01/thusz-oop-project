package oop.ex_3.policyPattern;

public class AddStrategy extends BaseStrategy{
    private BaseIngredient[] ingredients;

    public AddStrategy(BaseIngredient... ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int CalculatePrice() {
        if(this.ingredients.length == 0) {
            System.out.println("无配料");
            return 0;
        }
        else {
            int sum_price = 0;
            for(BaseIngredient ingredient: this.ingredients) {
                System.out.println(ingredient);
                sum_price += ingredient.getPrice();
            }
            return sum_price;
        }
    }
}
