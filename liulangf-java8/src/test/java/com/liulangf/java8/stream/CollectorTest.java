package com.liulangf.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectorTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		Arrays.asList("A", "B", "C", "D", "E").stream()
		    .map(String::toLowerCase)
		    .collect((Supplier<List<String>>)ArrayList::new, List::add, List::addAll)
		    .stream().forEach(System.out::println);
	}
	
	@Test
	public void testCollect() {
		Collector<String, ?, List<String>> co = Collector.of(ArrayList::new, 
				(list, str) -> {
					if (list.isEmpty()) {
						list.add(str);
					} else {
						String last = list.get(list.size() - 1);
						if (!last.equalsIgnoreCase(str)) {
							list.add(str);
						}
					}
				},
				(left, right) -> {
					left.addAll(right); return left;
				});
		
		Arrays.asList("A", "A", "A", "B", "B", "C", "D", "E").stream()
//		    .map(String::toLowerCase)
		    .collect(co)
		    .stream().forEach(System.out::println);
	}
	
	
	@Test
	public void filterTest() {
//		Arrays.asList("A", "B", "C", "D", "E").forEach(action);
	}
	
	@Test
	public void zero() {
		Arrays.asList("A", "B", "C", "D", "E").stream()
		    .filter(e -> e.charAt(0) > 'A')
		    .forEach(System.out::println);
	}
	
	public void sink() {
		Arrays.asList("A", "B", "C", "D", "E").stream();
	}
	
	@Test
	public void order() {
		Arrays.asList("A", "E", "B", "C", "D").stream()
		    .unordered()
		    .forEach(System.out::println);
		    		
	}
	
	static class MyReducer implements BinaryOperator<String> {
		@Override
		public String apply(String t, String u) {
			return t + "," + u; 
		}
	}
	
	@Test
	public void reduceTest1() {
		Stream<String> stream = Stream.of("a", "b", "c");
		String result = stream.reduce(null, new MyReducer());
		log.info("{}", result);
		
		stream = Stream.of("a", "b", "c", "d");
		Optional<String> os = stream.reduce(new MyReducer());
		log.info("{}", os.get());
	}

}
