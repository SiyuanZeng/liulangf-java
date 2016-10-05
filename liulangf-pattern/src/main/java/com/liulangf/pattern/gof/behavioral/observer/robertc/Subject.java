package com.liulangf.pattern.gof.behavioral.observer.robertc;

import java.util.Iterator;
import java.util.Vector;

public class Subject {
	
	private Vector<Observer> itsObservers = new Vector<Observer>();
	
	protected void notifyObserver() {
		Iterator<Observer> i = itsObservers.iterator();
		while (i.hasNext()) {
			Observer observer = i.next();
			observer.update();
		}
	}
	
	public void registerObserver(Observer observer) {
		itsObservers.add(observer);
	}
	

}
