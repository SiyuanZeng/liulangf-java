package com.liulangf.ioc.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceInAction {

	/**
	 * <ul>
	 *   <li>Constructor</li>
	 *   <li>Field</li>
	 *   <li>Setter</li>
	 * </ul>
	 */
	void guice_injection_style() {
	}

	/**
	 * To start using Guice, you create an instance of Injector.
	 */
	void boot_strapping() {
		Injector injector = Guice.createInjector(new Module() {
			public void configure(Binder binder) {
				binder.bind(String.class);
			}
		});
		
		String hello = injector.getInstance(String.class);
	}
	
	void binding_annotations() {
	}
	
	/**
	 * Guice’s default behavior is to create a new instance of an object each 
	 * time that object gets requested or injected. Scopes allow you to customize 
	 * an object’s lifetime.
	 * 
	 */
	void scoping() {
	}
	
	/**
	 * You’re using a third-party API that you can’t modify directly (can’t add @Inject).
	 * You’re working with legacy code that, for example, depends on a factory class or 
	 * method for object construction.
	 * 
	 * public interface Provider<T> { 
	 *     T get(); 
	 * } 
	 * 
	 * A Provider implementation is basically a small factory class that Guice 
	 * will invoke whenever it needs an instance of the given type.
	 */
	void provider() {
	}

	/**
	 * This annotation uses a string identifier to differentiate among different bindings.
	 */
	void named_annotation() {
	}
	
	/**
	 * When you use generic types you need to use a TypeLiteral like :
	 *    bind(new TypeLiteral<ILookup<IWS>>(){}).toProvider(LookupProvider.class);
	 *    
	 * http://gafter.blogspot.com/2006/12/super-type-tokens.html
	 */
	void binding_generic_type() {
	    //or
	    //bind(new TypeLiteral<Repository<Class1>>(){}).to(new TypeLiteral<MyRepository<Class1>>(){});
	}

}
