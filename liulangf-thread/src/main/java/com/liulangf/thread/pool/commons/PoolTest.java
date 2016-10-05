package com.liulangf.thread.pool.commons;

import org.apache.commons.pool.impl.GenericObjectPool;

public class PoolTest extends Thread
{
    /** This main method simply creates a new PoolTest thread 
     * and starts it. */
    public static void main(String[] args)
    {
        new PoolTest().start();
    }

    /** The run() method (called when the PoolTest thread starts)
     * merely executes a series of test in serial fashion.
     */
    public void run()
    {

        runTest(30, 30);
        runTest(100, 100);
        runTest(1000, 1000);

        runTest(1000, 2000);
        runTest(1, 3000);
        runTest(10, 3000);
        runTest(30, 3000);
        runTest(1000, 3000);

        System.out.println("Most efficient @ " + mostEfficientTime);
        System.out.println(
            "("
                + mostEfficientThreads
                + "/"
                + mostEfficientRuns
                + ")");

        System.out.println("Done.");

    }

    /** Used to keep track of the most efficient run */
    int mostEfficientThreads = 0;
    int mostEfficientRuns = 0;
    float mostEfficientTime = 0;

    /** This method actually runs the test.  The higher the
     * maxThreads value, the more threads can be created to run in
     * parallel.  The threadRuns indicates the total number of 
     * threads that will be created.
     * 
     * @param maxThreads Used to specify the maximum number 
     * of threads to be created by the object pool.
     * 
     * @param threadRuns The number of executions of the thread 
     * to be run.
     */
    public void runTest(int maxThreads, int threadRuns)
    {
        System.out.println(
            "Starting " + maxThreads + "/" + threadRuns);
        
        
        // Create an instance of our WorkerThreadFactory.
        WorkerThreadFactory myFactory = new WorkerThreadFactory(); 

        // Here, we create a generic object pool, passing in our
        // WorkerThreadFactory.        
        GenericObjectPool myPool =
            new GenericObjectPool(myFactory);

        // Here, we configure the behavior of our pool.
        // Note the use of maxThreads to configure the number of
        // threads we want to allocate, and the behavior of the
        // threads.
        myPool.setMaxActive(maxThreads);
        myPool.setWhenExhaustedAction(
            GenericObjectPool.WHEN_EXHAUSTED_BLOCK);
        myPool.setTestOnReturn(true);

        // Gather the current timing info, and start making
        // threads.  Note that this will block if there is no
        // thread available.
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < threadRuns; i++)
        {
            try
            {
                WorkerThread myThread =
                    (WorkerThread)myPool.borrowObject();
                myThread.setPool(myPool);
                myThread.start();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        // Now, make sure that all of the threads we kicked off
        // have a chance to finish up what they are doing.
        while (myPool.getNumActive() > 0)
        {
            yield();
        }
        
        // Let's do some reporting of the results.
        long time = System.currentTimeMillis() - currentTime;
        System.out.println(
            "Total created threads:"
                + myFactory.currentThread);
        System.out.println("Seconds Elapsed: " + (time / 1000f));
        System.out.println(
            "Completed:            " + WorkerThread.totalUnits);

        float efficiency = WorkerThread.totalUnits / (time / 1000f);
        System.out.println("units/second:       " + efficiency);

        // If this is our most efficient run, we should note that.
        if (efficiency > mostEfficientTime)
        {
            mostEfficientTime = efficiency;
            mostEfficientThreads = maxThreads;
            mostEfficientRuns = threadRuns;
        }
        System.out.println();

        // Reset the work done by the threads for the next test.
        WorkerThread.totalUnits = 0;

    }
}
