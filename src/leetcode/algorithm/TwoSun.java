package leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class TwoSun {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
//		int score2=60;
//		int i;
//		double  bfb =  (float)(score2-score1)/score1*100; 
//		double  bfb1 = (double)(score2-score1)/score1*100; 
//		System.out.println(bfb);
//		System.out.println(bfb1);
//		System.out.println((float)(score2-score1)/score1*100);
//		        String[] names = {"ABC", "XYZ", "zoo"};
//		        String[] s = names;
//		        names[1] = "cat";
//		        System.out.println(s[1]); // s是"XYZ"还是"cat"?

		}
	}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] resultList=new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums.length;++j){
                if (nums[i]+nums[j]==target)
                    resultList[0]=j;                  
                
            }
        }
        return resultList;
    }
}



