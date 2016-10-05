package com.liulangf.generic.oreilly.pattern.visitor;

/**
 *
 * @author Quqing Liu
 */
public abstract class Tree<E> {
	
	/**
	 * E : element of Tree
	 * R : return type of visitor 
	 *
	 */
	public interface Visitor<E, R> {
		public R leaf(E elt);
		public R branch(R left, R right);
	}
	
	public abstract <R> R visit(Visitor<E, R> visitor);
	
	public static <T> Tree<T> leaf(final T e) {
		return new Tree<T>() {
			public <R> R visit(Visitor<T, R> v) {
				return v.leaf(e);
			}
		};
	}
	public static <T> Tree<T> branch(final Tree<T> l, final Tree<T> r) {
		return new Tree<T>() {
			public <R> R visit(Visitor<T, R> visitor) {
				return visitor.branch(l.visit(visitor), r.visit(visitor));
			}
		};
	}

}
