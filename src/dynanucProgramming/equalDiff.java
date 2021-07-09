package dynanucProgramming;



public class equalDiff {
	
	
	public static boolean equalsSet(int [] varArr) {
		int sum=0;
		for(int n :varArr) sum+=n;
		
		int target=sum/2;
		System.out.println(target);
		
		//create  and initial dp
		boolean[] dp =new boolean[target+1];
		dp[0]=true;
		//for state..
		for(int num:varArr) {
			for (int j=target;j>=num;--j) {
//				if (num>j) {	
//					dp[j]=dp[j];					
//				}else {
					dp[j]=dp[j]||dp[j-num];
//				}
			}
		}
		return dp[target];
	}
	public static void main(String[] args) {
//		int[] nums=new int[] {1,5,11,5};
		int[] nums=new int[] {1,2,3,5};
		System.out.println(equalsSet(nums));
}
}