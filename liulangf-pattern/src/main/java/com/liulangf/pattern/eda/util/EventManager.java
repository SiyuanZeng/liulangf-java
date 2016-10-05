package com.liulangf.pattern.eda.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Generic event manager class. Events are string based rather than being
 * enumerations which would have implied a central register of events. When
 * events are strings, only the negotiating classes needs to know about the
 * events exists. It is transparent also to the EventManager who only
 * delegates the events. <p> A potential problem with string based events are
 * that there might be name conflicts. In a large system, one might consider
 * prefixing the event names to avoid conflicts. If this seems to become a
 * problem, the system is probably bad designed anyway; The number of different
 * event types should be kept low. <p> The listener class must implement the
 * EventListener interface which implies the update() method. The listener class
 * register itself in the EventManager by: 
 * 
 * <pre>
 *     EventManager.getInstance().addListener ("EventName", this); 
 * </pre> 
 * 
 * The source class of the event will call: 
 * <pre> 
 *     EventManager.getInstance().notify("EventName", object, data); 
 * </pre> 
 * and the EventManager will then call the update() method of every listener.
 *  
 * <p> 
 * The definition of <em>object</em> and <em>data</em> is purely up to the involved classes. 
 * Typically <em>object</em> will be the source of the event (the <em>created</em> object for a "Create"
 * event, the <em>deleted</em> object for a "Delete" event and so forth.) The
 * additinal <em>data</em> object is for convenience only and will often be
 * null.
 * 
 * @author <a href="mailto:info@geosoft.no">GeoSoft</a>
 */
public class EventManager {
	private static EventManager instance_ = null;

	// String -> Collection of WeakRef (EventListener)
	private HashMap<String, Collection<WeakReference<EventListener>>> listeners_; 

	/**
	 * Return the sole instance of the class.
	 * 
	 * @return The EventManager singelton.
	 */
	public static EventManager getInstance() {
		if (instance_ == null)
			instance_ = new EventManager();
		return instance_;
	}

	/**
	 * Create the event manager instance.
	 */
	private EventManager() {
		listeners_ = new HashMap<String, Collection<WeakReference<EventListener>>>();
	}

	/**
	 * Add a listener.
	 * 
	 * @param eventName
	 *            The event the listener will listen to.
	 * @param eventListener
	 *            The event listener object itself.
	 */
	public void addListener(String eventName, EventListener eventListener) {
		// Check if this is a new event name
		Collection<WeakReference<EventListener>> eventListeners = listeners_.get(eventName);
		if (eventListeners == null) {
			eventListeners = new ArrayList<WeakReference<EventListener>>();
			listeners_.put(eventName, eventListeners);
		}

		// Check to see if the listener is already there
		for (Iterator<WeakReference<EventListener>> i = eventListeners.iterator(); i.hasNext();) {
			WeakReference<EventListener> reference = i.next();
			EventListener listener = (EventListener) reference.get();
			if (listener == eventListener)
				return;
		}

		// Add the listener
		eventListeners.add(new WeakReference<EventListener>(eventListener));
	}

	/**
	 * Remove listener from specific event.
	 * 
	 * @param eventName
	 *            Event to remove listener from.
	 * @param eventListener
	 *            Listener to remove.
	 */
	public void removeListener(String eventName, EventListener eventListener) {
		if (eventName == null) {
			removeListener(eventListener);
			return;
		}

		// Find the listeners for the specified event
		Collection<WeakReference<EventListener>> eventListeners = listeners_.get(eventName);
		if (eventListeners == null)
			return;

		// Remove the listener
		for (Iterator<WeakReference<EventListener>> i = eventListeners.iterator(); i.hasNext();) {
			WeakReference<EventListener> reference = i.next();
			EventListener listener = (EventListener) reference.get();
			if (listener == eventListener) {
				i.remove();
				break;
			}
		}

		// Remove the event as such if this was the last listener for this event
		if (eventListeners.size() == 0)
			listeners_.remove(eventName);
	}

	/**
	 * Remove listener from all events it is registered by. Convenient way of
	 * cleaning up an listener object being destroyed.
	 * 
	 * @param eventListener
	 *            Event listener to remove.
	 */
	public void removeListener(EventListener eventListener) {
		// Loop over all registered events and remove the specified listener
		// Loop over a copy incase the removeListener() call wants to
		// remove the entire event from the hash map.
		Collection<String> listeners = new ArrayList<String>(listeners_.keySet());
		for (Iterator<String> i = listeners.iterator(); i.hasNext();) {
			String eventName = i.next();
			removeListener(eventName, eventListener);
		}
	}

	/**
	 * Call listeners. The definition of <em>object</em> and <em>data</em> is
	 * purely up to the communicating classes.
	 * 
	 * @param eventName
	 *            Name of the event.
	 * @param source
	 *            Source of the event (or null).
	 * @param data
	 *            Additinal data of the event (or null).
	 */
	public void notify(String eventName, Object source, Object data) {
		// Find all listeners of this event
		Collection<WeakReference<EventListener>> eventListeners = listeners_.get(eventName);
		if (eventListeners == null)
			return;

		// Loop over a copy of the list in case it is altered by listener
		Collection<WeakReference<EventListener>> copy = new ArrayList<WeakReference<EventListener>>(eventListeners);
		for (Iterator<WeakReference<EventListener>> i = copy.iterator(); i.hasNext();) {
			WeakReference<EventListener> reference = i.next();
			EventListener eventListener = (EventListener) reference.get();
			if (eventListener == null) {
				i.remove();
			} else
				eventListener.update(eventName, source, data);
		}
	}

	/**
	 * Convenience front-end where the additional data paranmeter is null.
	 * 
	 * @param eventName
	 *            Name of the event.
	 * @param source
	 *            Source of the event (or null).
	 */
	public void notify(String eventName, Object source) {
		notify(eventName, source, null);
	}
}
