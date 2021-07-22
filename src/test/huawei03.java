package test;

import java.util.Arrays;

public class huawei03 {
	public static void main(String[] args) {
		int[][] arr=new int[][] {{1,2,5},{1,3,5},{4,2,10},{2,5,5},{3,4,10},{3,7,10},{4,7,5},{5,6,5},{6,7,5}};
		solutionHuaWei03 solutionHuaWei03=new solutionHuaWei03();
		System.out.println(solutionHuaWei03.findMaxR(arr));
	}

}
class solutionHuaWei03{
	static int maxRout=0;
	public int findMaxR(int[][] arr) {
		int len=arr.length;
		if (len==0) {
			return 0;
		}else if (len==1) {
			return arr[0][2];
			
		}else {
			Arrays.sort(arr,(o1,o2)->Integer.compare(o1[1], o2[1]));
			Arrays.sort(arr,(o1,o2)->Integer.compare(o1[0], o2[0]));
			System.out.println(Arrays.deepToString(arr));
			
			return 0;
		}
	}
	private void backtrack(int[][] arr,int maxRout,int index) {
		
	}
}