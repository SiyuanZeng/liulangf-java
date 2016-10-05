package com.liulangf.jmx;

/**
 * 
 *
 * @author liulangf
 *
 */
public class HowToStopJavaGracefully {
	
	/**
	 * Shutdown hooks execute in all cases where the JVM is not forcibly killed.
	 *  
	 * if kill -9, kill -SIGKILL, shutdown hooks will not execute.  
	 * 
	 */
	void shutdownHook() {
	}
	
	
	/**
	 * http://docs.oracle.com/javase/1.5.0/docs/guide/management/overview.html
	 */
	void java_monitor_and_management() {
	}
	
	
	/**
	 * IPC : inter-process communication.
	 * http://en.wikipedia.org/wiki/Inter-process_communication
	 * 
	 */
	void inter_process_communication() {
	}
	
	void ctrl_c_sendsignal() {
	}

}
