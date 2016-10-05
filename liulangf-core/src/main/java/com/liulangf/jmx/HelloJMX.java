package com.liulangf.jmx;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JMX: Java Management Extension (Since Java 5.0)
 * java.lang.management.*;
 * javax.management.*;
 * 
 * Suppose that you want to dig into a running application and change its configuration on the fly.
 * That’s where Java Management Extensions (JMX) comes in.
 * 
 * The key component of an application that is instrumented for management with JMX is the MBean (managed bean). 
 * An MBean is a JavaBean that exposes certain methods that define the management interface.
 * 
 * The JMX specification defines four types of MBeans:
 * <ul>
 *   <li>Standard MBeans—Standard MBeans are MBeans whose management interface is determined by reflection on 
 *       a fixed Java interface that is implemented by the bean class.</li>
 *   <li>Dynamic MBeans—Dynamic MBeans are MBeans whose management interface is determined at runtime by invoking 
 *       methods of the DynamicMBean interface. Because the management interface isn’t defined by a static interface, 
 *       it can vary at runtime.</li>
 *   <li>Open MBeans—Open MBeans are a special kind of dynamic MBean whose attributes and operations are limited 
 *       to primitive types, class wrappers for primitive types, and any type that can be decomposed into primitives
 *       or primitive wrappers.</li>
 *   <li>Model MBeans—A model MBean is a special kind of dynamic MBean that bridges a management interface 
 *       to the managed resource.</li>
 * </ul>
 * 
 * @author Quqing Liu
 */
public class HelloJMX {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(HelloJMX.class);
	
	
	/**
	 * Spring’s JMX module enables you to export Spring beans as Model MBeans so that you can see inside 
	 * your application and tweak the configuration—-even while the application is running.
	 * 
	 * Spring's MBeanExporter is the key to JMX-ifying beans in Spring. MBeanExporter is a bean that exports one 
	 * or more Spring-managed beans as Model MBeans in an  MBean server (MBean server
	 */
	void spring_jmx() { }
	
	/**
	 * An MBean server (MBean server sometimes called an MBean agent) is a container where MBeans live and 
	 * through which the MBeans are accessed.
	 */
	void mbean_server() {}
	
	public MBeanServer getMBeanServer() {
		ArrayList<MBeanServer> mbeanServers = MBeanServerFactory.findMBeanServer(null);
		for (MBeanServer s : mbeanServers) {
			LOGGER.info(s.toString());
		}
		return null;
	}
	
	public static void main(String...args) {
		new Thread() {
			int start = 0;
			public void run() {
				for (;;) {
					LOGGER.info(".........." + start++);
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						LOGGER.error("Thread Error!", e);
					}
				}
			}
		}.start();
	}
	

}
