package com.liulangf.util;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author liulangf
 *
 */
public class SystemPropertyInJava {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemPropertyInJava.class); 
    
    /**
     * See java doc of System.getProperties() for more detail.
     * java.lang.System;
     * org.apache.commons.lang3.SystemUtils;
     */
    void using_system_property() {
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> sets = properties.entrySet();
        
        LOGGER.info("\n\n====System Properties:====");
        for (Map.Entry<Object, Object> entry : sets) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            LOGGER.info("[{}  -  {}]", key, value);
        }
        
        LOGGER.info("\n\n====Evn Properties:====");
        for (Map.Entry<String, String> e : System.getenv().entrySet()) {
            LOGGER.info("[{}  -  {}]", e.getKey(), e.getValue());
        }
    }
    
}
