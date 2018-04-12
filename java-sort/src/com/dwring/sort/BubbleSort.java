package com.dwring.sort;

import java.util.Arrays;

/**
 * @Title: BubbleSort.java
 * @Package com.dwring.sort
 * @Description: 冒泡排序
 * @author haichangzhang
 * @date 2018年4月12日 下午3:06:09
 * @version V1.0
 */
public class BubbleSort {

	// 排序原始数据
	public static final int[] NUMBERS = { 12, 38, 10, 2, 5, 99, 98, 54, 56, 4, 0 };

	public static void main(String args[]) {
		bubbleSort(NUMBERS);
	}

	public static void bubbleSort(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					System.out.println("j ========  "+j+Arrays.toString(array));
				}
			}
			System.out.println("----" +Arrays.toString(array));
		}
		System.out.println(Arrays.toString(array));
	}

}
