/**
 * 通过键盘输入的形式 生成一个输入 
 * 方法内部已经指定了数组的长度
 * 
 */

package leetcode.util;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayIO {
	    public static void main(String[] args){
	        int ARRAYLENGTH = 8;  //指定数组长度
	        int a[] = new int[ARRAYLENGTH];
	        Scanner sc = new Scanner(System.in);
	        System.out.println("请输入数组，并以回车结束：");
	        for(int i = 0; i < a.length; i++){
	            a[i] = sc.nextInt();
	        }
	        //直接打印数组a出来的是数组的首地址，必须用toString方法
	        System.out.println("数组a为:" + Arrays.toString(a)); 
	    }
	}
