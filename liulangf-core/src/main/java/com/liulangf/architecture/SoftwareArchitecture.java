package com.liulangf.architecture;

/**
 * http://www.dossier-andreas.net/software_architecture/
 * The idea behind this site is to give myself and other programmers a high-level easy-to-understand overview of 
 * common architectural patterns in software.
 * 
 * An architecture has a data flow aspect and a control flow aspect.
 * <ul>
 *   <li>Data Flow:  describes functional modules and data transfers. </li>
 *   <li>Control Flow: describes the way control is passed from one part of the system to the other.</li>
 * </ul>
 * 
 * @author YuQing Liu
 *
 */
public class SoftwareArchitecture {
	
	
	interface DataFlowSytle {
		void model_view_controller();
		void presentation_abstraction_control();
		void pipe_and_filter();
		void layeredSystems();
		void microkernel();
		void client_server_and_n_tier_systems();
		void repository();
		void blackboard();
		void finite_state_machine();
		void process_control();
		void multi_agent_system();
		void broker_aka_SOA();//aka: also known as
		void master_slave();
		void interpreter_aka_virtual_machine();
		void hub_and_spoke();
		void messageBus_aka_eventBus();
		void structural_model();
		void peer_to_peer();
	}
	
	/**
	 * Control flow describes the way activity flows through the application. For starters, an application may consist 
	 * of a single process, that performs sequential executions, subroutine calls and loops. But the application may 
	 * also consist of several asynchronous processes. But even if the application has only a single thread of control, 
	 * it may emulate multiple simultanuous threads.
	 * 
	 * Even though a single thread can at the lowest level only do loops and subroutine calls, at a higher level of 
	 * abstraction it can create all sorts of control flows. Take Implicit invocation for example. At the lowest level 
	 * it's just subroutine calls. At a higher level it's modules that become active when they receive an event that was 
	 * sent earlier on by a different module. Often the application contains a specific module to create the control flow.
	 * 
	 * I found that two characteristics stand out to describe control flow: 
	 * command structure (Control Tree or Control Loop) and order of execution (Parallel or Sequential).
	 */
	interface ControlFlowStyle {
		
		void call_and_Return__aka__main_program_and_subroutines();
		void implicit_invocation__aka__event_based();
		void manager_model();
		void emulated_parallel();
		
	}
}
