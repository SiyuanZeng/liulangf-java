package com.liulangf.java8.monad;

import java.util.concurrent.CompletableFuture;

/**
 * A Monad is just a monoid in the category of endofunctors;
 * 
 * 
 * Monad is a pattern for combining computations with some strategy. 
 * 
 *
 */
public class MonadIsApattern {
	
	
	/**
	 * 1. You create M<T>
	 * 2. do actions on M<T>
	 * 3. get and map T values(s) to M<U>
	 * 4. do actions on M<U> or else
	 */
	public void monad_is_a_pattern() {
	}

	/**
	 * 1. You create Optional<T>.
	 * 2. invoke isPresent of Optional<T>.
	 * 3. if true, get and map T to Optional<U>
	 * 4. if false, return Optional.empty();
	 */
	public void optional_monad() {
	}

	/**
	 * 1. You create Stream<T>
	 * 2. forEach T element
	 * 3. map T to Stream<U>
	 */
	public void stream_monad() {
	}

	/**
	 * 1. You create Future<T>
	 * 2. wait until T is ready (in another thread)
	 * 3. use T and the supplied code to create Future<U>
	 * 
	 */
	public void future_monad() {
		CompletableFuture.runAsync(() -> {
		});
	}

}
