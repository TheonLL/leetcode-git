package doublePointer;

import java.util.Arrays;

public class MinLoadPower {
	public static void main(String[] args) {
//		int[] weights=new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] weights=new int[] {1,2,4,7,8};
		minloadP minload=new minloadP();
		System.out.println(minload.minLoad(weights, 2));
		System.out.println(minload.minLoad(weights, 3));
	}

}

class minloadP{
	
	public int minLoad(int[] weights,int day) {
		//initial pointer
		int left=Arrays.stream(weights).max().getAsInt();
		int right=Arrays.stream(weights).sum();
		//iterate all state
		while (left<=right) {
			int mid=(left+right)>>1;
			if (possibale(weights, day, mid)) {
				right=mid-1;
				
			} else {
			left=mid+1;

			}
		}
		return left;
		
	}
	public boolean possibale(int[] weights,int day,int loadPower) {
		int sum=0;
		int useDay=1;
		for (int i : weights) {
			
			//考虑什么时候加1
			if (sum+i>loadPower) {
				sum=0;
				useDay+=1;							
			}
			sum+=i;		
		}
		// 不能超过天数 限制是<= 装完所有之后 观察 所需天数
		if (useDay<=day) {
			return true;				
		}	
		return false;		
	}
	
}