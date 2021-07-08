package dynanucProgramming;

public class PakageProblemNew {
	public static int pakageP(int n,int weight,int[] weightList,int[] valueList) {
//		//base case
//		int[][] dp=new int[n+1][weight+1];
//		//initial dp
//		dp[0][0]=0;
//		
//		//for state ...
//		for (int i=1;i<=n;++i) {
//			int num=weightList[i-1];
//			for(int j=0;j<=weight;++j) {
//				if (num>j) {
//					dp[i][j]=dp[i-1][j];					
//				}else {
//					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-num]+valueList[i-1]);
//				}
//			}
//		}
//		return dp[n][weight];
		int[] dp=new int[weight+1];
		//initial dp
		dp[0]=0;
		// for state ...
		for(int i=1;i<=n;++i) {
			int num=weightList[i-1];
			for (int j=weight;j>=0;j--) {
				if (j<num) {
					dp[j]=dp[j];
				}else {
					dp[j]=Math.max(dp[j], dp[j-num]+valueList[i-1]);
				}
			}
		}
		return dp[weight];
	}
	public static void main(String[] args) {
		int[] weigthList=new int[] {2,1,3};
		int[] valueList= new int[]{4,2,3};
		System.out.println(pakageP(3,4,weigthList,valueList));
		
	}
}
