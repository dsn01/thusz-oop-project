package oop.ex_7.problemOne;

public class TestBench {
    public static void main(String[] args) {
        AbstractSubject subject = new ConcreteSubject();
        String[] positions = {"前端", "后端", "大数据", "算法"};
        String[] locations = {"北京", "上海", "深圳"};
        int num = 1;
        // 添加求职者
        for(String position: positions) {
            for (String location: locations) {
                subject.addObserver(new ConcreteObserver(String.format("用户%02d", num), position, location));
                num++;
            }
        }
        // 公司发布招聘信息
        subject.notification("字节", "算法", "深圳");
        subject.notification("腾讯", "后端", "上海");
        subject.notification("美团", "前端", "北京");
        subject.notification("百度", "大数据", "美国");
    }
}
