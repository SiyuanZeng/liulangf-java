/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.pattern.gof.behavioral.state;

/**
 * State machine diagrams are used to describe the state transitions of a single object's lifetime in 
 * response to events.
 * 
 * State machine diagrams are modeled in a similar way to activity diagrams.
 * 
 * Entities of state machine diagrams:
 * <ul>
 *   <li>State: States model a moment in time for the behavior of a classifier.</li>
 *   <li>Initial Post: Represents the beginning of the execution of this state machine.</li>
 *   <li>Entry Point: In cases when it is possible to enter the state machine at a later stage than the initial state this can be used.</li>
 *   <li>Final State: Represents the end of the state machine execution.</li>
 *   <li>Exit Point: Represents alternative end point to the final state, of the state machine.</li>
 *   <li>Transition: Transitions illustrate movement between states. They can be annotated with a 
 *       Trigger[Guard]/Effect notation. States may also have self transitions, useful for iterative behavior.</li>
 *   <li>State: A state can also be annotated with any number of trigger/effect pairs, which is useful when the state
 *       has a number of transitions.</li>
 *   <li>Nested States: States can themselves contain internal state machine diagrams.</li>
 *   <li>State Choice: A decision with a number of transitions leaving from the choice element.</li>
 *   <li>State junction: Junctions are used to merge a number of transitions from different states.</li>
 *   <li>Terminate State: Indicates that the flow of the state machine has ended.</li>
 *   <li>History State: Can be used to model state memory, where the state resumes from where
 *       it was last time.</li>
 *   <li>Concurrent Region: A state can have multiple substates executing concurrently, which is modeled 
 *       using a dashed line to separate the parallel tracks. Forks and merges (see activity diagram) are used 
 *       to split/merge transitions.</li>
 *   <li></li>
 * </ul>
 * 
 * 
 * 
 * @author LiuYuqing
 */
public class StateMachineDiagram {
	
	/**
	 * Transitions: Triggers, Guards, Effects
	 * 
	 * Triggers cause the transition, which is usually a change in condition.
	 * A guard is a condition that must evaluate to true before the transition can execute.
	 * Effect is an action that will be invoked on that object.
	 * 
	 */
	void transitions() {
	}
	
	/**
	 * State machine diagrams 显示一个状态机。状态机用于对模型元素的动态行为进行建模，更具体的说，就是对系统行为
	 * 中受事件驱动的方面进行建模。通常使用State machine diagrams来说明业务角色或业务实体可能的状态-导致状态转换
	 * 的事件和状态转换引起的操作。
	 * 
	 * 状态图通常只用于描述单个对象的行为。
	 * 
	 */
	void details() {}

	/**
	 * From <<UML Reference Manual>>:
	 * A State Machine is a graph of states and transitions.
	 * A State Machine is a model of all possible life histories of an object of a class.
	 * 
	 */
	void state_machine() {
	}

}
