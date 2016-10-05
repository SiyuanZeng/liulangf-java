package com.liulangf.java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamInJava8Test {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		List<String> ls = Arrays.asList("a", "b", "c");
		
		Stream<String> a = ls.stream();
		Stream<String> b = a.map(s -> s.toUpperCase());
		Stream<String> c = a.map(String::toUpperCase);
		log.info("{}", a == b);
	}

	@Test
	public void iteratorTest() {
		Iterator<String> iterator = Arrays.asList("a", "b").iterator();
		//Arrays.asList("a", "b").spliterator();
		
		int characteristics = Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED;
        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(iterator, characteristics);

        boolean parallel = false;
        Stream<String> stream = StreamSupport.stream(spliterator, parallel);
		stream.forEach(
				e -> log.info("[{}]", e)
				);
	}
	
	@Test
	public void streamsTest() {
	}
}
