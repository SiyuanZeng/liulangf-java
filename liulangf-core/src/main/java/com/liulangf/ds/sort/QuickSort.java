package com.liulangf.ds.sort;

/**
 * 
 * @author LiuYuqing
 */
public class QuickSort extends AbstractSort implements Sort{
	@Override
	public void sort(int[] data) {
		qSort(data, 0, data.length - 1);
	}
	
	public void qSort(int[] data, int l, int r) {
		if (l < r) {
			int m = partation(data, l, r);
			qSort(data, l, m - 1);
			qSort(data, m + 1, r);
		}
	}

	/**
	 * 划分的过程是： 
	 *  1. 指定一个哨兵 s
	 *  2. 比较数组，使得s是左边数组的最大值， 是右边数组的最小值。
	 *  3. j 移动前， i 总是指向小值数组的最后一个位置，
	 *  4. j 移动一个位置， 如果j的值不大于s， 则i指向大值数组的0索引，然后交换i，j，
	 *  i又重新指向小值数组的最后一个位置。
	 *  每次划分之，都为哨兵找到了其在数组中的位置。
	 *  
	 * @param data
	 * @param p
	 * @param r
	 * @return
	 */
	private int partation(int[] data, int p, int r) {
		int s = data[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (data[j] <= s) {
				i++;
				if (j != i) {
					swap(data, i, j);
				}
			}
		}
		//将哨兵置于数组中的正确位置
		int m = i + 1;
		swap(data, m, r);
		return m;
	}
}
