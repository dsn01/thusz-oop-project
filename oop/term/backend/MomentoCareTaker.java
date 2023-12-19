package oop.term.backend;

import java.util.ArrayList;

public class MomentoCareTaker extends SerializableObject{
    /*
        记录和维护棋局状态变化过程
     */
    private ArrayList<ChessStateMomento> momentoList;

    public MomentoCareTaker() {
        this.momentoList = new ArrayList<>();
    }

    public void addMomento(ChessStateMomento momento) {
        /*
            每走一步就保存一步
         */
        momentoList.add(momento);
    }

    public void removeLastMomento() {
        /*
            删除最后一步
         */
        momentoList.remove(momentoList.size() - 1);
    }

    public void remake() {
        momentoList = new ArrayList<>();
    }

    public ChessStateMomento getLastMomento() {
        /*
            获取最后一步
         */
        return momentoList.get(momentoList.size() - 1);
    }

    public ArrayList<ChessStateMomento> getMomentoList() {
        return momentoList;
    }

    public void setMomentoList(ArrayList<ChessStateMomento> momentoList) {
        this.momentoList = momentoList;
    }
}
