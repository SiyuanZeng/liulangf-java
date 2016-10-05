package com.liulangf.java8.stream;

import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkipLimitPeekTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		Stream<String> stream = Stream.of("A", "B", "C", "D", "E", "F", "G", 
				"H", "I", "J", "K", "M", "N", "O", 
				"P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z");

//		stream.sorted().peek(e -> System.out.println(e)).skip(6).limit(3)
//		.forEach(e -> {
//			log.info("{}", e);
//		});
		
		stream.sorted().skip(5).peek(e -> {
			System.out.println(e);
		}).limit(3).forEach(e -> {
			log.info("{}", e);
		});
		
	}

}
