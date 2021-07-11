package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsUnUnique {
	
	public static List<List<Integer>> resultList=new ArrayList<List<Integer>>();
		public static void main(String[] args) {
		int[] nums=new int[] {1,2,2,3};
		Arrays.sort(nums);
		List<Integer> subsetList=new ArrayList<>();
		backtrack(subsetList, 0, nums);
		for (List<Integer> list:resultList) {
			System.out.println(list.toString());
		}
		
	}
	/*
	 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
	解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
	 */
	public static void backtrack(List<Integer> subsetList,int startIdex,int[] nums) {
		resultList.add(new ArrayList<>(subsetList));

		for(int i=startIdex;i<nums.length;++i) {

			if (i>startIdex&&nums[i]==nums[i-1]) {
				continue;
			}
			subsetList.add(nums[i]);
			backtrack(subsetList, i+1, nums);
			subsetList.remove(subsetList.size()-1);
		}

	}
	
}
