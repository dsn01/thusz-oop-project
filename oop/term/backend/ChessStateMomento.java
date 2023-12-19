package oop.term.backend;

public class ChessStateMomento extends SerializableObject {
    /*
        棋局状态备忘录对象
     */
    private int flag; // 0表示黑棋回合, 1表示白棋回合
    private int type; // 棋局类型
    private char[][] board; // 棋局
    private int size; // 棋盘大小
    private int regretTimesOfBlack; // 黑棋悔棋次数
    private int regretTimesOfWhite; // 白棋悔棋次数

    public ChessStateMomento(int flag, int type, char[][] board, int size, int regretTimesOfBlack, int regretTimesOfWhite) {
        this.flag = flag;
        this.type = type;
        this.board = board;
        this.size = size;
        this.regretTimesOfBlack = regretTimesOfBlack;
        this.regretTimesOfWhite = regretTimesOfWhite;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public char[][] getBoard() {
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
}
