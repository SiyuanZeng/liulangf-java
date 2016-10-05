package com.liulangf.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuilderTest {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		Stream.Builder<String> sb = Stream.builder();
		Arrays.asList("A", "B", "C", "D", "E").stream()
		   .filter(e -> e.charAt(0) > 'A')
		   .forEach(sb);
		sb.build().forEach(System.out::println);
	}
	
	@Test
	public void size() {
		 int a = Math.max(4,
                Integer.SIZE - Integer.numberOfLeadingZeros(5 - 1));
		 
		 System.out.println(Integer.SIZE);
		 IntStream.range(1, 32).forEach(e -> 
		     System.out.println(Integer.numberOfLeadingZeros(e))
				 );
	}
	
	@Test
	public void utilStreamsTest() {
		IntStream.range(0,  10).forEach(i -> {
			log.info("{}", i);
		});
		
		IntStream.rangeClosed(0,  10).forEach(i -> {
			log.info("{}", i);
		});
	}
	
	@Test
	public void sinkTest() {
		Stream<String> stream = Stream.of("a", "b", "c", "e", "f", "g", "h", "i").filter(e -> {
			return  e.charAt(0) > 'c';
		})
		.map(e -> "[" + e + "]");
		
		stream.forEach(System.out::println);
	}

}
