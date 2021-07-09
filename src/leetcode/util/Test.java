package leetcode.util;

import java.awt.print.Printable;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] intlist=new int[] {1,3,4,5};
		int[] newIntList=Arrays.copyOfRange(intlist, 1, 3);
		String string="adfjalAALKK";
		System.out.println(string.toUpperCase());
		System.out.println(string.substring(1,3));
		System.out.println(newIntList.length);
		System.out.println(Arrays.toString(newIntList));
	}

}
