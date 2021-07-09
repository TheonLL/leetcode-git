package dynanucProgramming;

import java.util.Arrays;

public class HouseRobber {
	/*
	 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
	影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
	如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	给定一个代表每个房屋存放金额的非负整数数组，
	计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
	 */
	public static int robber(int[] houselist) {
		//create dp
		int[] dp=new int[houselist.length+1];
		//initial dp
		dp[0]=0;
		// for each state
		dp[1]=houselist[0];
		for (int i = 2; i < dp.length; i++) {
			dp[i]=Math.max(dp[i-1], dp[i-2]+houselist[i-1]);	
		}
		return dp[houselist.length];
	}
	
	/*
	 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
	这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
	同时，相邻的房屋装有相互连通的防盗系统，
	如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
	给定一个代表每个房屋存放金额的非负整数数组，
	计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
	 */
	public static int robberCyle(int[] houseList) {
		if (houseList.length==1) return houseList[0];
		return Math.max(robber(Arrays.copyOfRange(houseList, 0,houseList.length-1)),robber(Arrays.copyOfRange(houseList, 1,houseList.length)));
	}
	public static void main(String[] args) {
		int[] houselist=new int[] {1,2,3,1};
		System.out.println(robber(houselist));

		int[] houselist1=new int[] {2,3,2};
		System.out.println(robberCyle(houselist1));

}
}
