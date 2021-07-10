package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.NumberUpSupported;

public class SubSets {
	/* 
	 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
		解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
	 */
	public static List<List<Integer>> resultList=new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3};
//		List<Integer> nullList=new ArrayList<>();
//		resultList.add(nullList);
		List<Integer> subsetList=new ArrayList<>();
		backtrack(subsetList, 0, nums);
		for (List<Integer> list:resultList) {
			System.out.println(list.toString());
		}
		
	}
	public static void backtrack(List<Integer> subsetList,int startIdex,int[] nums) {


		resultList.add(new ArrayList<>(subsetList));

		for(int i=startIdex;i<nums.length;++i) {
			System.out.println(i);
			
			subsetList.add(nums[i]);
			backtrack(subsetList, i+1, nums);
			subsetList.remove(subsetList.size()-1);
		}

	}
	

}
