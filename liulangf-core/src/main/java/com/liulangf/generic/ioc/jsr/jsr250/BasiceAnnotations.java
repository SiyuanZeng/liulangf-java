package com.liulangf.ioc.jsr.jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author YuQing Liu
 */
@Resources({
    @Resource(name="service"),
    @Resource(name="cache")
})
@Resource(name="basic")
public class BasiceAnnotations {
	
	/**
	 * When applied on a class, there is no default and the name MUST be specified.
	 */
	@Resource(name="serviceName", type=String.class)
	private String serviceName;
	
	
	/**
	 * The return type of the method MUST be void
	 * The method MUST NOT throw a checked exception.
	 */
	@PostConstruct
	public void init() {
	}
	
	/**
	 * The return type of the method MUST be void
	 * The method MUST NOT throw a checked exception.
	 */
	@PreDestroy
	public void tearDown() {
	}
}
