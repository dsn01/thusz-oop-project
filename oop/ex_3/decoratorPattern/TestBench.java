package oop.ex_3.decoratorPattern;

public class TestBench {
    public static void main(String[] args) {
        // Test1: 同样请助教喝最贵的奶茶, 超大杯、红茶、加珍珠和椰果和奶盖
        MilkTea milkTea1 = new SuperBigDecorator(new RedDecorator(new PearlDecorator(new YeGuoDecorator(new NaiGaiDecorator(new BaseTea())))));
        System.out.println(milkTea1.getDescription() + "-》共计：" + milkTea1.getCost() + "元...");
        // Test2: 同样请老师喝最便宜的奶茶, 中杯、乌龙茶、啥都不加
        MilkTea milkTea2 = new MediumDecorator(new WuLongDecorator(new BaseTea()));
        System.out.println(milkTea2.getDescription() + "-》共计：" + milkTea2.getCost() + "元...");
    }
}
