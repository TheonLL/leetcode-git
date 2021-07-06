package leetcode.util;

import java.util.Scanner;

public class InOut {

	
	
	public void scannerIn() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入string类型:");
		String string=scanner.nextLine();
		System.out.println("输入int类型数据:");
		int intVar=0;
		float floatVar=0;
		if(scanner.hasNextInt()) {
			intVar=scanner.nextInt();
		}
		System.out.println("请输入float类型数据:");
		if (scanner.hasNextFloat()) {
		 floatVar=scanner.nextFloat();
		}
		System.out.printf("输入的string类型数据为%s，int类型数据为%d，float类型数据为%f",string,intVar,floatVar);
		
		
	}
	public static void main(String[] args) {
		InOut inOut= new InOut();
		inOut.scannerIn();
		
	}

}
