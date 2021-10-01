package Lektion_7.observer;

public interface SubjectI
{
    void registerObserver(ObserverI observer);

    ObserverI removeObserver(ObserverI observer);

    void notifyObservers();
}
