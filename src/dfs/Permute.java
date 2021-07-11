package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
	public static List<List<Integer>> resultList=new ArrayList<List<Integer>>();
	
	
	
	/*
	 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
	 */
	public static void backTrack(int[] nums,List<Integer> subList) {
		if (subList.size()==nums.length) {
			resultList.add(new ArrayList<>(subList));	
		}
		for (int i = 0; i < nums.length; ++i) {
			if (subList.contains(nums[i])) {
				continue;
			}
			subList.add(nums[i]);
			backTrack(nums, subList);
			subList.remove(subList.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3};
		List<Integer> subList=new ArrayList<>();
		backTrack(nums, subList);
		for (List<Integer> list:resultList) {
			System.out.println(list.toString());
			
		}
		
	}
}
