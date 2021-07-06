package dynanucProgramming;

import java.security.spec.ECPrivateKeySpec;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
 * Targetsum 采用回溯法思路求解
 */
public class TargetSum {

	// creating a count to recording number of sumWay;
		static int count = 0;
		static int[] operationList=new int[] {1,2};
		static int k=0;		
	    public static int findTargetSumWaysEmun(int[] nums, int target) {
			if (nums.length==1&&target-nums[0]==0) {
				count++;
				return count;
			}else if (nums.length==1&&target+nums[0]==0) {
				count++;
				return count;
			}else {
	    		for(int num:nums) {
	    			if (nums.length==1) {
	    				return count;
					}else {
						int[] newNums=Arrays.copyOfRange(nums, 1, nums.length);	
			    		for (int i = 0; i < 2; i++) {
			    			if (i==0) {
									k=findTargetSumWaysEmun(newNums, target-num);							
							}else {
									k=findTargetSumWaysEmun(newNums, target+num);							
							}					
						}
					}		    		
		    	}
		    	return count;
			}	    	
	    }	    

    public static void main(String[] args) {

    	int[] nums=new int[] {1,1,1};
//    	System.out.println("请输入target值：");
//    	Scanner scanner=new Scanner(System.in);
//    	int target=scanner.nextInt();
    	int target=1;
    	int count=findTargetSumWaysEmun(nums, target);
    	System.out.printf("组合方式一共有%d种",count);
	

}
}


/*
 * TargetSum_ 采用动态规划的思路去求解
 */


