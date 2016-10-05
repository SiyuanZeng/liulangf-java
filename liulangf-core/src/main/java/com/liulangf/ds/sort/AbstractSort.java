package com.liulangf.ds.sort;


public abstract class AbstractSort implements Sort{
	protected String name;
	
	public AbstractSort() {
		name = getClass().getSimpleName();
	}
	
	public AbstractSort(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	protected void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
}
