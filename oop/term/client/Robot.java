package oop.term.client;

import oop.term.backend.ChessState;
import oop.term.backend.Round;
import oop.term.backend.Symbol;

import java.util.Random;

public class Robot extends Actor{

    public Robot(String username, String password, int total, int wins) {
        super(username, password, total, wins);
    }

    @Override
    public String sendCommand(ChessState state) {
        /*
            电脑对战, 由算法产生命令
         */
        if (username.equals("一级AI")) {
            return sendTrivialCommand(state);
        } else if (username.equals("二级AI")) {
            return sendAdvancedCommand(state);
        }
        return null;
    }

    public String sendTrivialCommand(ChessState state) {
        /*
            一级AI:
            随机选择棋盘中的空处进行落子
         */
        int x = - 1, y = -1;
        Random random = new Random();
        while (true) {
            x = random.nextInt(state.getSize()) + 1;
            y = random.nextInt(state.getSize()) + 1;
            if (state.getBoard()[x][y] == Symbol.EMPTY) break;
        }
        return "step " + x + " " + y;
    }

    public String sendAdvancedCommand(ChessState state) {
        /*
            二级AI:
            根据棋盘的评分进行落子
         */
        int max_score = -1, max_x = -1, max_y = -1;
        char player = state.getFlag() == Round.BLACK ? Symbol.BLACK : Symbol.WHITE;
        for (int i = 1;i <= state.getSize();i++) {
            for (int j = 1;j <= state.getSize();j++) {
                if (state.getBoard()[i][j] == Symbol.EMPTY) {
                    char[][] temp = state.deepCopy(state.getBoard());
                    temp[i][j] = player;
                    int score = evaluatePosition(temp, player, state.getSize());
                    if (score > max_score) {
                        max_score = score;
                        max_x = i;
                        max_y = j;
                    }
                }
            }
        }
        return "step " + max_x + " " + max_y;
    }

    public int evaluatePosition(char[][] board, char player, int SIZE) {
        int score = 0;
        // 检查水平方向上的连子数量
        for (int row = 1; row <= SIZE; row++) {
            for (int col = 1; col <= SIZE - 4; col++) {
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    if (board[row][col + i] == player) {
                        count++;
                    }
                }
                score += evaluateCount(count);
            }
        }

        // 检查垂直方向上的连子数量
        for (int col = 1; col <= SIZE; col++) {
            for (int row = 1; row <= SIZE - 4; row++) {
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    if (board[row + i][col] == player) {
                        count++;
                    }
                }
                score += evaluateCount(count);
            }
        }

        // 检查主对角线方向上的连子数量
        for (int row = 1; row <= SIZE - 4; row++) {
            for (int col = 1; col <= SIZE - 4; col++) {
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    if (board[row + i][col + i] == player) {
                        count++;
                    }
                }
                score += evaluateCount(count);
            }
        }

        // 检查副对角线方向上的连子数量
        for (int row = 5; row <= SIZE; row++) {
            for (int col = 1; col <= SIZE - 4; col++) {
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    if (board[row - i][col + i] == player) {
                        count++;
                    }
                }
                score += evaluateCount(count);
            }
        }

        return score;
    }

    private int evaluateCount(int count) {
        /*
            根据连子数量评估分数
         */
        if (count >= 5) {
            return 100000;  // 五连的分数
        } else if (count == 4) {
            return 10000;  // 活四的分数
        } else if (count == 3) {
            return 1000;  // 活三的分数
        } else if (count == 2) {
            return 100;  // 活二的分数
        } else {
            return 0;
        }
    }
}
