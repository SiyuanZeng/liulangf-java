package com.liulangf.pattern.beforeafter;

/**
 * @author LiuYuQing
 * @version 1.0 2010-11-10
 */
public class TemplateMethodTank extends AbstractTank {
	
	protected void doTransferWater(float amount) throws OverflowException, UnderflowExceptoin {
		
	}

	@Override
	public float getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

abstract class AbstractTank implements Tank {
	
	protected void checkVolumeInvariant() throws AssertionError {
		float v = getVolume();
		float c = getCapacity();
		if (!(v >= 0.0 && v <=c)) {
			throw new AssertionError();
		}
	}
	
	protected abstract void doTransferWater(float amount) throws OverflowException, UnderflowExceptoin;
	
	//注意加了synchronized 
	@Override
	public synchronized void transferWater(float amount) 
	    throws OverflowException, UnderflowExceptoin {
		//before-check
		checkVolumeInvariant();
		try {
			doTransferWater(amount);
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
