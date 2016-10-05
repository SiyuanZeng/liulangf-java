package com.liulangf.thread.effective.second.item67;

/**
 * http://mindprod.com/jgloss/alienmethod.html
 * 
 * <p>A method you call for which you have no control over the code, and further don’t even 
 * know what the code does, other than the method signature. 
 * 
 * <p>Most commonly, the term is used for delegate methods, but strictly speaking it could 
 * refer to calls to third party libraries. 
 * 
 * <p>The term was coined by Joshua J. Bloch.
 */
public interface AlienMethod {
    
    
    /**
     * <p>An alien method invoked outside of a synchronized region is known as an open call [Lea00 2.4.1.3]. 
     * Besides preventing failures, open calls can greatly increase concurrency. 
     * 
     * <p>An alien method might run for an arbitrarily long period. If the alien method were invoked from a 
     * synchronized region, other threads would be denied access to the protected resource unnecessarily.
     */
    void open_call();
    
    /**
     * From <<java concurrency in practice>>. Chapter 10.
     * 
     * <p>A method call is an abstraction barrier intended to shield you from the details of what happens 
     * on the other side. But because you don't know what is happening on the other side of the call, 
     * calling an alien method with a lock held is difficult to analyze and therefore risky.
     * 
     * <p>Calling a method with no locks held is called an open call [CPJ 2.4.1.3], and classes that rely 
     * on open calls are more well-behaved and composable than classes that make calls with locks held. 
     * Using open calls to avoid deadlock is analogous to using encapsulation to provide thread safety: 
     * while one can certainly construct a thread-safe program without any encapsulation, the thread safety 
     * analysis of a program that makes effective use of encapsulation is far easier than that of one that 
     * does not. Similarly, the liveness analysis of a program that relies exclusively on open calls is far 
     * easier than that of one that does not. Restricting yourself to open calls makes it far easier to identify 
     * the code paths that acquire multiple locks and therefore to ensure that locks are acquired in a consistent 
     * order.
     */
    void from_jcip();

}
