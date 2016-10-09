package com.liulangf.pattern.gof.creational.builder;

/**
 *
 */
public class CommonBuilder3 {
    
    class Config {
        private String name;
        private String address;
        //.....
        
        public String getName() {
            return name;
        }
        
        public String getAddress() {
            return address;
        }
    }
    
    class ConfigBuilder {
        private final Config config;
        
        public ConfigBuilder() {
            this.config = new Config(); 
        }
        
        public ConfigBuilder name(String name) {
            config.name = name;
            return this;
        }
        
        public ConfigBuilder address(String address) {
            config.address = address;
            return this;
        }
        
        public Config build() {
            return config;
        }
    }

}
