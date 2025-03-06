package ColtExp.Observer;

import java.util.ArrayList;

public class Observable {
    private final ArrayList<Observer> observers = new ArrayList<>();

    public Observable() {
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}