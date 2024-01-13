package oop.term.backend;

public class Manager {
    /*
        负责管理整个棋局, 完成各类行为, 响应用户命令
     */
    private ChessState state;
    private MomentoCareTaker momentoCareTaker;

    public Manager(ChessState state, MomentoCareTaker momentoCareTaker) {
        this.state = state;
        this.momentoCareTaker = momentoCareTaker;
        this.momentoCareTaker.addMomento(state.save()); // 加入初始状态
    }

    public void unstep() {
        if (state.getFlag() == Round.BLACK) {
            System.out.println("黑方不落子...");
        } else {
            System.out.println("白方不落子...");
        }
        state.unstep();
        momentoCareTaker.addMomento(state.save());
    }

    public boolean step(int x, int y) {
        /*
            落子成功则记录局面信息
         */
        if (state.step(x, y)) {
            momentoCareTaker.addMomento(state.save());
            boolean isOver = state.check();
            if (isOver) {
                if (momentoCareTaker.getMomentoList().size() == state.getSize() * state.getSize()) {
                    System.out.println("平局...");
                } else if (state.getFlag() == Round.BLACK) {
                    System.out.println("白子获胜...");
                } else {
                    System.out.println("黑子获胜...");
                }
                return true;
            }
        }
        return false;
    }

    public void regret() {
        /*
            悔棋
         */
        if (momentoCareTaker.getMomentoList().size() < 2) {
            System.out.println("悔棋操作不合法...");
            return;
        }
        int flag = state.getFlag();
        if (flag == Round.BLACK && state.getRegretTimesOfBlack() == 3) {
            System.out.println("黑棋已经悔棋三次...不能再悔棋了");
            return;
        }
        if (flag == Round.WHITE && state.getRegretTimesOfWhite() == 3) {
            System.out.println("白棋已经悔棋三次...不能再悔棋了");
            return;
        }
        // 1. 回退两步
        momentoCareTaker.removeLastMomento();
        momentoCareTaker.removeLastMomento();
        // 2. 记录悔棋次数
        ChessStateMomento momento = momentoCareTaker.getLastMomento();
        int regretTimesOfBlack = momento.getRegretTimesOfBlack();
        int regretTimesOfWhite = momento.getRegretTimesOfWhite();
        if (flag == Round.BLACK) {
            regretTimesOfBlack += 1;
            momento.setRegretTimesOfBlack(regretTimesOfBlack);
        } else {
            regretTimesOfWhite += 1;
            momento.setRegretTimesOfWhite(regretTimesOfWhite);
        }
        // 3. 恢复局面
        state.restore(momento);
    }

    public void surrender() {
        /*
            认输
         */
        if (state.getFlag() == Round.BLACK) {
            System.out.println("黑方认输, 白子获胜");
        } else {
            System.out.println("白方认输, 黑子获胜");
        }
    }

    public void remake() {
        System.out.println("重新开始对局...");
        state.remake();
        momentoCareTaker.remake();
        momentoCareTaker.addMomento(state.save()); // 加入初始状态
    }

    public void saveAll(String path) {
        momentoCareTaker.save(path);
        System.out.println("保存回放成功...");
    }

    public void save(String path) {
        /*
            保存当前棋局到指定路径
         */
        momentoCareTaker.getLastMomento().save(path);
        System.out.println("保存局面成功...");
    }

    public void replay(String path) {
        /*
            回放对局
         */
        if (!Utils.isFileOrDirectoryExists(path)) {
            System.out.println("路径不存在...");
            return;
        }
        momentoCareTaker = (MomentoCareTaker) MomentoCareTaker.read(path);
        int idx = 1;
        for (ChessStateMomento momento: momentoCareTaker.getMomentoList()) {
            System.out.println("======Step " + idx + "======");
            state.restore(momento);
            idx += 1;
        }
    }

    public void load(String path) {
        /*
            加载棋局
         */
        if (!Utils.isFileOrDirectoryExists(path)) {
            System.out.println("路径不存在...");
            return;
        }
        ChessStateMomento momento = (ChessStateMomento) ChessStateMomento.read(path);
        if (momento.getType() != state.getType()) {
            System.out.println("加载的棋局类型不一致...");
            return;
        }
        if (momento.getSize() != state.getSize()) {
            System.out.println("加载的棋盘大小不一致...");
            return;
        }
        state.restore(momento);
        momentoCareTaker.remake(); // 新加载对局后, 原先的对局信息直接删除
    }

    public ChessState getState() {
        return state;
    }

    public MomentoCareTaker getMomentoCareTaker() {
        return momentoCareTaker;
    }
}
