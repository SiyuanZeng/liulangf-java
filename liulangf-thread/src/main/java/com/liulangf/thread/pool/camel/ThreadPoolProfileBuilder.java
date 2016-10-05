package com.liulangf.thread.pool.camel;

import java.util.concurrent.TimeUnit;

public class ThreadPoolProfileBuilder {
    private final ThreadPoolProfile profile;

    public ThreadPoolProfileBuilder(String id) {
        this.profile = new ThreadPoolProfile(id);
    }

    public ThreadPoolProfileBuilder(String id, ThreadPoolProfile origProfile) {
        this.profile = origProfile.clone();
        this.profile.setId(id);
    }
    
    public ThreadPoolProfileBuilder defaultProfile(Boolean defaultProfile) {
        this.profile.setDefaultProfile(defaultProfile);
        return this;
    }


    public ThreadPoolProfileBuilder poolSize(Integer poolSize) {
        profile.setPoolSize(poolSize);
        return this;
    }

    public ThreadPoolProfileBuilder maxPoolSize(Integer maxPoolSize) {
        profile.setMaxPoolSize(maxPoolSize);
        return this;
    }

    public ThreadPoolProfileBuilder keepAliveTime(Long keepAliveTime, TimeUnit timeUnit) {
        profile.setKeepAliveTime(keepAliveTime);
        profile.setTimeUnit(timeUnit);
        return this;
    }

    public ThreadPoolProfileBuilder keepAliveTime(Long keepAliveTime) {
        profile.setKeepAliveTime(keepAliveTime);
        return this;
    }
    
    public ThreadPoolProfileBuilder maxQueueSize(Integer maxQueueSize) {
        if (maxQueueSize != null) {
            profile.setMaxQueueSize(maxQueueSize);
        }
        return this;
    }

    public ThreadPoolProfileBuilder rejectedPolicy(ThreadPoolRejectedPolicy rejectedPolicy) {
        profile.setRejectedPolicy(rejectedPolicy);
        return this;
    }

    /**
     * Builds the new thread pool
     * 
     * @return the created thread pool
     * @throws Exception is thrown if error building the thread pool
     */
    public ThreadPoolProfile build() {
        return profile;
    }


}
