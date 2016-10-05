package com.liulangf.thread.effective.second.item69;

/**
 * <<Effective java>>. Chapter 10. Item 69.
 * 
 */
public class StandardWaitIdiom {

    /**
     * The standard idiom for using the wait method
     * 
     * <pre>
     *     synchronized (obj) 
     *         while (<condition does not hold>)
     *             obj.wait(); // (Releases lock, and reacquires on wakeup)...
     *              
     *         ...// Perform action appropriate to condition}
     * </pre>
     * 
     * <p>
     * Always use the wait loop idiom to invoke the wait method; never invoke it outside of a loop.
     * 
     * @throws InterruptedException
     * 
     */
    public void standard() throws InterruptedException {
        Object obj = new Object();
        synchronized (obj) {
            while (condition()) {
                // (Releases lock, and reacquires on wakeup)
                obj.wait(); 
            }
            //Perform action appropriate to condition
        }
    }

    private boolean condition() {
        return true;
    }
}
