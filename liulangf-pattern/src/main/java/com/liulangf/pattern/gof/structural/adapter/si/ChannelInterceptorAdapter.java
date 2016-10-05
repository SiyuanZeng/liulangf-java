package com.liulangf.pattern.gof.structural.adapter.si;

/**
 * A {@link ChannelInterceptor} with no-op method implementations so that
 * subclasses do not have to implement all of the interface's methods.
 * 
 * @author Mark Fisher
 */
public class ChannelInterceptorAdapter implements ChannelInterceptor {

	@Override
	public void preSend(Object message) {
	}

	@Override
	public void postSend(Object message) {
	}

	@Override
	public boolean preReceive() {
		return false;
	}

	@Override
	public Object postReceive() {
		return null;
	}

}
