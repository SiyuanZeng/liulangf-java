/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.pattern.gof.behavioral.observer;

/**
 * http://c2.com/cgi/wiki?ObserverPattern
 * http://home.earthlink.net/~huston2/dp/observer.html
 * http://www.oodesign.com/observer-pattern.html
 * 
 * Alias: 
 * <ul>
 *   <li>Subject Observer</li>
 *   <li>Publish Subscribe</li>
 *   <li>Callback</li>
 *   <li>Event Listener, Event Notifier</li>
 * </ul>
 * 
 * Intent: 
 * <ul>
 *  <li>Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.[GoF, p293]</li>
 *  <li>Encapsulate the core (or common or engine) components in a Subject abstraction, and the variable (or optional or user interface) components in an Observer hierarchy.</li>
 *  <li>The "View" part of Model-View-Controller.</li>
 * </ul>
 * 
 * ObserverPattern is pretty low-level, and appears in its entirety as part of other important patterns 
 * (e.g. ModelViewController).
 * 
 * A key tenet[ti:net, 信条] is that the observed does not know anything about the observers. ???
 * It "publishes" a change and the observers get notified of the change.
 * 
 * The ObserverPattern is useful mostly for dynamic relationships between objects: 
 * you can hook up a new observer to an observable while the program is running.
 * (e.g. hook up a newly-opened viewing window to a domain object), then unhook it later 
 * (e.g. remove the window from the list of observers when the user closes it).
 * It is also the basis for publish-subscribe messaging architectures.
 * 
 * @author Quqing Liu
 */
public class Backgrounds {

	/**
	 * The function called when an observed object triggers an observation.
	 */
	class EventHandler {
		//OR EventListener
		public void handle(Object event) {}
	}
	
	/**
	 * The two basic styles of notification: PushModel and PullModel.
	 * If the observed object does not have the necessary hooks for observers, 
	 * the observers must rely on repeatedly polling the observed to note the changes. 
	 * This is a "pull" versus a "push" type of pattern.  
	 */
	class Notification {
		
		/**
		 * In the PushModel, the observable broadcasts a piece of information that reveals the nature of the change.
		 * For example 'color changed to red', 'added item at index 12'.
		 */
		void push() { }
		
		/**
		 * In the PullModel, the observable broadcasts that it has changed, but doesn't say how it changed.
		 * The observers pull data from the observable object.
		 */
		void pull() { }
	}
	
	class Practice {
		
		/**
		 * Define an object that is the "keeper" of the data model and/or business logic (the Subject). 
		 * Delegate all "view" functionality to decoupled and distinct Observer objects. 
		 * Observers register themselves with the Subject as they are created. Whenever the Subject changes, 
		 * it broadcasts to all registered Observers that it has changed, and each Observer queries the Subject 
		 * for that subset of the Subject's state that it is responsible for monitoring.
		 * 
		 * This allows the number and "type" of "view" objects to be configured dynamically, 
		 * instead of being statically specified at compile-time.
		 */
		void stepByStep() {}
		
		/**
		 * The protocol described above specifies a "pull" interaction model. 
		 * Instead of the Subject "pushing" what has changed to all Observers, 
		 * each Observer is responsible for "pulling" its particular "window of interest" from the Subject. 
		 * The "push" model compromises[破坏,威胁] reuse, while the "pull" model is less efficient.
		 */
		void pull_push() {}
		
		/**
		 * 1. Model View Controller Pattern - 
		 *    The observer pattern is used in the model view controller (MVC) architectural pattern. 
		 *    In MVC this pattern is used to decouple the model from the view. 
		 *    View represents the Observer and the model is the Observable object.
		 * 
		 * 2. Event management - This is one of the domains where the Observer patterns is extensively used. 
		 *    Swing and .Net are extensively using the Observer pattern for implementing the events mechanism.
		 */
		void classicalExamples() {}
	}
	
	/**
	 * <ul>
	 *   <li>Differentiate between the core (or independent) functionality and the optional (or dependent) functionality.</li>
	 *   <li>Model the independent functionality with a "subject" abstraction.</li>
	 *   <li>Model the dependent functionality with an "observer" hierarchy.</li>
	 *   <li>The Subject is coupled only to the Observer base class.</li>
	 *   <li>The client configures the number and type of Observers.</li>
	 *   <li>Observers register themselves with the Subject.</li>
	 *   <li>The Subject broadcasts events to all registered Observers.</li>
	 *   <li>The Subject may "push" information at the Observers, or, 
	 *     the Observers may "pull" the information they need from the Subject.</li>
	 * </ul>
	 *
	 */
	class CheckList {
	}
	
	/**
	 * There are 2 methods of passing the data from the subject to the observer 
	 * when the state is being changed in the subject side:
	 *
	 * @author Quqing Liu
	 */
	class PushAndPullAgain {
		
		/**
		 * Push model -
		 *   The subjects send detailed information about the change to the observer whether it uses it or not. 
		 *   Because the subject needs to send the detailed information to the observer this might be inefficient 
		 *   when a large amount of data needs to be sent and it is not used.
		 *   
		 *   Another approach would be to send only the information required by the observer. 
		 *   In this case the subject should be able to distinguish between different types of observers and to 
		 *   know the required data of each of them, meaning that the subject layer is more coupled to observer layer.
		 */
		void pushModel() {}
		
		/**
		 * Pull model - 
		 *   The subject just notifies the observers when a change in his state appears and it's the responsibility 
		 *   of each observer to pull the required data from the subject. This can be inefficient because the 
		 *   communication is done in 2 steps and problems might appear in multi-threading environments.
		 */
		void pullModel() {}
		
	}

}
