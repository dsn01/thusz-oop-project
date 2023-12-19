package oop.ex_7.problemOne;

public interface AbstractSubject {
    public void addObserver(AbstractObserver observer);
    public void removerObserver(AbstractObserver observer);
    public void notification(String company, String position, String location);
}
