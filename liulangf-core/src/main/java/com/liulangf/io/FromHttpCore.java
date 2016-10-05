package com.liulangf.io;

/**
 * @author YuQing Liu
 *
 */
public interface FromHttpCore {
	
	/**
	 * Contrary to the popular belief, the performance of NIO in terms of raw data throughput is significantly 
	 * lower than that of blocking I/O. NIO does not necessarily fit all use cases and should be used only where 
	 * appropriate:
	 * <ul>
	 *   <li>handling of thoustands of connections, a significant number of which can be idle</li>
	 *   <li>handling high latency connections</li>
	 *   <li>request/response handling needs to be decoupled.</li>
	 * </ul>
	 * 
	 */
	void benefits_and_shortcommings();
	
	/**
	 * HttpCore NIO is based on the Reactor pattern as described by Doug Lea. 
	 * The purpose of IO reactors is to react to IO events and to dispatch event
	 * notifications to individual IO sessions. The main idea of IO reactor pattern
	 * is to break away from the one thread per connection model imposed by the classic
	 * blocking IO model. 
	 * 
	 * Http-core IOReactor implementations encapsulate functionality of the NIO java.nio.channels.Selector.
	 * 
	 * I/O reactors usually employ a small number of dispatch threads (often as few as one) 
	 * to dispatch I/O event notifications to a much greater number (often as many as several thousands) 
	 * of I/O sessions or connections. It is generally recommended to have one dispatch thread per CPU core.
	 */
	void io_reactor_pattern();

}





























