import java.util.ArrayList;

public class Subject {
	private ArrayList<Observer> observers;
	
	public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer o : observers){
            o.update();
        }
    }
}
