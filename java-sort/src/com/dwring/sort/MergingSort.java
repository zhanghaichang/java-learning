package com.dwring.sort;

import java.util.Arrays;


/**
 * @Title: MergingSort.java
 * @Package com.dwring.sort
 * @Description: 合并排序
 * @author haichangzhang
 * @date 2018年4月12日 下午4:56:37
 * @version V1.0
 */
public class MergingSort {

	// 排序原始数据
	public static final int[] NUMBERS = { 12, 38, 10, 2, 5, 99, 98, 54, 56, 4, 0 };

	public static void main(String[] args) {
		mergeSort(NUMBERS, 0, NUMBERS.length - 1);

	}

	private static void mergeSort(int[] data, int left, int right) {
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			mergeSort(data, left, center);
			mergeSort(data, center+1, right);
			merge(data, left, center, right);
		}
	    System.out.println(" mergingSort "+ Arrays.toString(data) );
	}

	private static void merge(int[] data, int left, int center, int right) {
		int[] tempArr = new int[data.length];
		int mid = center + 1;
		// third记录中间数组的索引
		int third = left;
		int tem = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最小的放入中间数组
			if (data[left] <= data[mid]) {
				tempArr[third++] = data[left++];
			} else {
				tempArr[third++] = data[mid++];
			}

		}
		// 剩余部分依次放入中间数组
		while (mid <= right) {
			tempArr[third++] = data[mid++];
		}
		while (left <= center) {
			tempArr[third++] = data[left++];
		}
		// 将中间数组中的内容复制回原数组
		while (tem <= right) {
			data[tem] = tempArr[tem++];
		}
	}
}
