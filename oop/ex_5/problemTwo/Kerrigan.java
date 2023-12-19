package oop.ex_5.problemTwo;

public class Kerrigan {
    public static volatile Kerrigan instance;

    private Kerrigan() {
    }

    public static Kerrigan getInstance() {
        if (instance == null) {
            synchronized (Kerrigan.class) {
                if (instance == null) {
                    instance = new Kerrigan();
                }
            }
        }
        return instance;
    }

    public void visit(int id) {
        System.out.println("线程" + id + "号访问了...");
    }
}
