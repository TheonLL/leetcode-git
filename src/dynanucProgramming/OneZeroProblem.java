package dynanucProgramming;

public class OneZeroProblem {
	/*
	 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
	请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
	如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
	 */
	public static int maxSubSetSize(String[] strs,int m,int n) {
		//create dp2
		int[][] dp=new int[m+1][n+1];
		//initial dp
		dp[0][0]=0;
		// for each state
		
		for(String str:strs) {
			int count_1=0;
			int count_0=0;
			for (int i=0;i<str.length();++i) {
				if ('1'==str.charAt(i)) {
					count_1++;
				}else {
					count_0++;
				}			
			}

			for (int i = m; i >=count_0; --i) {
				for (int j = n; j >=count_1; --j) {
					dp[i][j]=Math.max(dp[i][j], dp[i-count_0][j-count_1]+1);
				}
			}	
		}
		return dp[m][n];

	}
	
	public static void main(String[] args) {
		String[] strsStrings=new String[] {"10", "0001", "111001", "1", "0"};
		System.out.println(maxSubSetSize(strsStrings,5,3));
}
}