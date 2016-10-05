package com.liulangf.ioc.jsr.jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author YuQing Liu
 */
//@Resources()
public class Manager {
	
	/**
	 * @Resource takes a name attribute, and by default Spring interprets that value as the bean name to be 
	 * injected. In other words, it follows by-name semantics.
	 * If no name is specified explicitly, the default name is derived from the field name or setter method.
	 * In case of a field, it takes the field name; in case of a setter method, it takes the bean property name.
	 */
	@Resource(name="service")
	private Service service;
	
	/**
	 * This annotation marks a method that must be executed when the instance is 
	 * in the process of being removed by the container.
	 */
	@PreDestroy
	public void destroy() {
		service.shutDown();
	}
	
	/**
	 *This annotation marks a method that must be executed after dependency injection is performed on the class. 
	 */
	@PostConstruct
	public void init() {
		service.setUP();
	}
	
	public void manage() {
		service.working();
	}
}
