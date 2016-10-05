package com.liulangf.pattern.common;

/**
 * @author LiuYuQing
 * @version 1.0 2010-6-12
 */
public class EqualsHashCode {
	
	private int size;
	private long time;
	private double prize;
	private boolean right;
	private float deal;
	private char type;
	private String name;
	
	/**
	 * 1.自反性(reflexive). x != null 时, x.equals(x) === true;
	 * 2.对称性(symmetric). x, y != null 时, x.equals(y) == true  ==> y.equals(x) == true;
	 * 3.传递性(transitive). x,y,z != null 时, if (x.equals(y)==true && y.equals(z) == true) ==> x.equals(z) == true;
	 *   传递性 经常被子类中添加新的字段所破坏，因为子类中添加新的字段会影响equals的比较结果
	 * 4.一致性(consistent). x.equals(y) 总是返回相同的值。
	 * 5.非空性(Non-nullity). x.equals(null) === false.  但是： if (o == null) return false; 得测试却是不必要的。
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		//1.
		if (this == o) {
			return true;
		}
		
		//2.
		if (!(o instanceof EqualsHashCode)) {
			return false;
		}
		
		//3.
		EqualsHashCode other = (EqualsHashCode)o;
		boolean result = size == other.size;
		result = result && time == other.time;
		result = result && (name == other.name || (name != null && name.equals(other.name)));
		result = result && Float.compare(deal, other.deal) == 0;
		result = result && Double.compare(prize, other.prize) == 0;
		result = result && right == other.right;
		result = result && type == other.type;
		return result;
	}

	@Override 
	public int hashCode() {
		int result = 17;
		result = 31 * result + size;            //int
		result = 31 * result + (right ? 1 : 0); //boolean
		result = 31 * result + (int)type;       //byte,char,short ==> (int)field;
		result = 31 * result + (int)(time ^ (time >>> 32));//long
		//double --> long --> int
		long prize2 = Double.doubleToLongBits(prize);
		result = 31 * result + (int)(prize2 ^ (prize2 >>> 32));//long
		result = 31 * result + Float.floatToIntBits(deal);// float
		result = 31 * result + name == null ? 0 : name.hashCode();//
		return result;
	}
	

}
