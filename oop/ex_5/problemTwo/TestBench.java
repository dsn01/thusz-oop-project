package oop.ex_5.problemTwo;

public class TestBench {
    public static void main(String[] args) {
        for(int i = 0;i < 15;i++) {
            int threadId = i;
            Thread thread = new Thread(() -> {
                Kerrigan.getInstance().visit(threadId);
            });
            thread.start();
        }
    }
}
