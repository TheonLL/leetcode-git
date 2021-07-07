package dynanucProgramming;

import java.util.Iterator;

public class PackageProblem {
	
	
	/*
	 * 经典0-1背包问题
	 */
	public static int packageProblem(int n,int W ,int[] weightArr,int[] rewardArr) {
		//根据状态的大小来创建dp数组的大小并初始化
		int[][] dpArr= new int[n+1][W+1];
//		for (int i = 0; i < dpArr[0].length; i++) {dpArr[0][i]=0;}
//		for (int i = 0; i < dpArr.length; i++) {dpArr[i][0]=0;}
		dpArr[0][0]=0;
		//遍历所有状态值
		for (int i = 1; i <=n; ++i) {
			for(int j=1;j<=W;++j) {
				//判断包里是否可以装下
				if (j-weightArr[i-1]<0) {
					dpArr[i][j]=dpArr[i-1][j];
				}else {
					//遍历所有选择并择优
					dpArr[i][j]=Math.max(dpArr[i-1][j], dpArr[i-1][j-weightArr[i-1]]+rewardArr[i-1]);
				}
				
			}
		}
		return dpArr[n][W];
	}
}
