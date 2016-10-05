package com.liulangf.pattern.behavioral.observer.robertc;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import com.liulangf.pattern.gof.behavioral.observer.robertc.MockTimeSink;
import com.liulangf.pattern.gof.behavioral.observer.robertc.MockTimeSource;

public class ObserverTest {
	
	private MockTimeSource source;
	private MockTimeSink sink;
	
	@Before
	public void setUp() {
		source = new MockTimeSource();
		sink = new MockTimeSink(source);
		source.registerObserver(sink);
	}

	private void assertSinkEquals(MockTimeSink sink, int hours, int minutes, int seconds) {
		assertThat(sink.getHours(), is(hours));
		assertThat(sink.getMinutes(), is(minutes));
		assertThat(sink.getSeconds(), is(seconds));
	}
	
	@Test
	public void timeChange() {
		source.setTime(3, 4, 5);
		assertSinkEquals(sink, 3, 4, 5);
		
		source.setTime(7, 8, 9);
		assertSinkEquals(sink, 7, 8, 9);
	}
	
	@Test
	public void multipleSinks() {
		MockTimeSink sink2 = new MockTimeSink(source);
		source.registerObserver(sink2);
		
		source.setTime(12, 13, 14);
		assertSinkEquals(sink, 12, 13, 14);
		assertSinkEquals(sink2, 12, 13, 14);
	}

}
