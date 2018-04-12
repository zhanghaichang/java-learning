package com.dwring.sort;

import java.util.Arrays;

/**
 * @Title: ShellSort.java
 * @Package com.dwring.sort
 * @Description: 希尔排序
 * @author haichangzhang
 * @date 2018年4月12日 下午12:15:55
 * @version V1.0
 */
public class ShellSort {

	public static final int[] NUMBERS = { 12, 38, 10, 2, 5, 99, 98, 54, 56, 4, 0 };

	public static void main(String[] args) {
		System.out.println("shell Sort=" + Arrays.toString(NUMBERS));
		shellSort(NUMBERS);

	}

	/**
	 * 希尔排序
	 */
	public static void shellSort(int[] arr) {
		// i表示希尔排序中的第n/2+1个元素（或者n/4+1）
		// j表示希尔排序中从0到n/2的元素（n/4）
		// r表示希尔排序中n/2+1或者n/4+1的值
		int i, j, r, tmp;
		// 划组排序
		for (r = arr.length / 2; r >= 1; r = r / 2) {
			for (i = r; i < arr.length; i++) {
				tmp = arr[i];
				j = i - r;
				System.out.println("==================: " +j);
				// 一轮排序
				while (j >= 0 && tmp < arr[j]) {
					arr[j + r] = arr[j];
					j -= r;
				}
				arr[j + r] = tmp;
				System.out.println(" ===:=== "+ i  + Arrays.toString(arr));
			}
			System.out.println("-------"+r + ":" + Arrays.toString(arr));
		}
	}
}
