/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-12-27 下午2:00:50
* Description :
*/
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
