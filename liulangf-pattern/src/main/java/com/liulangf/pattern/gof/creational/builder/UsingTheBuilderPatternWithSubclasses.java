package com.liulangf.pattern.gof.creational.builder;

/**
 * http://weblogs.java.net/node/642849
 * 
 * 
 * 
 * @author YuQing Liu
 */
public class UsingTheBuilderPatternWithSubclasses {
	

}
class Shape {
	private final double opacity;
	protected static abstract class Init<T extends Init<T>> {
		private double opacity;
		
		/**
		 * (This is what Angelika Langer calls the getThis() trick, citing Maurice Naftalin and Philip Wadler 
		 * for the name and Heinz Kabutz for the first publication.
		 * 
		 * @return
		 */
		protected abstract T self();
		
		/**
		 * The idea is that instead of hardwiring opacity() to return the type of the Builder that defines it,
		 * we introduce a type parameter T and we return T. The self-referential definition Init<T extends Init<T>> 
		 * is what allows us to make the type of the inherited opacity() in Rectangle.Builder be Rectangle.Builder 
		 * rather than Shape.Builder.
		 * 
		 * @param opacity
		 * @return
		 */
		public T opacity(double opacity) {
			this.opacity = opacity;
			return self();
		}
		
		public Shape build() {
			return new Shape(this);
		}
	}
	
	public static class Builder extends Init<Builder> {
		@Override protected Builder self() {
			return this;
		}
	}
	
	protected Shape(Init<?> init) {
		this.opacity = init.opacity;
	}
	
	public double getOpacity() {
		return this.opacity;
	}
}

class Rectangle extends Shape {
	private final double height;
	
	protected static abstract class Init<T extends Init<T>> extends Shape.Init<T> {
		private double height;
		public T height(double height) {
			this.height = height;
			return self();
		}
		
		public Rectangle build() {
			return new Rectangle(this);
		}
	}
	protected Rectangle(Init<?> init) {
		super(init);
		this.height = init.height;
	}
	
	public double getHeight() {
		return this.height;
	}
}
