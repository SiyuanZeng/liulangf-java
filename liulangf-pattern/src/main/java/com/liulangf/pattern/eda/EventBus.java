package com.liulangf.pattern.eda;

/**
 * 
 * http://www.eventbus.org/
 * http://eventbus.dev.java.net
 * http://www.eventbus.org/pivot.html
 * https://code.google.com/p/simpleeventbus/
 * http://msdn.microsoft.com/library/en-us/dnpag/html/ArchMessageBus.asp
 *
 * @author liulangf
 *
 */
public interface EventBus {
	
	/**
	 * https://code.google.com/p/simpleeventbus/
	 * 
	 * <p>An event bus is one such pattern where objects can "subscribe" to receive certain specific "events" 
	 * from the bus. As an event is "published" to the event bus, it will be propagated[传播] to any subscriber 
	 * which is interested in the event type. This allows each component to couple solely to the event bus 
	 * itself and not directly with each other.
	 * 
	 * <p>An event bus can be thought of as a replacement for the observer pattern, where in the observer pattern, 
	 * each component is observing an observable directly. In the event bus pattern, each component simply 
	 * subscribes to the event bus and waits for its event notification methods to be invoked when interesting 
	 * events have occurred. In this way, an event bus can be thought of like the observer pattern with an 
	 * extra layer of decoupling.
	 * 
	 */
	void event_bus_pattern();

}
