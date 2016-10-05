package com.liulangf.ioc.guice.simple;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;

public class Main {

	
	public static void main(String...args) {
		Injector injector = Guice.createInjector(new AbstractModule() {
			public void configure() {
				bind(Service.class)
				    .to(ServiceImpl.class)
				    .in(Scopes.SINGLETON);
			}
		});
		
		Client client = injector.getInstance(Client.class);
		client.go();
	}
}
