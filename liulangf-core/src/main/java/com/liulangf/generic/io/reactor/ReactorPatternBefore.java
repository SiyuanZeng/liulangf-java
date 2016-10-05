package com.liulangf.io.reactor;

/**
 * @author YuQing Liu
 *
 */
public class ReactorPatternBefore {
	
	
	/**
	 * A handler for each request:
	 * <ul>
	 *   <li>Read request</li>
	 *   <li>Decode request</li>
	 *   <li>Process service</li>
	 *   <li>Encode reply</li>
	 *   <li>Send reply</li>
	 * </ul>
	 */
	public void basicStructureOfServerService() {
	}
	
	/**
	 * Divide-and-conquer is usually the best approach for 
	 * achieving any scalability goal.
	 * 
	 * Divide processing into small tasks, each task performs an action without blocking.
	 * An IO event usually serves as trigger.
	 * 
	 */
	public void scalabilityGoal() {}
	
	/**
	 * Non-blocking reads and writes
	 * Dispatch tasks associated with sensed IO events.
	 * 
	 */
	public void supportedInJavaNIO() {}
	
	/**
	 * <ul>
	 *   <li>Fewer resources: Don't usually need a thread per client</li>
	 *   <li>Less overhead: Less context switching, often less locking</li>
	 *   <li>But dispatching can be slower: Must manually bind actions to events</li>
	 *   <li>Harder to program: must break up into simple non-blocking actions</li>
	 *   <li>Must keep track of logical state of service</li>
	 * </ul>
	 * 
	 */
	public void event_driven_design() {}

}
