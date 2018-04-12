package com.dwring.sort;

import java.util.Arrays;

/**
 * @Title: SelectSort.java
 * @Package com.dwring.sort
 * @Description: 简单选择排序
 * @author haichangzhang
 * @date 2018年4月12日 下午2:36:08
 * @version V1.0
 */
public class SelectSort {

	// 排序原始数据
	public static final int[] NUMBERS = { 12, 38, 10, 2, 5, 99, 98, 54, 56, 4, 0 };

	public static void main(String[] args) {
		selectSort(NUMBERS);
	}

	/**
	 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
	* @Title: selectSort 
	* @param @param array    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void selectSort(int[] array) {
		int position = 0;
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			position = i;
			int temp = array[i];
			for (; j < array.length; j++) {
				if (array[j] < temp) {
					temp = array[j];
					position = j;
					// 选出最小数
				}
				System.out.println(" ======= " + temp);
			}
			array[position] = array[i];
			array[i] = temp;
		}
		System.out.println(" selectSort " + Arrays.toString(array));
	}
}
