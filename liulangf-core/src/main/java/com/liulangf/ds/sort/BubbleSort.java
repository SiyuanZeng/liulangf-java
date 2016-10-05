package com.liulangf.ds.sort;

/**
 * @author LiuYuQing
 * @version 1.0 2010-6-13
 */
public class BubbleSort extends AbstractSort implements Sort{

	@Override
	public void sort(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
				}
			}
	    }
	}
	
}
