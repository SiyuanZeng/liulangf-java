package com.liulangf.pattern.behavioral.observer.eventbus;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.eventbus.EventBus;
import com.liulangf.pattern.gof.behavioral.observer.eventbus.EventListener;
import com.liulangf.pattern.gof.behavioral.observer.eventbus.MultipleListener;
import com.liulangf.pattern.gof.behavioral.observer.eventbus.OurTestEvent;



public class GuavaEventBusTest {
	
	@Test
	public void shouldReceiveEvent() throws Exception {
		// given
		EventBus eventBus = new EventBus("test");
		EventListener listener = new EventListener();
		
		eventBus.register(listener);
		
		// when
		eventBus.post(new OurTestEvent(200));
		
		// then
		Assert.assertThat(listener.getLastMessage(), is(200));
	}
	
	@Test
	public void shouldReceiveMultipleEvents() throws Exception {
		// given
		EventBus eventBus = new EventBus("Test");
		MultipleListener multiListener = new MultipleListener();
		
		eventBus.register(multiListener);
		
		// when
		eventBus.post(new Integer(100));
		eventBus.post(new Long(800));
		
		// then
		Assert.assertThat(multiListener.getLastInteger(), is(100));
		Assert.assertThat(multiListener.getLastLong(), is(800L));
	}

}
