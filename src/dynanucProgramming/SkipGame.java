package dynanucProgramming;

import java.awt.TexturePaint;

public class SkipGame {
	public static void main(String[] args) {
		SolutionSkipGame2 solutionSkipGame=new SolutionSkipGame2();
//		SolutionSkipGame solutionSkipGame=new SolutionSkipGame();
		// true
		int[] nums=new int[] {2,3,1,1,4};
		//false
//		int[] nums=new int[] {3,2,1,0,4};
		System.out.println(solutionSkipGame.toEnd(nums));
	}
}
class SolutionSkipGame{
	public boolean toEnd(int[] nums) {
		int len=nums.length;
		int sum=nums[0];
		if (len==1) {
			return true;			
		}else {
			//暴力
			for (int i = 1; i <sum; i++) {
				sum=Math.max(i+nums[i], sum);
				if (sum>=len-1) {
					return true;
				}
			}
			return false;			
		}
	}
}



class SolutionSkipGame2{
	public int toEnd(int[] nums) {
		 if (nums == null || nums.length == 0 || nums.length == 1) {
	            return 0;
	        }
	        //记录跳跃的次数
	        int count=0;
	        //当前的覆盖最大区域
	        int curDistance = 0;
	        //最大的覆盖区域
	        int maxDistance = 0;
	        for (int i = 0; i < nums.length; i++) {
	            //在可覆盖区域内更新最大的覆盖区域
	            maxDistance = Math.max(maxDistance,i+nums[i]);
	            //说明当前一步，再跳一步就到达了末尾
	            if (maxDistance>=nums.length-1){
	                count++;
	                break;
	            }
	            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
	            if (i==curDistance){
	                curDistance = maxDistance;
	                count++;
	            }
	        }
	        return count;
	}
}




