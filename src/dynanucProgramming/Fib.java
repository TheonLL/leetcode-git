package dynanucProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;


public class Fib {

	public static void main(String[] args) {
		System.out.println("请输入：");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		Fib instanceFib=new Fib();
		System.out.println(instanceFib.fibState(n));

	}
	
	
	//1 直接采用递归暴力穷举
	public int fib(int n ) {
		if(n==1||n==2) {
			return 1;
		}else {
			return fib(n-1)+fib(n-2);
		}
		
	}
	
	
	//2 带备忘录的递归解法
	public int fibMemo(int n) {
		//明确base case
		if (n<1) {
			return 0;
		}
		//创建备忘录  数组、map；
		Map<Integer, Integer> recMap=new HashMap<>();
		return helper(n,recMap);
		
	}	
	public int  helper(int n,Map<Integer, Integer> recMap) {
		//base case
		if (n==1||n==2) {
			return 1;
		}else {
			//判断备忘录种是否含有该子结构
			//如果有 则直接取出值返回 不用继续计算
			if (recMap.containsKey(n)) {
				return recMap.get(n);
			//如果没有 则将该值添加到备忘录中 并返回值
			}else {
				int values=helper(n-1, recMap)+helper(n-2, recMap);
				recMap.put(n, values);
				return values;
			}
		}
		
		
	}
	
	//3 dp数组的迭代解法
	public Vector fibDpAar(int n) {
		Vector<Integer> dpList = new Vector(n+1, 2);
			//base case
			dpList.add(1);
			dpList.add(1);
			for (int i=3;i<=n;++i) {
				dpList.set(i,dpList.get(i-1)+dpList.get(i-2));
			}
			return dpList;	
	}
	
	
	
	
	//4 根据斐波那契数列 当前状态只跟前两个状态有关的特点
	public int fibState(int n) {
		int preValue=1;
		int currValue=1;
		if (n==1||n==2) {
			return 1;
		}else {
			for (int i = 3; i <=n; ++i) {
				int sum=preValue+currValue;
				preValue=currValue;
				currValue=sum;
			}
		}
		return currValue;
	}
}

