package model.observerpattern;
import java.util.ArrayList;

// class to keep track of/know its observers
public class Subject {
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer o : observers){
            o.update(this);
        }
    }
}
