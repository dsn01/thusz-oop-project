package oop.term.backend;

public class WuziState extends ChessState{
    private int WIN_COUNT = 5;
    public WuziState(int size) {
        super(size, GameType.WUZIQI);
    }

    @Override
    public boolean step(int x, int y) {
        /*
            在(x, y)摆放棋子
         */
        // 1. 检查是否越界
        int size = getSize();
        if (x < 1 || x > size || y < 1 || y > size) {
            System.out.println("输入位置不合法!");
            return false;
        }
        // 2. 检查是否可摆放
        char[][] board = getBoard();
        if (board[x][y] != Symbol.EMPTY) {
            System.out.println("该位置非空(已经有棋子), 请重新摆放!");
            return false;
        }
        // 3. 放置棋子
        place(x, y);
        print();
        return true;
    }

    @Override
    public boolean unstep() {
        System.out.println("不会执行到...");
        return false;
    }

    @Override
    public boolean check() {
        /*
            检查是否对局结束
         */
        int size = getSize();
        char[][] board = getBoard();
        int flag = getFlag();
        // 如果当前回合为黑棋，则需要检查白棋是否构成五子(因为白棋刚下完); 反之, 检查黑棋
        char pivot = flag == Round.BLACK ? Symbol.WHITE : Symbol.BLACK;
        // 获取最后一次落子的位置进行判断, 减少搜索量
        int lastX = getLastX();
        int lastY = getLastY();

        // 1. 判断水平方向是否有五子相连
        int count = 1;
        int left = lastY - 1;
        while (left >= 1 && board[lastX][left] == pivot) {
            count++;
            left--;
        }
        int right = lastY + 1;
        while (right <= size && board[lastX][right] == pivot) {
            count++;
            right++;
        }
        if (count >= WIN_COUNT) return true;

        // 2. 判断垂直方向是否有五子相连
        count = 1;
        int top = lastX - 1;
        while (top >= 1 && board[top][lastY] == pivot) {
            count++;
            top--;
        }
        int bottom = lastX + 1;
        while (bottom <= size && board[bottom][lastY] == pivot) {
            count++;
            bottom++;
        }
        if (count >= WIN_COUNT) return true;

        // 3. 判断是否有正对角线五子相连
        count = 1;
        left = lastX + 1;
        bottom = lastY - 1;
        while (left <= size && bottom >= 1 && board[left][bottom] == pivot) {
            count++;
            left++;
            bottom--;
        }
        right = lastX - 1;
        top = lastY + 1;
        while (right >= 1 && top <= size && board[right][top] == pivot) {
            count++;
            right--;
            top++;
        }
        if (count >= WIN_COUNT) return true;

        // 4. 判断是否有反对角线五子相连
        count = 1;
        right = lastY + 1;
        bottom = lastX + 1;
        while (right <= size && bottom <= size && board[bottom][right] == pivot) {
            count++;
            right++;
            bottom++;
        }
        left = lastY - 1;
        top = lastX - 1;
        while (left >= 1 && top >= 1 && board[top][left] == pivot) {
            count++;
            left--;
            top--;
        }
        if (count >= WIN_COUNT) return true;
        // 5. 检查是否下满
        boolean isFull = true;
        int i = 1;
        while (i < size * size) {
            if (board[i / size][i % size] == Symbol.EMPTY) {
                isFull = false;
                break;
            }
            i++;
        }
        if (isFull) return true;
        // 5. 检查完没有五子相连, 对局继续
        return false;
    }

    @Override
    public void judge() {
        System.out.println("五子棋在check中检查对局结束并判断胜负...");
    }
}
