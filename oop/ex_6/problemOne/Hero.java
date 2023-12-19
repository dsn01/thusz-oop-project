package oop.ex_6.problemOne;

import java.util.ArrayList;

public class Hero {
    // 游戏主角对象
    private ArrayList<Double> position;
    private int XP;
    private float HP;
    private ArrayList<Integer> backpack;

    public Hero() {
    }

    public Hero(ArrayList<Double> position, int XP, float HP, ArrayList<Integer> backpack) {
        this.position = position;
        this.XP = XP;
        this.HP = HP;
        this.backpack = backpack;
    }

    // 保存状态
    public HeroMomento save() {
        return new HeroMomento(this.position, this.XP, this.HP, this.backpack);
    }

    // 恢复状态
    public void restore(HeroMomento heroMomento) {
        this.position = heroMomento.getPosition();
        this.XP = heroMomento.getXP();
        this.HP = heroMomento.getHP();
        this.backpack = heroMomento.getBackpack();
    }

    // 打印状态
    @Override
    public String toString() {
        return "位置:\t" + this.position + "\n"
                + "经验值:\t" + this.XP + "\n"
                + "生命值:\t" + this.HP + "\n"
                + "背包:\t" + this.backpack;
    }

    public ArrayList<Double> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Double> position) {
        this.position = position;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public ArrayList<Integer> getBackpack() {
        return backpack;
    }

    public void setBackpack(ArrayList<Integer> backpack) {
        this.backpack = backpack;
    }

    public void addItem(int item) {
        this.backpack.add(item);
    }

    public void delItem(int index) {
        this.backpack.remove(index);
    }
}
