package oop.ex_7.problemOne;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements AbstractSubject{
    List<AbstractObserver> observers = null;

    public ConcreteSubject() {
        observers = new ArrayList<AbstractObserver>();
    }
    @Override
    public void addObserver(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(AbstractObserver observer) {
        if (observers.contains(observer)) observers.remove(observer);
    }

    @Override
    public void notification(String company, String position, String location) {
        for (AbstractObserver observer: observers) observer.update(company, position, location);
    }
}
