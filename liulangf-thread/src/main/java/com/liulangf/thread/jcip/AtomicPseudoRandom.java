package com.liulangf.thread.jcip;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liulangf.thread.jcip.annotations.ThreadSafe;

/**
 * AtomicPseudoRandom
 * <p/>
 * Random number generator using AtomicInteger
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class AtomicPseudoRandom extends PseudoRandom {
	private static final Logger LOGGER = LoggerFactory.getLogger(AtomicPseudoRandom.class);
    private AtomicInteger seed;

    AtomicPseudoRandom(int seed) {
        this.seed = new AtomicInteger(seed);
    }

    public int nextInt(int n) {
        while (true) {
            int s = seed.get();
            int nextSeed = calculateNext(s);
            if (seed.compareAndSet(s, nextSeed)) {
                int remainder = s % n;
                return remainder > 0 ? remainder : remainder + n;
            }
        }
    }
    
    public static void main(String...args) {
    	ExecutorService executor = Executors.newFixedThreadPool(4);
    	final AtomicPseudoRandom random = new AtomicPseudoRandom(103);
    	for (int i = 0; i < 20; i++) {
    		executor.execute(new Runnable() {
    			@Override public void run() {
    				LOGGER.info("The random is [{}]", random.nextInt(10));
    			}
    		});
    	}
    	try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	executor.shutdown();
    }
}

