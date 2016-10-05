package com.liulangf.pattern.beforeafter;

/**
 * @author LiuYuQing
 * @version 1.0 2010-11-10
 */
public class SubclassedTank extends TankImpl {

	protected void checkVolumeInvariant() throws AssertionError {
		float v = getVolume();
		float c = getCapacity();
		if (!(v >= 0.0 && v <=c)) {
			throw new AssertionError();
		}
	}
	
	//注意加了synchronized 
	@Override
	public synchronized void transferWater(float amount) 
	    throws OverflowException, UnderflowExceptoin {
		//before-check
		checkVolumeInvariant();
		try {
			//调用父类方法
			super.transferWater(amount);
		} catch (OverflowException e) {
			throw e;
		} catch (UnderflowExceptoin e) {
			throw e;
		} finally {
			//after-check
			checkVolumeInvariant();
		}
	}
	
	
}
