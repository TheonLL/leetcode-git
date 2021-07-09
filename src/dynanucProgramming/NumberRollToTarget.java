package dynanucProgramming;

import java.util.Arrays;

public class NumberRollToTarget {
	/*
	 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面
	分别标号为 1, 2, ..., f。
	我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
	如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况.
	 */
	public static int numberToTarget(int k,int maxpoint,int target) {
		int mod=(int) (Math.pow(10, 9)+7);
		//create dp
		int[] dp=new int[target+1];
		//initial dp
		Arrays.fill(dp, 0);
		dp[0]=1;
		//先循环所有组  共k个组
		for (int i = 1; i <=k; i++) {
			//为了保证从每个组中只拿一个筛子，先循环总和，在循环每个num
			//每个筛子最小值为1，所以和的所有值中 最小值为筛子个数 
			for (int j = target; j >=i; --j) {
				// 初始化 筛子/物品的重量是0时 有多少种组合
				dp[j]=0;
				//当筛子(物品)< 小于背包值 -既要小于总背包容量，也要小于单个组的背包容量				
				for (int a = 1; a <=Math.min(maxpoint, j); a++) {
					dp[j]=(dp[j]+dp[j-a])%mod;
				}
			}
		}
		return dp[target];
	}
	public static void main(String[] args) {
		System.out.println(numberToTarget(2,6,7));
	}

}
