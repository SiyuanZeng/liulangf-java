package com.liulangf.pattern.eda;

/**
 * Events observe a change in state.
 * Event Driven Architecture(EDA) is a software architecture supporting the production,
 * detection, consumption of and reaction to events.
 * 
 * <p>Key principles:
 * <ul>
 *   <li>Loosely-coupled</li>
 *   <li>Message-based</li>
 *   <li>Location independent/routed</li>
 *   <li>Transport abstracted</li>
 * </ul>
 * 
 * <p>EDA complements SOA
 * <ul>
 *   <li>Service at the core:expose and handle
 *       SOA enables events to flow across systems, transports and actors</li>
 *   <li>Event at the core: When... then...</li>
 * </ul>
 * 
 * 
 * 
 * @author liulangf
 *
 */
public class EventDrivenArchitecture {
	
	/**
	 * <ul>
	 *   <li>Events can be related</li>
	 *   <li>Events can be streamed</li>
	 *   <li>Events can change frequently</li>
	 *   <li>when... then ...</li>
	 * </ul>
	 */
	public void eventProcessingSolution() {}
	
	/**
	 * ESP: Event Stream Processing
	 *    Monitor streams of event data, analyse those events, and act upon opportunities.
	 * CEP: Complex Event Processing
	 *    Detecting patterns among events.
	 */
	public void terminology() {}
	
	/**
	 * <ul>
	 *   <li>Database</li>
	 *   <li>Listener API</li>
	 *   <li>Rule engines</li>
	 * </ul>
	 */
	public void eventProcessingApproach() {}

}
