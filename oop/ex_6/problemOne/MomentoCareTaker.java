package oop.ex_6.problemOne;

import java.util.ArrayList;

public class MomentoCareTaker {
    // 游戏主角备忘录负责人对象
    private ArrayList<HeroMomento> momentoList = new ArrayList<>();

    public HeroMomento getMomento(int index) {
        return (HeroMomento)momentoList.get(index);
    }

    public void addMomento(HeroMomento heroMomento) {
        momentoList.add(heroMomento);
    }
}
