package com.liulangf.generic;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * ? : question marks in generic argument expressions.
 * unbounded wildcard : <?>
 * bounded wildcard   : <? extends T> : read-only
 * bounded wildcard   : <? super T>   : write-only
 * 
 * The type Collection<?> stands for:
 * Collection<? extends Object>
 * Extending Object is one of the most common uses of wildcards, so it makes sense to provide a short form for writing it.
 * 
 * @author Quqing Liu
 */
public class WildcardsInGeneric {
	
	/**
	 * Since you've declared the list as a List<?>, get() now returns an Object, which is as close to "unknown" as Java gets. 
	 * At the same type, this is very different from a List<Object>, which can only work with Objects. 
	 * Where things get even odder is for the add() and other methods that take a parameter that matches the type of the collection. 
	 * Since the compiler cannot check to ensure type-safety, it rejects any call to add(), addAll(), and set() for a List<?>. 
	 * In other words, supplying the wildcard to a generic type effectively makes it read-only.
	 * 
	 * @param list
	 * @param out
	 * @throws IOException
	 */
	public void printList(List<?> list, PrintStream out) throws IOException {
		for (Iterator<?> i = list.iterator(); i.hasNext();) {
			out.println(i.next().toString());
		}
	}
	
	/**
	 * So what is the supertype of all kinds of collections? It’s written Collection<?> 
	 * (pronounced “collection of unknown”) , that is, a collection whose element type matches anything.
	 * 
	 * Since we don’t know what the element type of all stands for, we cannot add objects to it. 
	 * The add() method takes arguments of type E, the element type of the collection. 
	 * When the actual type parameter is ?, it stands for some unknown type.
	 * Any parameter we pass to add would have to be a subtype of this unknown type. 
	 * Since we don’t know what type that is, we cannot pass anything in. The sole exception is null, 
	 * which is a member of every type.
	 * @param all
	 */
	public void readOnly(/* it is read only */Collection<?> all) {
	}
	
}
