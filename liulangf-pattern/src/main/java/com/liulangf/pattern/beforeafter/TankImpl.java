package com.liulangf.pattern.beforeafter;

/**
 * @author LiuYuQing
 * @version 1.0 2010-11-10
 */
public class TankImpl implements Tank {

	@Override
	public float getCapacity() {
		return 0;
	}

	@Override
	public float getVolume() {
		return 0;
	}

	@Override
	public void transferWater(float amount) throws OverflowException,
			UnderflowExceptoin {
	}
}
