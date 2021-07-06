package leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Array {
	public static void main(String[] args) {
		//1.静态创建数组方法
		//方法1
		int[] arr1= {1,4,2,3};
		//方法2
		int[] arr2=new int[] {1,2,3,4};
		//动态创建数组方法
		//方法3
		int[] arr3= new int[4];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i]=i+1;
		}
		System.out.println(arr3);
		//方法4  用的最多
		ArrayList<Integer> arr4=new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			arr4.add(i+1);			
		}
		//2 添加元素
		/***
		array类型数组创建之后无法添加元素，只能重新再次创建元素
		arraylist类型数组，是动态数组，创建之后长度可以改变
		***/
		//像最后一位添加元素
		arr4.add(5);
		//像原索引位置之前添加元素
		arr4.add(2, 99);
		
		//3 访问元素
		int arr1_1=arr1[1];
		int arr4_1=arr4.get(1);
		
		//4 移除元素
		arr4.remove(3);
		
		//5 读取数组长度
		int arraylength=arr1.length;
		int arrayListLength=arr4.size();
		
		//6 遍历数组中所有元素
		for (int i = 0; i < arr3.length; i++) {
			int currentElement=arr3[i];
			System.out.println("arr3 的"+i+"索引元素值为: "+currentElement);
		}
		for (int i = 0; i < arr4.size(); i++) {
			int currentElement=arr4.get(i);
			System.out.println("arr4 的"+i+"索引元素值为: "+currentElement);			
		}
		
		//6 查找数组中是否存在一个元素
		for (int i = 0; i < arr3.length; i++) {
			if (arr3[i]==99) {
				System.out.println("99 在数组arr3中");
			}
		}
		boolean is99=arr4.contains(99);

		
		//7 排序
		Arrays.sort(arr1);
		System.out.println("arr1 sort"+Arrays.toString(arr1));
		Collections.sort(arr4);
		System.out.println("arr4 sort"+arr4);
		Collections.sort(arr4,Collections.reverseOrder());
		System.out.println("arr4 sort reverseOrder:"+arr4);		
	}

}
