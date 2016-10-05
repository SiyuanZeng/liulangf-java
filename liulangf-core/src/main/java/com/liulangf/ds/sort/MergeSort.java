package com.liulangf.ds.sort;

/**
 * Merge sort 的基本思想是 ： divide and conquer(分而治之)
 * The key operation of the merge sort algorithm is the merging of
 * two sorted sequences.
 * 
 * @author LiuYuQing
 * @version 1.0 2010-6-13
 */
public class MergeSort extends AbstractSort implements Sort {
	
	@Override
	public void sort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	
	private void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right)/2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}
	
	/**
	 * merge two sorted sequences
	 * 
	 * @param a
	 * @param left
	 * @param mid
	 * @param right
	 */
	private void merge(int[] a, int left, int mid, int right) {
		int leftEnd = mid;
		int rightStart = mid + 1;
		while (left <= leftEnd && rightStart <= right) {
			if (a[left] < a[rightStart]) {
				left++;
			} else {
				int temp = a[rightStart];
				for (int k = rightStart - 1; k >= left; k--) {
					a[k+1] = a[k];
				}
				a[left] = temp;
				left++;
				leftEnd++;
				rightStart++;
			}
		}
	}
	

}
