package oop.ex_2.problemTwo;

public class TestBench {
    public static void main(String[] args) {
        BaseFactory foodFactory = new FoodFactory();
        BaseFactory deviceFactory = new DeviceFactory();
        foodFactory.produce();
        deviceFactory.produce();
    }
}
