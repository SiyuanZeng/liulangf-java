package com.liulangf.ioc.guice;

import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 *
 */
public class ServerConfigModule extends AbstractModule {

    public static final String SERVER_BASE = "server.base";

    @Override
    protected void configure() {
        // bind the properties
        try {
            Properties properties = loadProperties();
            java.util.Properties p = System.getProperties();
            String serverBase = p.getProperty(SERVER_BASE);
            //set the account File to the data directory
            if (serverBase != null && serverBase.trim().length() > 0) {
                String accountName = properties.getProperty("accountFileName");
                properties.setProperty("accountFileName", serverBase + "/data/" + accountName);
            }
            Names.bindProperties(binder(), properties);
            System.out.println("Loaded SAcct Server Configuration successfully");
        } catch (Exception e) {
            // handle the exception
            System.out.println("Error loading Server Configuration " + e.getMessage());
            System.out.println("Use Server Default Configuration.");
        }
    }
    
    private Properties loadProperties() {
        return null;
    }
    
}
