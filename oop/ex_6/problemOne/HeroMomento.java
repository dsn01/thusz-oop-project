package oop.ex_6.problemOne;

import java.util.ArrayList;

public class HeroMomento {
    // 游戏主角备忘录对象
    private ArrayList<Double> position;
    private int XP;
    private float HP;
    private ArrayList<Integer> backpack;

    public HeroMomento(ArrayList<Double> position, int XP, float HP, ArrayList<Integer> backpack) {
        this.position = position;
        this.XP = XP;
        this.HP = HP;
        this.backpack = backpack;
    }

    public ArrayList<Double> getPosition() {
        return position;
    }

    public int getXP() {
        return XP;
    }

    public float getHP() {
        return HP;
    }

    public ArrayList<Integer> getBackpack() {
        return backpack;
    }
}
