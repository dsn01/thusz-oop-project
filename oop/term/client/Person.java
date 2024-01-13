package oop.term.client;

import oop.term.backend.ChessState;

import java.util.Scanner;

public class Person extends Actor{
    Scanner scanner = new Scanner(System.in);

    public Person(String username, String password, int total, int wins) {
        super(username, password, total, wins);
    }

    public String sendCommand(ChessState state) {
        /*
            玩家对战从命令行输入命令
         */
        return scanner.nextLine();
    }
}
