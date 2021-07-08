package dynanucProgramming;

import java.util.Arrays;

public class TargetSumNew {
	/*
	 *  目标和问题
	 */
	public static int targetSum(int[] nums,int target) {
		int sum=0;
		for(int num:nums) sum+=num; 
		target=(sum+target)>>1;
		if (target<0||target%2!=0) return 0;
		System.out.println(target);
		int[][]dp=new int[nums.length+1][target+1];

		dp[0][0]=1;
//		Arrays.fill(dp[0], 1,target+1,0);
		
		for (int i=1;i<=nums.length;i++) {
			for (int j = 0; j <=target; j++) {
				if (nums[i-1]>j) {
					dp[i][j]=dp[i-1][j];					
				}else {
					dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
				}
			}
		}
		return dp[nums.length][target];
	}
	
	
	public static int target(int[] nums,int target) {
		int sum=0;
		int n=nums.length;
		for(int num:nums) sum+=num; 
		target=(sum+target)>>1;
		if (target<0||target%2!=0) return 0;
		System.out.println(target);
		int[] dp=new int[target+1];
		//initial dp
		dp[0]=1;
		for (int num:nums) {
			for (int j = target; j >=0; j--) {
				if (j<num) {
					dp[j]=dp[j];
				}else {
					dp[j]=dp[j]+dp[j-num];
				}
			}
		}		
		return dp[target];
		
	}
	 public static void main(String[] args) {
		 int[] varArr=new int[] {1,1,1,1,1};
		 System.out.printf("一共有%d种组合",target(varArr, 3));
	
}
}
