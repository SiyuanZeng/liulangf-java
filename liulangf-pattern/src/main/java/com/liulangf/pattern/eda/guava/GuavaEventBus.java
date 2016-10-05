package com.liulangf.pattern.eda.guava;


import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Glossary:
 * <ul>
 *   <li>Event : Any object that may be posted to a bus.</li>
 *   <li>Subscribing : The act of registering a listener with an EventBus, so that its handler methods will receive events.</li>
 *   <li>Listener : An object that wishes to receive events, by exposing handler methods.</li>
 *   <li>Handler method : A public method that the EventBus should use to deliver posted events. Handler methods are marked by the Subscribe annotation.</li>
 *   <li>Posting an event : Making the event available to any listeners through the EventBus.</li>
 * </ul>
 * 
 * 
 *
 * @author liulangf
 *
 */
public class GuavaEventBus {

	
	public static void main(String...args) {
		EventBus bus = new EventBus();
		EventListener el = new EventListener();
		bus.register(el);
		System.out.println("The main thread is : " + Thread.currentThread().getName());
		bus.post("good boy");
		bus.unregister(el);
		AsyncEventBus abus = new AsyncEventBus(Executors.newCachedThreadPool());
		abus.register(el);
		abus.post("async good boy");
		//
	}
	
	static class EventListener {
		@Subscribe
		public void handleEvent(String hello) {
			System.out.println("Handling event: [" + hello + "] in thread [" + Thread.currentThread().getName() + "]");
		}
	}
}
