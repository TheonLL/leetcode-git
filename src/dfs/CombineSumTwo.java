package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSumTwo {
	/*
	给定一个数组 candidates 和一个目标数 target ，
	找出 candidates 中所有可以使数字和为 target 的组合。
	candidates 中的数字只能被选一次被选取。
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
			if (i>startIndex&&nums[i]==nums[i-1]) {
				continue;
			}
			subList.add(nums[i]);			
			backtrack(nums, target, subList,maxdeepth,i+1);
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
		int[] nums=new int[] {2,5,2,1,2};
		combineSum(nums, 5);
		for(List<Integer> list:resultlist) {
			System.out.println(list.toString());
		}
	}
}
