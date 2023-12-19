package oop.term.backend;


import java.util.Arrays;

public abstract class ChessState {
    /*
        通用的棋局状态信息, 采用抽象类实现, 仅用于继承
     */
    private int flag; // 当前是哪一方的回合, 见Round.java
    private int type; // 棋局类型
    private char[][] board; // 棋局
    private int size; // 棋盘大小
    private int regretTimesOfBlack; // 黑棋悔棋次数
    private int regretTimesOfWhite; // 白棋悔棋次数
    private int lastX; // 记录最后一次落子的位置方便判断对局是否结束
    private int lastY;

    public ChessState(int size, int type) {
        this.size = size;
        this.type = type;
        this.board = new char[size + 1][size + 1];
        System.out.println("对局初始化完成...");
        remake();
    }

    public abstract boolean step(int x, int y); // 落子, 需要检查合法性并修改棋局状态

    public boolean unstep() {
        /*
            虚着, 只有围棋可以虚着, 只交换下棋方
         */
        flag = 1 - flag;
        return true;
    }

    public abstract boolean check(); // 检查对局是否结束

    public abstract void judge(); // 围棋特有的判断胜负

    public void place(int x, int y) {
        /*
            落子
         */
        board[x][y] = flag == 0 ? Symbol.BLACK : Symbol.WHITE;
        flag = 1 - flag;
        lastX = x;
        lastY = y;
    }

    public void remake() {
        /*
            重新开始对局
         */
        for (int i = 1;i <= size;i++) {
            for (int j = 1;j <= size;j++) {
                board[i][j] = Symbol.EMPTY;
            }
        }
        flag = Round.BLACK;
        regretTimesOfBlack = 0;
        regretTimesOfWhite = 0;
        print();
    }

    public void print() {
        /*
            打印当前局面
         */
        for (int i = 1;i <= size;i++) {
            for (int j = 1;j <= size;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public ChessStateMomento save() {
        /*
            记录当前局面
         */
        return new ChessStateMomento(flag, type, deepCopy(board), size, regretTimesOfBlack, regretTimesOfBlack);
    }

    public char[][] deepCopy(char[][] original) {
        if (original == null) return null;
        char[][] copy = new char[original.length][];
        for (int i = 0;i < original.length;i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }

    public void restore(ChessStateMomento momento) {
        /*
            恢复局面
         */
        this.flag = momento.getFlag();
        this.board = deepCopy(momento.getBoard());
        this.regretTimesOfBlack = momento.getRegretTimesOfBlack();
        this.regretTimesOfWhite = momento.getRegretTimesOfWhite();
        print();
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public char[][] getBoard() { // 注意此处的深拷贝, 否则将出现重大BUG
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRegretTimesOfBlack() {
        return regretTimesOfBlack;
    }

    public void setRegretTimesOfBlack(int regretTimesOfBlack) {
        this.regretTimesOfBlack = regretTimesOfBlack;
    }

    public int getRegretTimesOfWhite() {
        return regretTimesOfWhite;
    }

    public void setRegretTimesOfWhite(int regretTimesOfWhite) {
        this.regretTimesOfWhite = regretTimesOfWhite;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLastX() {
        return lastX;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }
}
