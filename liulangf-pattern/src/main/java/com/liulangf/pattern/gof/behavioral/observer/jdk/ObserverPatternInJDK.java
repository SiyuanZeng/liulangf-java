package com.liulangf.pattern.gof.behavioral.observer.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author liulangf
 *
 */
public class ObserverPatternInJDK {
	
	private final static transient Logger LOGGER = LoggerFactory.getLogger(ObserverPatternInJDK.class);
	
	class Subject extends java.util.Observable {
		private String message;
		
		public Subject(String message) {
			setMessage(message);
		}
		
		public Subject() {
			this("Hello World");
		}
		
		public void setMessage(String message) {
			this.message = message;
			this.setChanged();
		}
		
		public String getMessage() {
			return this.message;
		}
	}
	
	class MyListener implements java.util.Observer {
		public void update(java.util.Observable subject, Object event) {
			Subject normal = (Subject)subject;
			String message = normal.getMessage();
			LOGGER.info("===={}--{}====", message, event);
		}
	}
	
	/**
	 * Observer in JDK supports both pull and push model observer pattern.
	 * 
	 * @param args
	 */
	public static void main(String...args) {
		LOGGER.info("=================");
		ObserverPatternInJDK observer = new ObserverPatternInJDK();
		Subject subject = observer.new Subject();
		
		//subscribe listeners
		subject.addObserver(observer.new MyListener());
		
		//publish event
		subject.notifyObservers("Changed");
		
		subject.setMessage("&&&&&&&&");
		subject.notifyObservers("********");
	}

}
