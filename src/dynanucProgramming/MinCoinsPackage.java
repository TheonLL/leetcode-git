package dynanucProgramming;

import java.util.Arrays;

public class MinCoinsPackage {
	public static int minCoinsPackage(int[] coinsList,int amount) {
		//create dp
		int[] dp=new int[amount+1];
		//initial dp
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		//for state
		for(int coin:coinsList) {
			for(int j=coin;j<=amount;++j) {
				dp[j]=Math.min(dp[j], dp[j-coin]+1);
			}
		}
		return dp[amount];
	}
	public static int numberCompCoinsPackage(int[] coinsList,int amount) {
		//create dp
		int[] dp=new int[amount+1];
		//initial dp
		Arrays.fill(dp, 0);
		dp[0]=1;
		//for state
		for(int coin:coinsList) {
			for(int j=coin;j<=amount;++j) {
				dp[j]=dp[j]+dp[j-coin];
			}
		}
		return dp[amount];
	}
	public static void main(String[] args) {
		int[] coinsList=new int[] {1, 2, 5};
		System.out.println(minCoinsPackage(coinsList, 11));
		System.out.println(numberCompCoinsPackage(coinsList, 5));
		
}
}
