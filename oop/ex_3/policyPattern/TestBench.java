package oop.ex_3.policyPattern;

public class TestBench {
    public static void main(String[] args) {
        // Test1: 请助教哥哥喝最贵的奶茶QAQ......选择超大杯, 红茶, 珍珠和椰果和奶盖, 并打印订单
        Order order1 = new Order(
                new SizeStrategy(new SuperBig()),
                new ChaDiStrategy(new RedTea()),
                new AddStrategy(new Pearl(), new YeGuo(), new NaiGai())
        );
        order1.print();
        // Test2: 请老师喝最便宜的奶茶hhh......选择中杯, 乌龙茶, 不加配料, 并打印订单
        Order order2 = new Order(
                new SizeStrategy(new Medium()),
                new ChaDiStrategy(new WuLongTea()),
                new AddStrategy()
        );
        order2.print();
    }
}
