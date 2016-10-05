package com.liulangf.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream<T>
 * 
 * A sequence of elements supporting sequential 
 * and parallel bulk operations.
 * 
 * What is pipeline??
 * 
 */
public class StreamInJava8 {
	void iteratorToStream() {
		List<String> ls = Arrays.asList("a", "b", "c", "d");
		long a = ls.stream().map(s -> s.toUpperCase()).count();
		
		Stream.of();
		
		Consumer<String> c1 = m -> {} ;
		Consumer<String> c2 = c1.andThen(n -> {});
		
		ls.stream().forEach(c2);
		ls.stream().forEach(c1.andThen(ll -> {}));
		//ls.stream().forEach((s -> {}).andThen(b -> {}));
		
	}

}
