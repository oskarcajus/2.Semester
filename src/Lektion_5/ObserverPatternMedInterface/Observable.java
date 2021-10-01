package Lektion_5.ObserverPatternMedInterface;

public interface Observable {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();

}
