package com.liulangf.ioc.guice.simple;

import javax.inject.Inject;

public class Client {
	
	private final Service service;
	
	@Inject
	public Client(Service service) {
		this.service = service; 
	}
	
	public void go() {
		service.go();
	}

}
