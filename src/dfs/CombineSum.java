package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSum {
	/*
	给定一个无重复元素的数组 candidates 和一个目标数 target ，
	找出 candidates 中所有可以使数字和为 target 的组合。
	candidates 中的数字可以无限制重复被选取。
	 */
	public static List<List<Integer>> resultlist=new ArrayList<List<Integer>>();	
	
	//backtrack
	public static void backtrack(int[] nums,int target,List<Integer> subList,int maxdeepth,int startIndex) {
		int sum=0;
		for(int n:subList) sum+=n;
		if (sum==target) {
			resultlist.add(new ArrayList<>(subList));
		}
		for (int i = startIndex; i < nums.length; ++i) {
			if (maxdeepth==subList.size()) {
				continue;
			}
			subList.add(nums[i]);			
			backtrack(nums, target, subList,maxdeepth,i);
			subList.remove(subList.size()-1);
		}
	}
	public static List<List<Integer>> combineSum(int[] nums,int target) {
		Arrays.sort(nums);
		List<Integer> subList=new ArrayList<>();
		int maxdeepth=target/nums[0]+1;
		backtrack(nums,target,subList,maxdeepth,0);
		return resultlist;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {2,3,6,7};
		combineSum(nums, 7);
		for(List<Integer> list:resultlist) {
			System.out.println(list.toString());
		}
	}
}
