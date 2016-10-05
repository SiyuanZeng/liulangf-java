package com.liulangf.thread.pool.commons;

import org.apache.commons.pool.ObjectPool;

public class WorkerThread extends Thread
{ 
    // The total amount of work done by the threads.
    static public long totalUnits = 0;
    // The number of times the thread should look over a counter
    // (this is our definition of work)
    private int counter = 1000;

    // When the thread is done, it returns itself to the pool.
    private ObjectPool hostPool = null;
    // Used to indicate that a thread, when completed, is no longer
    // useful.
    public boolean valid = true;

    public void setPool(ObjectPool myPool)
    {
        hostPool = myPool;
    }

    public void run()
    {
        // Loop over a counter, and yield each time to allow other
        // threads to execute.  In a "real" app, you wouldn't need
        // to yield anywhere near this often.
        for (int i = 0; i < counter; i++)
        {
            totalUnits++;
            yield();
        }
        try
        {
            // We synchronize on the pool to avoid possible
            // threading problems, and return our object.
            synchronized (hostPool)
            {
                this.valid = false;
                hostPool.returnObject(this);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
