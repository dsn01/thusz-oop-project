package oop.ex_6.problemOne;

import java.util.ArrayList;
import java.util.Arrays;

public class TestBench {
    public static void main(String[] args) {
        MomentoCareTaker careTaker = new MomentoCareTaker();
        Hero hero = new Hero(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0)), 999, (float) 12.1, new ArrayList<>(Arrays.asList(4, 5, 6)));
        // 1.打印游戏主角的所有状态
        System.out.println("初始化");
        System.out.println(hero);
        System.out.println("=====================");
        // 2. 修改主角的状态
        hero.setPosition(new ArrayList<>(Arrays.asList(1.5, 2.5, 3.5))); // 修改位置
        hero.setXP(1000); // 修改经验值
        hero.setHP((float) 15.4); // 修改生命值
        hero.addItem(7); // 增加背包物品
        hero.delItem(0); // 删除背包中的第0号物品
        System.out.println("修改后:");
        System.out.println(hero);
        System.out.println("=====================");
        // 3. 存档
        careTaker.addMomento(hero.save());
        // 4. 读取存档
        hero = null;
        Hero newHero = new Hero();
        System.out.println(newHero);
        System.out.println("=====================");
        System.out.println("读取存档");
        newHero.restore(careTaker.getMomento(0));
        System.out.println(newHero);
        System.out.println("=====================");
    }
}
