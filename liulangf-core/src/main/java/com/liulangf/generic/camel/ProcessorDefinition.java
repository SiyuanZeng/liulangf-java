/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic.camel;


/**
 * see org.apache.camel.model.ProcessorDefinition<Type extends ProcessorDefinition<Type>>. 
 * 
 * @author YuQing Liu
 */
public abstract class ProcessorDefinition<Type extends ProcessorDefinition<Type>> {
	
	/**
     * Sends the exchange to the given endpoint
     *
     * @param uri  the endpoint to send to
     * @return the builder
     */
    @SuppressWarnings("unchecked")
    public Type to(String uri) {
        return (Type) this;
    }
    
    /**
     * What is the difference between getThis() trick???
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public Type getThis() {
    	//Type mismatch: cannot convert from ProcessorDefinition<Type> to Type
    	//return this;
    	return (Type) this;
    }
	

}
