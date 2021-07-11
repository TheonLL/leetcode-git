package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import javax.imageio.event.IIOReadWarningListener;

public class PermuteUnUnique {
	public static List<List<Integer>> resultList=new ArrayList<List<Integer>>();
	/*
	 * 给定一个含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
	 */
	public static void backTrack(int[] nums,Deque<Integer> subList,int startIndex,boolean[] used) {
		//判断是否满足解条件
		if (subList.size()==nums.length) {
			resultList.add(new ArrayList<>(subList));	
		}		
		for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {continue;}
			//判断是否要剪枝
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
			if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){continue;}
			subList.addLast(nums[i]);
			used[i]=true;
			backTrack(nums, subList, 0,used);
			// 回溯部分的代码，和 dfs 之前的代码是对称的
			used[i] = false;
			subList.removeLast();
		}
	}
	public static void main(String[] args) {
		int[] nums=new int[] {1,1,2};
		Arrays.sort(nums);
		Deque<Integer> subList=new ArrayDeque<>(nums.length);
		boolean[] used=new boolean[nums.length];
		backTrack(nums, subList, 0,used);
		for (List<Integer> list:resultList) {
			System.out.println(list.toString());			
		}		
	}
}
