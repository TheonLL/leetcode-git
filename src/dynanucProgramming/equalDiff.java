package dynanucProgramming;

import java.sql.PseudoColumnUsage;

public class equalDiff {
	
	
	public static boolean equalsSet(int [] varArr) {
		int sum=0;
		for(int n :varArr) sum+=n;
		int target=sum/2;
		if (target%2==1) {
			return false;
		}
		
		boolean[][] dpArr=new boolean[varArr.length][target+1];
		
		if (varArr[0]<=target) {
			dpArr[0][varArr[0]]=true;
			
		}
		for (int i = 1; i < dpArr.length; i++) {
			for (int j = 0; j <=target; j++) {
				
			}
		}

	}
	public static void main(String[] args) {
		int[] nums=new int[] {1,5,11,5};
		System.out.println(equalsSet(nums));
}
}