package oop.term.client;

import java.util.Scanner;

public class Person implements Actor{
    Scanner scanner = new Scanner(System.in);

    @Override
    public String sendCommand() {
        /*
            玩家对战从命令行输入命令
         */
        return scanner.nextLine();
    }
}
