package com.mic.design.oberver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Subject
 * Observerable
 */

@SuppressWarnings("unused")
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if(this.state == state){
            return;
        }else {
            this.state=state;
            notifyAllDataObserber();
        }
    }

    public void attach(Observer observer){
            observers.add(observer);
    }

    public void detach(Observer observer){
        Iterator iterator =observers.iterator();
        while (iterator.hasNext()){
            Observer ob = (Observer) iterator.next();
            if(ob.equals(observer)){
                iterator.remove();
            }
        }
    }

    public void notifyAllDataObserber(){
        observers.stream().forEach(observer -> observer.update());
    }
}
