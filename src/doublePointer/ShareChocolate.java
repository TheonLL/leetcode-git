package doublePointer;

import java.util.Arrays;

public class ShareChocolate {
	public static void main(String[] args) {
		int[] sweetArr=new int[] {1,2,3,4,5,6,7,8,9};
		solution1 s=new solution1();
		System.out.println(s.minSweet(sweetArr, 5));
	
	}
}

class solution1{
	public int minSweet(int[] sweetArr,int k){
		//initial left and right pointer
		int left=Arrays.stream(sweetArr).min().getAsInt();
		int right=Arrays.stream(sweetArr).sum();
		//iterate
		while (left<=right) {
			int mid=(left+right)>>1;
			if (possible(sweetArr, mid, k)) {
				left=mid+1;
				
			}else {
				right=mid-1;
			}		
		}
		return right;
	}
	private boolean possible(int[] arr,int mid,int sub) {
		int sum=0;
		int subNum=0;
		for (int s:arr) {
			sum+=s;
			//考虑什么时候加1
			if (sum>=mid) {
				sum=0;
				subNum++;				
			}
			// 大于块数 限制是>   判断 看可以切成的块数 当块数已经大于要求可以提前输出，
			//不需要一直遍历结束
			if (subNum>sub) {
				return true;
			}			
		}		
		return false;
	}
}
