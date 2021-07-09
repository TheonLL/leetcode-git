package dynanucProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinCombinationSum_s {
	/*
	 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
	 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
	题目数据保证答案符合 32 位整数范围。请注意，顺序不同的序列被视作不同的组合
	 */
	public static int minCombination(int[] nums,int target) {
		//create dp
		int[] dp=new int[target+1];
		//initial dp
		Arrays.fill(dp, 0);
		dp[0]=1;
		for (int i = 1; i <=target; i++) {
			for(int num:nums) {
				if(i>=num) dp[i]+=dp[i-num];
			}
		}
		return dp[target];
	}
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3};
		System.out.println(minCombination(nums, 4));
}
}
