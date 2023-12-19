package oop.ex_6.problemTwo;

public class TestBench {
    public static void main(String[] args) {
        Director director = new Director();
        BaseBuilder builder = new CompleteBuilder("主窗口", "控制条");
        director.makeVideoSoftware(builder);
        VideoSoftware videoSoftware = builder.getVideoSoftware();
        System.out.println("完整模式: " + videoSoftware);
        System.out.println("================");

        BaseBuilder builder1 = new SimpleBuilder("主窗口", "控制条");
        director.makeVideoSoftware(builder1);
        videoSoftware = builder1.getVideoSoftware();
        System.out.println("精简模式: " + videoSoftware);
        System.out.println("================");

        BaseBuilder builder2 = new MemoryBuilder("主窗口", "控制条");
        director.makeVideoSoftware(builder2);
        videoSoftware = builder2.getVideoSoftware();
        System.out.println("记忆模式: " + videoSoftware);
        System.out.println("================");
    }
}
