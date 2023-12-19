package oop.term.backend;

public class UnitTest {
    public static void main(String[] args) {
        char[][] board = new char[7][7];
        for (int i = 1;i <= 6;i++) {
            for (int j = 1;j <= 6;j++) {
                board[i][j] = Symbol.EMPTY;
            }
        }
        board[1][2] = Symbol.BLACK;
        board[1][3] = Symbol.BLACK;
        board[2][1] = Symbol.BLACK;
        board[2][4] = Symbol.BLACK;
        board[3][1] = Symbol.BLACK;
        board[3][4] = Symbol.BLACK;
        board[4][2] = Symbol.BLACK;
        board[4][3] = Symbol.BLACK;

        board[2][2] = Symbol.WHITE;
        board[2][3] = Symbol.WHITE;
        board[3][2] = Symbol.WHITE;
        board[3][3] = Symbol.WHITE;

        board[5][2] = Symbol.BLACK;
        board[6][3] = Symbol.BLACK;
        board[5][4] = Symbol.BLACK;
        board[5][3] = Symbol.WHITE;

        for (int i = 1;i <= 6;i++) {
            for (int j = 1;j <= 6;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        pullChess(board, 4, 3);

        System.out.println("提子后: ");
        for (int i = 1;i <= 6;i++) {
            for (int j = 1;j <= 6;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static int getSize() {
        return 6;
    }

    private static int getFlag() {
        return Round.BLACK;
    }

    private static boolean isValidPosition(int x, int y) {
        /*
            判断一个位置是否在棋盘上
         */
        return x >= 1 && x <= getSize() && y >= 1 && y <= getSize();
    }

    private static void pullChess(char[][] board, int x, int y) {
        /*
            提子, 由于在(x,y)处落子可能造成邻居敌方棋子没有气
         */
        int size = getSize();
        boolean[][] visited = new boolean[size + 1][size + 1];
        char target = getFlag() == Round.BLACK ? Symbol.WHITE : Symbol.BLACK;
        checkNeighbor(board, x - 1, y, visited, target);
        checkNeighbor(board, x, y + 1, visited, target);
        checkNeighbor(board, x + 1, y, visited, target);
        checkNeighbor(board, x, y - 1, visited, target);
    }

    private static void checkNeighbor(char[][] board, int x, int y, boolean[][] visited, char target) {
        if (!isValidPosition(x, y) || board[x][y] != target) return;
        countDfs(board, x, y, visited, target, true);
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

    private static int countDfs(char[][] board, int x, int y, boolean[][] visited, char target, boolean isPull) {
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
