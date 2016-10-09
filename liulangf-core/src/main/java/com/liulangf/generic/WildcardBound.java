package com.liulangf.generic;

import java.util.List;
import java.util.Collection;

/**
 * wildcard bound: ? extend T, ? super T
 * generic bound : T extends A & B;
 * 
 * ? stands for an unknown type.
 * ? extends T  denotes an unknown type that is a subtype of T.
 * ? super T denotes an unknown type that is a supertype of T.
 * 
 * List<? extends Shape> : Shape is the upper bound of the wildcard. 
 * List<? super T>       : T is the lower bound of the wildcard.
 *
 * List<?>, List<? extends T> : read-only structure
 * List<? super T>            : write-only structure
 * 
 * @author Quqing Liu
 */
public class WildcardBound {

	interface Sink<T> {
		void flush(T t);
	}
	
	//? super T
	public static <T> T writeAll(Collection<T> coll, Sink<? super T> sink) {
		T last = null;
		for (T t : coll) {
			last = t;
			sink.flush(last);
		}
		return last;
	}
	
	public void client() {
		Sink<Object> s = null;
		Collection<String> cs = null;
		
		//compiler will infer the type argument: the inferred type is String,
		//String => T
		String str = writeAll(cs, s);
	}

	interface Shape{}
	class Circle implements Shape {}
	
	/**
	 * The type of the parameter to shapes.add() is ? extends Shape - an unknown subtype of Shape. 
	 * Since we don’t know what type it is, we don’t know if it is a supertype of Rectangle; 
	 * it might or might not be such a supertype, so it isn’t safe to pass a Circle there.
	 * 
	 * @param shapes
	 */
	public void addShape(List<? extends Shape> shapes) {
		//Compile error
		//shapes.add(new Circle());
	}
	
}

