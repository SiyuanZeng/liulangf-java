package com.liulangf.java8.monad;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Stream combines computations which can return several values; 
 *
 */
public class StreamMonad {
	
	public void stream() {
		Stream<String> stream = Arrays.asList("a", "b").stream()
				.flatMap(s -> Arrays.asList("A", "B", "c").stream())
				.flatMap(s -> Arrays.asList("A", "B", "c").stream());
	}
	
	/**
	 * 1. Container with a type M<T>                                             (e.g. Optional<T>, Stream<T>)
	 * 2. method M<U> flatMap(t -> M<U>)                                         (e.g. flatMap(T -> Optional<U>))
	 * 3. constructor to put T into M<T>; same as a static method M<T> unit(T);  (e.g. Optional.of(x))
	 * 
	 * now we can define M<U> map(T -> U);
	 * M<U> map(f) {return flatMap(x -> unit(f(x)))}
	 */
	public void what_is_a_monad() {
	}
	

	/**
	 * 1. Left identity:  unit(x).flatMap(f) == f(x);
	 * 2. Right identity: m.flatMap(x -> unit(x)) == m;
	 * 3. Associativity:  m.flatMap(f).flatMap(g) == m.flatMap(x -> f(x).flatMap(g));
	 */
	public void the_monad_law() {
		//1. Left identity
		Function<String, Optional<String>> f = s -> Optional.of(s);
		Optional<String> a1 = Optional.of("abc").flatMap(f);
		Optional<String> a2 = f.apply("");
		//a1.equals(a2);
		
		//2. Right identity
		Stream.of("a", "b").flatMap(x -> Stream.of(x));
		
		//3. Associativity
		Stream.of("a", "b")
		    .flatMap(x -> Stream.of(x))
		    .flatMap(x -> Stream.of(x));
		
		Stream.of("a", "b")
	    .flatMap(x -> Stream.of(x).flatMap(y -> Stream.of(y)));
	
	}
	
}
