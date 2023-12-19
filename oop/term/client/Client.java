package oop.term.client;

import oop.term.backend.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Manager manager;
    private Scanner scanner = new Scanner(System.in);
    private boolean hint = true;
    private boolean checkNow = false;

    public void run() {
        // 初始化游戏
        System.out.println("====游戏对战平台已开启====");
        System.out.println("请选择游戏类型: 0. 五子棋 1. 围棋");
        int type = scanner.nextInt();
        System.out.println("请输入棋盘大小: ");
        int size = scanner.nextInt();
        size = Math.max(Constant.MIN_SIZE, Math.min(Constant.MAX_SIZE, size));
        if (type == GameType.WUZIQI) {
            manager = new Manager(new WuziState(size), new MomentoCareTaker());
        } else if (type == GameType.WEIQI) {
            manager = new Manager(new WeiqiState(size), new MomentoCareTaker());
        }
        // 根据用户命令开始游戏
        Person black = new Person();
        Person white = new Person();
        String lastCommand = null;
        while (true) {
            if (hint) {
                System.out.println("command: ");
                System.out.println("remake -重新开启对局");
                System.out.println("step <x> <y> -在(x,y)处落子");
                System.out.println("regret -悔棋");
                System.out.println("save <path> -保存当前局面到path");
                System.out.println("load <path> -加载路径中保存的对局");
                System.out.println("surrender -投降");
                System.out.println("close -关闭命令提示");
                System.out.println("open -开启命令提示");
                System.out.println("unstep --虚着不落子");
            }
            int flag = manager.getState().getFlag();
            String command = null;
            if (flag == Round.BLACK) {
                command = black.sendCommand();
            } else {
                command = white.sendCommand();
            }
            checkNow = command.equals(lastCommand) && command.equals("unstep"); //出现双方都不落子, 则进行胜负判定
            boolean res = execute(command);

            lastCommand = String.valueOf(command); // 记录上一条命令
//            System.out.println("当前的记录: ");
//            for (ChessStateMomento momento: manager.getMomentoCareTaker().getMomentoList()) {
//                char[][] board = momento.getBoard();
//                for (int i = 1;i <= momento.getSize();i++) {
//                    for (int j = 1;j <= momento.getSize();j++) {
//                        System.out.print(board[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println("==========");
//            }
//            System.out.println("==========");
            if (res) break;
        }
    }

    public boolean execute(String command) {
        /*
            根据命令执行结果是否返回true, 判断是否结束程序运行
         */
        List<String> args = split(command);
        String name = args.get(0); // 命令类型
        if (name.equals("remake")) {
            manager.remake();
        } else if (name.equals("step")) {
            int x = Integer.parseInt(args.get(1));
            int y = Integer.parseInt(args.get(2));
            return manager.step(x, y);
        } else if (name.equals("regret")) {
            manager.regret();
        } else if (name.equals("save")) {
            String path = args.get(1);
            manager.save(path);
        } else if (name.equals("load")) {
            String path = args.get(1);
            manager.load(path);
        } else if (name.equals("surrender")) {
            manager.surrender();
            return true;
        } else if (name.equals("open")) {
            System.out.println("您已开启提示...");
            setHint(true);
        } else if (name.equals("close")) {
            System.out.println("您已关闭提示...");
            setHint(false);
        } else if (name.equals("unstep")) {
            if (manager.getState().getType() != GameType.WEIQI) {
                System.out.println("只有围棋才可以虚着...");
                return false;
            }
            if (checkNow) {
                manager.getState().judge();
                return true;
            }
            manager.unstep();
        } else {
            System.out.println("无效命令...");
        }
        return false;
    }

    public void setHint(boolean hint) {
        this.hint = hint;
    }

    public static List<String> split(String command) {
        /*
            解析用户输入的命令
         */
        return Arrays.asList(command.split(" "));
    }
}
