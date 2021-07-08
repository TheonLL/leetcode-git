package dynanucProgramming;

public class OrderDifferece {
	
	
	/*
	 * 将数组中的订单分给A、B两家厂商，让两家分的产品数量之差最小，该如何分配
	 * in:{10,20,30,40,50}
	 * out:10
	 */
	public static int oderDiff(int[] orderL) {
		//transform to 0-1 package problem
		int sum=0;
		for(int order:orderL) sum+=order;
		int target=sum>>1;
//		System.out.println(target);
		int[]dp=new int[target+1];
		
//		for (int o:orderL) dp[o]=o; 
		dp[0]=0;
		for (int i=0;i<=target;++i) {
			if (i<orderL[0]) {
				dp[i]=0;
			}else {
				dp[i]=orderL[0];
			}
		}
		for(int num:orderL) {
			for (int i = target; i >=0; --i) {
				if (num>i) {
					dp[i]=dp[i];
				}else {
					dp[i]=Math.max(dp[i], dp[i-num]+num);
				}
			}
		}
//		System.out.println(dp[target]);
		return Math.abs(dp[target]*2-sum);
	}
	public static void main(String[] args) {
		int[] orderList=new int[] {10,20,30,40,50};
		System.out.println(oderDiff(orderList));
}
}
