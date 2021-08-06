package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class zhanglei01 {
	public static void main(String[] args) throws IOException {
		//获得输入
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] arry = line.split(" ");
//        System.out.println(Arrays.toString(arry));
        int W=Integer.parseInt(arry[0]);
        int L=Integer.parseInt(arry[1]);
        int[][] hightArr=new int[W][L];
        for (int i = 0; i < W; i++) { 
//        	BufferedReader  br1 = new BufferedReader(new InputStreamReader(System.in));
    		String line1 = br.readLine();
        	String[] arry1 = line1.split(" ");
//        	System.out.println("0000");
//        	System.out.println(Arrays.toString(arry1));
        	for (int j = 0; j < L; j++) {
        		hightArr[i][j]=Integer.parseInt(arry1[j]);
			}
        	
		}
        //输入完成，二维高度矩阵为 hightArr'
        //动态规划思路
        //创建二维dp
//        System.out.println(Arrays.deepToString(hightArr));
        if (W==1) {
			int sum=0;
			for (int i = 0; i < W; i++) {
				if (hightArr[0][i]==0) {
					sum=sum;
				}else {
					sum+=hightArr[0][i];
				}
				
			}
//			System.out.println(sum);
		}else if (L==1) {
			int sum1=0;
			for (int i = 0; i < L; i++) {
				if (hightArr[i][0]==0) {
					sum1=sum1;
				}else {
					sum1+=hightArr[i][0];
				}
				
			}
		}else {
	        int[][] dp=new int[W][L];
	        dp[0][0]=hightArr[0][0];
	        
	        for (int i = 1; i < L; i++) {
	        	if (hightArr[0][i]==0) {
	        		dp[0][i]=dp[0][i-1];
				}else {
					if (hightArr[0][i-1]==0) {
						dp[0][i]=hightArr[0][i];
					}else {
						dp[0][i]=dp[0][i-1]+hightArr[0][i];	
					}
					
//					System.out.println(hightArr[0][i]);
				}
	        	
			}
//	        System.out.println(Arrays.toString(dp[0]));
	        for (int i = 1; i < W; i++) {
	        	if (hightArr[i][0]==0) {
	        		dp[i][0]=dp[i-1][0];
				}else {
					if (hightArr[i-1][0]==0) {
						dp[i][0]=hightArr[i][0];
					}else {
						dp[i][0]=dp[i-1][0]+hightArr[i][0];
					}
					
				}
	        	
			}
	        for (int i = 1; i < dp.length; i++) {	        	
				for (int j = 1; j < dp.length; j++) {
					if (hightArr[i][j]==0) {
						dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
					}else {
						if (hightArr[i][j-1]==0&&hightArr[i-1][j]==0) {
							dp[i][j]=hightArr[i][j];
						}else if (hightArr[i][j-1]*hightArr[i-1][j]!=0) {
//							if (dp[i][j-1]>dp[i-1][j]) {
//								dp[i][j]=dp[i][j-1]+hightArr[i-1][j]+hightArr[i][j];
//							}else {
//								dp[i][j]=hightArr[i][j-1]+dp[i-1][j]+hightArr[i][j];
//							}
							dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+hightArr[i][j];
							
						}else {
							if (hightArr[i][j-1]==0) {
								dp[i][j]=dp[i-1][j]+hightArr[i][j];
							}else {
								dp[i][j]=dp[i][j-1]+hightArr[i][j];
							}
							
						}
						
					}
					
				}
			}
//	        System.out.println(Arrays.deepToString(dp));
	        for (int i = 0; i < dp.length; i++) {
				System.out.println(Arrays.toString(dp[i]));
			}
	        
	        System.out.println(dp[W-1][L-1]);
		}

	}
}
