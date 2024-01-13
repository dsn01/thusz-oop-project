package oop.term.backend;

public class HeiBaiQiState extends ChessState{
    public HeiBaiQiState(int size) {
        super(size, GameType.HEIBAIQI);
    }

    @Override
    public void remake() {
        /*
            重新开始对局
         */
        for (int i = 1;i <= getSize();i++) {
            for (int j = 1;j <= getSize();j++) {
                getBoard()[i][j] = Symbol.EMPTY;
            }
        }
        getBoard()[4][4] = Symbol.WHITE;
        getBoard()[4][5] = Symbol.BLACK;
        getBoard()[5][5] = Symbol.WHITE;
        getBoard()[5][4] = Symbol.BLACK;
        setFlag(Round.BLACK);
        setRegretTimesOfBlack(0);
        setRegretTimesOfWhite(0);
        print();
    }

    @Override
    public boolean step(int x, int y) {
        char player = getFlag() == Round.BLACK ? Symbol.BLACK : Symbol.WHITE;
        char opposite = getFlag() == Round.BLACK ? Symbol.WHITE : Symbol.BLACK;
        // 1. 检查是否越界
        if (!isValidPosition(x, y)) {
            System.out.println("输入位置不合法!");
            return false;
        }

        // 2. 检查是否可摆放
        char[][] board = getBoard();
        if (board[x][y] != Symbol.EMPTY) {
            System.out.println("该位置非空(已经有棋子), 请重新摆放!");
            return false;
        }

        // 3. 检查是否在端点的对面, 即必须翻转对方的棋子才能走
        if(!heibaiCheck(x, y, player, opposite)) {
            System.out.println("必须翻转对方的棋子才能落子!");
            return false;
        }

        // 4. 摆放
        place(x, y);

        // 5. 将对手被夹住的棋子翻转
        twist(x, y, player, opposite);

        // 6. 打印
        print();

        return true;
    }

    public boolean heibaiCheck(int x, int y, char player, char opposite) {
        // 检查上下左右和左上、右上、左下、右下
        int dx1[] = {-1, 1, 0, 0, -1, -1, 1, 1};
        int dx2[] = {-2, 2, 0, 0, -2, -2, 2, 2};
        int dy1[] = {0, 0, -1, 1, -1, 1, -1, 1};
        int dy2[] = {0, 0, -2, 2, -2, 2, -2, 2};
        for (int i = 0; i < dx1.length;i++) {
            int x1 = x + dx1[i], y1 = y + dy1[i];
            int x2 = x + dx2[i], y2 = y + dy2[i];
            if (isValidPosition(x1, y1) && isValidPosition(x2, y2) && getBoard()[x1][y1] == opposite && getBoard()[x2][y2] == player) {
                return true;
            }
        }
        return false;
    }

    public void twist(int x, int y, char player, char opposite) {
        // 检查上下左右和左上、右上、左下、右下
        int dx1[] = {-1, 1, 0, 0, -1, -1, 1, 1};
        int dx2[] = {-2, 2, 0, 0, -2, -2, 2, 2};
        int dy1[] = {0, 0, -1, 1, -1, 1, -1, 1};
        int dy2[] = {0, 0, -2, 2, -2, 2, -2, 2};
        for (int i = 0; i < dx1.length;i++) {
            int x1 = x + dx1[i], y1 = y + dy1[i];
            int x2 = x + dx2[i], y2 = y + dy2[i];
            if (isValidPosition(x1, y1) && isValidPosition(x2, y2) && getBoard()[x1][y1] == opposite && getBoard()[x2][y2] == player) {
                getBoard()[x1][y1] = player;
            }
        }
    }

    @Override
    public boolean check() {
        /*
            检查对局是否结束, 即检查是否下满或者全为某一方的棋子
         */

        boolean isFull = true;
        int blackCount = 0, whiteCount = 0;
        for (int i = 1;i <= getSize();i++) {
            for (int j = 1;j <= getSize();j++) {
                if (getBoard()[i][j] == Symbol.EMPTY) isFull = false;
                else if (getBoard()[i][j] == Symbol.BLACK) blackCount += 1;
                else if (getBoard()[i][j] == Symbol.WHITE) whiteCount += 1;
            }
        }
        return isFull || blackCount == 0 || whiteCount == 0;
    }

    @Override
    public void judge() {

    }

    private boolean isValidPosition(int x, int y) {
        /*
            判断一个位置是否在棋盘上
         */
        return x >= 1 && x <= getSize() && y >= 1 && y <= getSize();
    }
}
