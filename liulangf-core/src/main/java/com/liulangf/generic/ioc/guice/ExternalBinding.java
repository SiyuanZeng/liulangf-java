package com.liulangf.ioc.guice;

import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public class ExternalBinding {
	

	/**
	 * Guice can automatically generate bindings from a Properties object.
	 */
	void generate_binding_from_Properties_Object() {
		
		Injector injector = Guice.createInjector(new AbstractModule() {
			public void configure() {
				Properties properties = null;
				Names.bindProperties(binder(), properties);
			}
		});
	}

	/**
	 * java.util.ServiceLoader.
	 * 
	 */
	void automated_discovery() {
	}

}
