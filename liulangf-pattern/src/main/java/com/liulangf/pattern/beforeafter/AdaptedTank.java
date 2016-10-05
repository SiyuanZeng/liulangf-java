package com.liulangf.pattern.beforeafter;

/**
 * Using adapter to add more works.
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-9
 */
public class AdaptedTank implements Tank {
	protected final Tank delegate;
	public AdaptedTank(Tank delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public float getCapacity() {
		return delegate.getCapacity();
	}
	
	@Override
	public float getVolume() {
		return delegate.getVolume();
	}
	
	//注意加了synchronized 
	@Override
	public synchronized void transferWater(float amount) 
	    throws OverflowException, UnderflowExceptoin {
		//before-check
		checkVolumeInvariant();
		try {
			delegate.transferWater(amount);
		} catch (OverflowException e) {
			throw e;
		} catch (UnderflowExceptoin e) {
			throw e;
		} finally {
			//after-check
			checkVolumeInvariant();
		}
	}
	
	protected void checkVolumeInvariant() throws AssertionError {
		float v = getVolume();
		float c = getCapacity();
		if (!(v >= 0.0 && v <=c)) {
			throw new AssertionError();
		}
	}
	
	
	public static void main(String...args) {
		//just a demo
		Tank tank = new AdaptedTank(new Tank() {
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
		});
		
		try {
			tank.transferWater(100);
		} catch (OverflowException e) {
			e.printStackTrace();
		} catch (UnderflowExceptoin e) {
			e.printStackTrace();
		}
		
	}
	
}
