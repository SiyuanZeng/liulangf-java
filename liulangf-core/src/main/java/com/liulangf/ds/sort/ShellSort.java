package com.liulangf.ds.sort;

/**
 * @author LiuYuQing
 * @version 1.0 2010-6-13
 */
public class ShellSort extends AbstractSort implements Sort{
	
	@Override
	public void sort(int[] a) {
		int h = h(a.length);
		while (h > 0) {
			for (int i = h - 1; i < a.length; i++) {
				int b = a[i];
				int j = i;
				for (j = i; (j >= h) && (a[j - h] > b); j -= h) {
					a[j] = a[j - h];
				}
				a[j] = b;
			}
			//all sets h-sorted, now decrease set size
			h = h / 3;
		}
	}
	
	/**
	 * find the largest h value possible.
	 * @param length
	 * @return
	 */
	private int h(int length) {
		int h = 1;
		while ((h * 3 + 1) < length) {
			h = 3 * h + 1;
		}
		
		return h;
	}

}
