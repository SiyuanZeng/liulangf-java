package com.liulangf.pattern.beforeafter;

/**
 * @author LiuYuQing
 * @version 1.0 2010-11-10
 */
public class TankWithMethodAdapter {
	
	protected void checkVolumeInvariant() throws AssertionError {
//		float v = getVolume();
//		float c = getCapacity();
//		if (!(v >= 0.0 && v <=c)) {
//			throw new AssertionError();
//		}
	}

	protected void runWithinBeforeAfterChecks(TankOp cmd) 
	    throws OverflowException, UnderflowExceptoin {
		//before-check
		checkVolumeInvariant();
		try {
			cmd.op();
		} catch (OverflowException e) {
			throw e;
		} catch (UnderflowExceptoin e) {
			throw e;
		} finally {
			//after-check
			checkVolumeInvariant();
		}
	}
	
	protected void doTransferWater(float amount) throws OverflowException, UnderflowExceptoin {
		//.......
	}
	
	//注意加了synchronized 
	public synchronized void transferWater(final float amount) 
	    throws OverflowException, UnderflowExceptoin {
		runWithinBeforeAfterChecks(new TankOp() {
			public void op() throws OverflowException, UnderflowExceptoin {
				doTransferWater(amount);
			}
		});
	}
	
}
