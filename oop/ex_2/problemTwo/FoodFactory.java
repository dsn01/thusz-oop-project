package oop.ex_2.problemTwo;

public class FoodFactory implements BaseFactory{
    private BaseProducer producer;
    public FoodFactory() {
        this.producer = new FoodProducer();
    }
    @Override
    public BaseProduct produce() {
        this.producer.produce();
        System.out.println("Food has been produced successfully......");
        return new Food();
    }
}
