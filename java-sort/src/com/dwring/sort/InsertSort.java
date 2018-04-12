package com.dwring.sort;

import java.util.Arrays;

/**
 * @Title: InsertSort.java
 * @Package com.dwring.sort
 * @Description: 插入排序
 * @author haichangzhang
 * @date 2018年4月12日 上午11:43:12
 * @version V1.0
 */
public class InsertSort {

	// 排序原始数据

	public static final int[] NUMBERS = { 12, 38, 10, 2, 5, 99, 98, 54, 56, 4, 0 };

	public static void main(String[] args) {
		insertSort(NUMBERS);
	}

	/**
	 * 插入排序
	 */
	public static void insertSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
 			for (; j >= 0 && array[j] > temp; j--) {
 				//将大于temp的值整体后移一个单位
				array[j + 1] = array[j];
				System.out.println("-----insertSort= "+Arrays.toString(array));
			}
			array[j + 1] = temp;
			System.out.println("=====insertSort= "+Arrays.toString(array));
		}
		System.out.println("insertSort="+Arrays.toString(array));
	}

}
