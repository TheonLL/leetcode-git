package dynanucProgramming;

import java.util.Arrays;
import java.util.Iterator;

import javax.swing.plaf.InputMapUIResource;

/*
 * Targetsum 采用回溯法思路求解
 */
public class TargetSum {

	 public static int targetSum(int[] varArr,int target) {
		 int sum=0;
		 for(int n:varArr) sum+=n;
		 if (sum < target || (sum + target) % 2 == 1) {
		        return 0;
		    }
		 target=(sum+target)/2;
		 //创建dparr 多出来的一维 存储base case情况
		 int[][] dpArr=new int[varArr.length+1][target+1];
//		 for (int i = 0; i < dpArr[0].length; i++) {dpArr[0][i]=0;}
		 //初始化 求价值为0，求组合为1
//		 for (int i = 0; i < dpArr.length; i++) {dpArr[i][0]=1;}
		 dpArr[0][0]=1;
		 //遍历所有状态
		 for (int i = 1; i <=varArr.length; i++) {
			for (int j = 0; j <= target; j++) {
				//判断背包是否有容量
				if (j-varArr[i-1]<0) {
					dpArr[i][j]=dpArr[i-1][j];
				}else {
					//遍历所有选择
					dpArr[i][j]=dpArr[i-1][j]+dpArr[i-1][j-varArr[i-1]];
				}				
			}
		}
		 return dpArr[varArr.length][target];
	}   

	 public static void main(String[] args) {
		 int[] varArr=new int[] {1,1,1,1,1};
		 System.out.printf("一共有%d种组合",targetSum(varArr, 3));
	
}
}


/*
 * TargetSum_ 采用动态规划的思路去求解
 */


