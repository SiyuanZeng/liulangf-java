package com.liulangf.generic;

import java.util.ArrayList;
import java.util.Collection;

public class WildcardCapture2 {

	public static <T extends Comparable<T>> void print(Collection<T> coll) {
		for (T obj : coll) {
			System.out.println(obj);
		}
	}

	public static void main(String[] args) {
		//Collection<? /* extends Comparable */> aColl = new ArrayList<Integer>();
		Collection<? extends Comparable> aColl = new ArrayList<Integer>();
		aColl.add(null);
		print(aColl);
	}
}
