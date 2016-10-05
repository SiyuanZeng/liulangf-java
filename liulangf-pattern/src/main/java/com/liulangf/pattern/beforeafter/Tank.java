package com.liulangf.pattern.beforeafter;

/**
 * @author LiuYuQing
 * @version 1.0 2010-11-9
 */
public interface Tank {

	float getCapacity();
	float getVolume();
	void transferWater(float amount) throws OverflowException, UnderflowExceptoin;
}
