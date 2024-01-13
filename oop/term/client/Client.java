package oop.term.client;

import oop.term.backend.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Client {
    private Manager manager;
    private Scanner scanner = new Scanner(System.in);
    private boolean hint = true;
    private boolean checkNow = false;
    private int type;
    private boolean isRecord = false;
    private String unameRecord = null;
    private Actor black;
    private Actor white;

    public Actor getActor() {
        if (this.type == GameType.WUZIQI) {
            System.out.println("请选择: 0. 游客 1. 用户 2. 一级AI 3. 二级AI");
        } else {
            System.out.println("请选择: 0. 游客 1. 用户");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 0) {
            return new Person("游客", "", 0, 0);
        } else if (choice == 1) {
            System.out.println("请输入用户名: ");
            String username = scanner.nextLine();
            System.out.println("请输入密码: ");
            String password = scanner.nextLine();
            File file = new File(username + ".info");
            int total = 0;
            int wins = 0;
            try {
                if (file.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line1 = reader.readLine().strip();
                    String line2 = reader.readLine().strip();
                    while (!line1.equals(password)) {
                        System.out.println("密码错误...请重新输入: ");
                        password = scanner.nextLine();
                    }
                    String[] numbers = line2.split(" ");
                    total = Integer.parseInt(numbers[0]);
                    wins = Integer.parseInt(numbers[1]);
                } else {
                    System.out.println("用户不存在, 自动注册");
                    file.createNewFile();
                    FileWriter writer = new FileWriter(file);
                    writer.write(password + "\n");
                    writer.write("0 0" + "\n");
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            return new Person(username, password, total, wins);
        } else if (choice == 2 && this.type == GameType.WUZIQI) {
            return new Robot("一级AI", "", 0, 0);
        } else if (choice == 3 && this.type == GameType.WUZIQI) {
            return new Robot("二级AI", "", 0, 0);
        }
        return null;
    }

    public void run() {
        // 初始化游戏
        System.out.println("====游戏对战平台已开启====");
        System.out.println("请选择游戏类型: 0. 五子棋 1. 围棋 2. 黑白棋");
        this.type = scanner.nextInt();
        System.out.println("请输入棋盘大小: ");
        int size = scanner.nextInt();
        size = Math.max(Constant.MIN_SIZE, Math.min(Constant.MAX_SIZE, size));
        if (this.type == GameType.WUZIQI) {
            manager = new Manager(new WuziState(size), new MomentoCareTaker());
            System.out.println("=====你选择的是五子棋=====");
        } else if (this.type == GameType.WEIQI) {
            manager = new Manager(new WeiqiState(size), new MomentoCareTaker());
            System.out.println("=====你选择的是围棋=====");
        } else if (this.type == GameType.HEIBAIQI) {
            manager = new Manager(new HeiBaiQiState(size), new MomentoCareTaker());
            System.out.println("=====你选择的是黑白棋=====");
        }
        // 创建对局双方的Actor, 根据用户命令开始游戏
        System.out.println("===请选择黑棋用户===");
        black = getActor();
        System.out.println("===请选择白棋用户===");
        white = getActor();
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
                System.out.println("record --录像");
                System.out.println("replay --回放");
            }
            int flag = manager.getState().getFlag();
            String command = null;
            if (flag == Round.BLACK) {
                command = black.sendCommand(manager.getState());
            } else {
                command = white.sendCommand(manager.getState());
            }
            checkNow = command.equals(lastCommand) && command.equals("unstep"); //出现双方都不落子, 则进行胜负判定
            System.out.println("===黑方: ");
            System.out.println("用户名: " + black.getUsername());
            System.out.println("总场次: " + black.getTotal());
            System.out.println("胜场: " + black.getWins());
            System.out.println("===白方: ");
            System.out.println("用户名: " + white.getUsername());
            System.out.println("总场次: " + white.getTotal());
            System.out.println("胜场: " + white.getWins());
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
            if (res) {
                if (manager.getState().getFlag() == Round.BLACK) {
                    // 白子获胜
                    white.saveToLocal(true);
                    black.saveToLocal(false);
                } else if (manager.getState().getFlag() == Round.WHITE) {
                    // 黑子获胜
                    white.saveToLocal(false);
                    black.saveToLocal(true);
                }
                if (isRecord) {
                    // 保存录像, 与用户绑定
                    manager.saveAll(unameRecord + ".record");
                }
                break;
            }
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
        } else if (name.equals("record")){
            this.isRecord = true;
            if (manager.getState().getFlag() == Round.BLACK) {
                this.unameRecord = black.username;
            } else {
                this.unameRecord = white.username;
            }
        } else if (name.equals("replay")) {
            System.out.println("即将回放对局...");
            if (manager.getState().getFlag() == Round.BLACK) {
                manager.replay(black.username + ".record");
            } else {
                manager.replay(white.username + ".record");
            }
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
