package com.liulangf.thread.pool.commons;

import org.apache.commons.pool.PoolableObjectFactory;

public class WorkerThreadFactory implements PoolableObjectFactory
{

    /** Keeps track of the currently created thread. */
    public int currentThread = 0;

    /**  Create and name the thread.  Naming the thread is very 
     * helpful when trying to debug multi-threaded applications.
      */
    public Object makeObject() throws Exception
    {
        WorkerThread temp = new WorkerThread();
        temp.setName("Worker Thread #" + currentThread++);
        return temp;
    }

    /** We aren't reusing threads, so we always return false here,
     * causing the pool to remove this thread from the pool and 
     * create a new object using the makeObject() method.
     */
    public boolean validateObject(Object arg0)
    {
        return false;
    }
   
    public void destroyObject(Object arg0) throws Exception
    {
    }

    public void activateObject(Object arg0) throws Exception
    {
    }

    public void passivateObject(Object arg0) throws Exception
    {
    }
}
