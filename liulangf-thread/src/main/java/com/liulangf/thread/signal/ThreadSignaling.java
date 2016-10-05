
package com.liulangf.thread.signal;

/**
 * http://ifeve.com/thread-signaling/
 * http://tutorials.jenkov.com/java-concurrency/thread-signaling.html
 * 
 * <p>
 * The purpose of thread signaling is to enable threads to send signals to each other. 
 * Additionally, thread signaling enables threads to wait for signals from other threads. 
 * 
 * <p>
 * Seven ways about thread signaling in java:
 * <ul>
 *   <li>Signaling via Shared Objects</li>
 *   <li>Busy wait</li>
 *   <li>wait(), notify(), notifyAll()</li>
 *   <li>Missed Signals</li>
 *   <li>Spurious wakeups</li>
 *   <li>Multiple Threads Waiting for Same Signals</li>
 *   <li>Don't call wait() on constant Strings or Global Objects</li>
 * </ul>
 * 
 * @author liulangf
 *
 */
public class ThreadSignaling {
    
    
    class Signaling_Via_Shared_Objects {
        protected boolean hasDataToProcess = false;
        
        public synchronized boolean hasDataToProcess() {
            return this.hasDataToProcess;
        }
        
        public synchronized void setHasDataToProcess(boolean hasData) {
            this.hasDataToProcess = hasData;
        }
    }
    
    /**
     * Thread B which is to process the data is waiting for data to become available for processing. 
     * In other words, it is waiting for a signal from thread A which causes hasDataToProcess() to return true.
     */
    class Busy_Wait {
        protected Signaling_Via_Shared_Objects sharedSignal = new Signaling_Via_Shared_Objects();
        
        /**
         * Notice how the while loop keeps executing until hasDataToProcess() returns true. 
         * This is called busy waiting. The thread is busy while waiting.
         */
        public void busyWait() {
            while (!sharedSignal.hasDataToProcess()) {
                //do nothing but busy wait
            }
        }
    }
    
    /**
     * <p>Java has a builtin wait mechanism that enable threads to become inactive while waiting for signals. 
     * The class java.lang.Object defines three methods, wait(), notify(), and notifyAll(), to facilitate this.
     * 
     * <p>
     * A thread that calls wait() on any object becomes inactive until another thread calls notify() on that object. 
     * In order to call either wait() or notify the calling thread must first obtain the lock on that object. 
     * In other words, the calling thread must call wait() or notify() from inside a synchronized block. 
     *
     * <p>
     * The waiting thread would call doWait(), and the notifying thread would call doNotify(). 
     * When a thread calls notify() on an object, one of the threads waiting on that object are 
     * awakened and allowed to execute.
     * 
     * <p>
     * Once a thread calls wait() it releases the lock it holds on the monitor object. 
     * This allows other threads to call wait() or notify() too, since these methods must be 
     * called from inside a synchronized block.
     * 
     * <p>
     * 
     */
    class Wait_notify {
        
        private Object monitor = new Object();
        
        public void doWait() {
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        
        public void doNotify() {
            synchronized (monitor) {
                monitor.notify();
            }
        }
    }
    
    /**
     * If a thread calls notify() before the thread to signal has called wait(), 
     * the signal will be missed by the waiting thread. 
     */
    class Missed_Signal {
        
        private Object monitor = new Object();
        boolean wasSignaled = false;
        
        public void doWait() {
            synchronized (monitor) {
                if (!wasSignaled) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                    }
                }
                //clear signal and continue running.
                wasSignaled = false;
            }
        }
        
        public void doNotiry() {
            synchronized (monitor) {
                wasSignaled = true;
                monitor.notify();
            }
        }
    }

}
