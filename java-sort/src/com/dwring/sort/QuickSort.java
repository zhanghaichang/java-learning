package com.dwring.sort;

import java.util.Arrays;

/**
 * @Title: QuickSort.java
 * @Package com.dwring.sort
 * @Description: 快速排序
 * @author haichangzhang
 * @date 2018年4月12日 下午3:36:06
 * @version V1.0
 */
public class QuickSort {

	// 排序原始数据
	public static final int[] NUMBERS = { 12, 38, 10, 2, 5, 99, 98, 54, 56, 4, 0 };

	public static void main(String[] args) {
		_quickSort(NUMBERS, 0, NUMBERS.length - 1);
		System.out.println(" quickSort "+Arrays.toString(NUMBERS) );
	}

	public static void _quickSort(int[] list, int low, int high) {
		if (low < high) { 
			int middle = getMiddle(list, low, high);// 将list数组进行一分为二
			System.out.println(" middle ：  "+middle);
			System.out.println(" quickSort "+Arrays.toString(NUMBERS) );
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			System.out.println(" quickSort "+Arrays.toString(NUMBERS) );
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
 
	}

	private static int getMiddle(int[] list, int low, int high) {
		int temp = list[low];// 数组的第一个作为中轴 
		while (low < high) {
 			while (low < high && list[high] >= temp) {
				high--;
			}
			list[low] = list[high];// 比中轴小的记录移到低端
			while (low < high && list[low] <= temp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = temp; // 中轴记录到尾
		return low;// 返回中轴的位置
	}

}
