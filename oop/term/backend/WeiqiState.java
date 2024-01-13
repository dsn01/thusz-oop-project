package oop.term.backend;

public class WeiqiState extends ChessState{

    public WeiqiState(int size) {
        super(size, GameType.WEIQI);
    }

    @Override
    public boolean step(int x, int y) {
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

        // 3. 检查是否有气, 若无气, 则不能落子
        board[x][y] = getFlag() == Round.BLACK ? Symbol.BLACK : Symbol.WHITE;
        if (countLiberties(board, x, y) == 0) {
            board[x][y] = Symbol.EMPTY;
            System.out.println("落子处无气, 禁区!");
            return false;
        }
        board[x][y] = Symbol.EMPTY;

        // 4. 摆放
        place(x, y);

        // 5. 提子
        pullChess(board, x, y);

        // 6. 打印
        print();
        return true;
    }

    @Override
    public boolean check() {
        /*
            检查对局是否结束
         */
        boolean isFull = true;
        int size = getSize();
        char[][] board = getBoard();
        int i = 1;
        while (i < size * size) {
            if (board[i / size][i % size] == Symbol.EMPTY) {
                isFull = false;
                break;
            }
            i++;
        }
        if (isFull) return true;
        return false;
    }

    public void judge() {
        /*
            进行围棋胜负判定
         */
        // 假设棋盘上没有空位，即游戏已经结束
        // 遍历棋盘，统计黑子和白子的数量
        int black = 0, white = 0;
        char[][] board = getBoard();
        for (int i = 1; i <= getSize(); i++) {
            for (int j = 1; j <= getSize(); j++) {
                if (board[i][j] == Symbol.BLACK) {
                    black++;
                } else if (board[i][j] == Symbol.WHITE) {
                    white++;
                }
            }
        }
        // 比较黑子和白子的数量，输出胜者
        if (black > white) {
            System.out.println("黑方胜利!");
        } else if (black < white) {
            System.out.println("白方胜利!");
        } else {
            System.out.println("平局!");
        }
    }

    private void pullChess(char[][] board, int x, int y) {
        /*
            提子, 由于在(x,y)处落子可能造成邻居敌方棋子没有气
         */
        int size = getSize();
        boolean[][] visited = new boolean[size + 1][size + 1];
        char target = getFlag() == Round.BLACK ? Symbol.BLACK : Symbol.WHITE;
        checkNeighbor(board, x - 1, y, visited, target);
        checkNeighbor(board, x, y + 1, visited, target);
        checkNeighbor(board, x + 1, y, visited, target);
        checkNeighbor(board, x, y - 1, visited, target);
    }

    private void checkNeighbor(char[][] board, int x, int y, boolean[][] visited, char target) {
        /*
            检查邻居是否会因为新引入的棋子而气为0
         */
        if (!isValidPosition(x, y) || board[x][y] != target) return;
        countDfs(board, x, y, visited, target, true);
    }

    private boolean isValidPosition(int x, int y) {
        /*
            判断一个位置是否在棋盘上
         */
        return x >= 1 && x <= getSize() && y >= 1 && y <= getSize();
    }

    private int countLiberties(char[][] board, int x, int y) {
        /*
            给定棋盘, 计算(x, y)处棋子气的数量
         */
        if (!isValidPosition(x, y) || board[x][y] == Symbol.EMPTY) {
            return 0;
        }
        int size = getSize();
        boolean[][] visited = new boolean[size + 1][size + 1];
        return countDfs(board, x, y, visited, board[x][y], false);
    }

    private int countDfs(char[][] board, int x, int y, boolean[][] visited, char target, boolean isPull) {
        /*
            计算连通块的气的数量
         */
        if (!isValidPosition(x, y) || visited[x][y]) return 0;
        visited[x][y] = true;
        if (board[x][y] == Symbol.EMPTY) return 1;
        if (board[x][y] != target) return 0;
        int res = 0;

        // 上下左右四个方向dfs
        res += countDfs(board, x - 1, y, visited, target, isPull);
        res += countDfs(board, x + 1, y, visited, target, isPull);
        res += countDfs(board, x, y - 1, visited, target, isPull);
        res += countDfs(board, x, y + 1, visited, target, isPull);
        if (isPull && res == 0) board[x][y] = Symbol.EMPTY;
        return res;
    }
}
