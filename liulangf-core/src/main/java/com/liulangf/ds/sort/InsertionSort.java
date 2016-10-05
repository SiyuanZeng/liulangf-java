package com.liulangf.ds.sort;

/**
 * 插入排序：
 * 就像摸扑克牌一样，每次摸一张牌都插入到有序的位置上。
 * 
 * @author LiuYuQing
 * @version 1.0 2010-6-13
 */
public class InsertionSort extends AbstractSort implements Sort {
	
	@Override
	public void sort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			insert(data, data[i], i);
		}
	}
	
	/**
	 * insert key into the sorted sequence data[0 - j];
	 * 
	 * @param data
	 * @param key
	 * @param j
	 */
	private void insert(int[]data, int key, int j) {
		while (j > 0 && data[j-1] > key) {
			data[j] = data[j-1];
			j--;
		}
		data[j] = key;
	}
	
}
