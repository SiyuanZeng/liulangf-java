package com.liulangf.ds.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 南非世界杯之际整理排序排序算法
 * 
 * @author LiuYuQing
 * @version 1.0 2010-6-13
 */
public class WorldCup2010 {
	
	public static void main(String...args) {
		WorldCup2010 worldcup = new WorldCup2010();
		worldcup.sort(new QuickSort());
		worldcup.sort(new InsertionSort());
		worldcup.sort(new MergeSort());
		worldcup.sort(new BubbleSort());
	}
	
	public void sort(Sort sort) {
		sort.getName();
		int[] data = data(20);
		System.out.println("====" + sort.getName() + "====");
		System.out.println(Arrays.toString(data));
		sort.sort(data);
		System.out.println(Arrays.toString(data));
	}
	
	public void sort2(Sort sort) {
		sort.getName();
		int[] data = data(90000);
		System.out.println("====" + sort.getName() + "====");
		long start = System.currentTimeMillis();
		sort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Spends " + (end - start) + " mill seconds.");
	}
	
	protected static int[] data(int size) {
		Random rand = new Random();
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = rand.nextInt(100);
		}
		return data;
	}

	public static int[] data2(int size)  {
		return data2(size, 9);
	}
	
	public static int[] data2(int size, double f) {
		int a[] = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(a.length * f * Math.random());
		}
		
		return a;
	}
	
	public static void shuffle(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int j = (int)(i * Math.random());
			int t = data[i];
			data[i] = data[j];
			data[j] = t;
		}
	}
	
	/**
	 * Math.random ==> [0.0, 1.0)
	 * 
	 */
	public static void testRandom() {
		for (int i = 0; i < 100; i++) {
			System.out.println((int)(i * Math.random()));
		}
	}
}
