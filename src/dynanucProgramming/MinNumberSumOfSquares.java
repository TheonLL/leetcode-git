package dynanucProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumberSumOfSquares {
	public static int minNumber(int amount) {
		List<Integer> numsIntegers=new ArrayList<>();
		for (int i = 0; i < Math.sqrt(amount)+1; i++) {
			int temp=i*i;
			if (temp<=amount) {
				numsIntegers.add(temp);
			}else {
				break;
			}			
		}
		//create dp
		int[] dp=new int[amount+1];
		//initial dp
		Arrays.fill(dp, 10000);
		dp[0]=0;
		//for each state
		for(int num:numsIntegers) {
			for (int i = num; i<=amount; ++i) {
				dp[i]=Math.min(dp[i], dp[i-num]+1);
			}
		}
		return dp[amount];

	}
	public static void main(String[] args) {
		System.out.println(minNumber(12));
	}

}
