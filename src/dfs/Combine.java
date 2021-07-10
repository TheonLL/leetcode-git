package dfs;

import java.util.ArrayList;
import java.util.List;

public class Combine {
	/*
	 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
	 */
	public static List<List<Integer>> resutList=new ArrayList<List<Integer>>();
	public static void backTrack(int n,int k,List<Integer> sublist,int startIndex) {
		if (n<k) {
			return ;
		}else if (n==k) {
			
			return ;
		}else {
			if (sublist.size()==k) {
				resutList.add(new ArrayList<>(sublist));			
			}else {
				for (int i = startIndex; i <=n; ++i) {
					sublist.add(i);
					backTrack(n, k, sublist, i+1);
					sublist.remove(sublist.size()-1);
				}
			}
			
		} 


	}
	public static void main(String[] args) {
		List<Integer> subList=new ArrayList<>();
		backTrack(4, 2, subList,1);
		for (List<Integer> list:resutList) {
			System.out.println(list.toString());		
		}
	}
}
