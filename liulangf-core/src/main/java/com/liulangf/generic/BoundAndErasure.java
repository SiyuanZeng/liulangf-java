/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic;

/**
 * <<Thinking in java>> 4th edition.
 * 
 * Erasure removes type information, Bounds allow you to place constrains on 
 * the parameter types that can be used with generics. You can then call
 * methods what are in your bound types.
 *
 * @author Quqing Liu
 */
public class BoundAndErasure {

	interface HasColor {
		java.awt.Color getColor();
	}
	
	class Colored<T extends HasColor> {
		T item;
		Colored(T item) {
			this.item = item;
		}
		
		T getItem() {
			return item;
		}
		
		java.awt.Color color() {
			//The bound allows you to call a method.
			return item.getColor();
		}
	}
	
	class Dimension {
		public int x, y, z;
	}
	
	//This won't work --- class must be first, then interfaces
	//class ColoredDimension<T extends HasColor & Dimension>
	//Multiple bounds:
	class ColoredDimension<T extends Dimension & HasColor> {
		T item;
		ColoredDimension(T item) {
			this.item = item;
		}
		
		java.awt.Color color() {
			return item.getColor();
		}
		
		int getX() {
			return item.x;
		}
		int getY() {
			return item.y;
		}
		int getZ() {
			return item.z;
		}
	}
	
}