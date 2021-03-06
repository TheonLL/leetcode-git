package dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DoneJobLimit {
	public static void main(String[] args) {
		int[] jobtime=new int[] {1,2,4,7,8};
		DoneJobLimitSolution doneJobLimit=new DoneJobLimitSolution();
		System.out.println(doneJobLimit.disspathjob(jobtime,2,11));
	}

}
class DoneJobLimitSolution{
	/*
	 * 将n个任务分给k个人，每个人的最多工作时长不超过limit，任务i的工时为数组jobtime[i],是否可行
	 */

	public boolean disspathjob(int[] jobtime,int k,int limit) {
		Arrays.sort(jobtime);
		int[] group=new int[k];
		Deque<Integer> jobDeque=new ArrayDeque<Integer>();
		for (int job : jobtime) {
			jobDeque.add(job);
		}

		if (backTrack(group, jobDeque, limit)) {
			return true;
			
		}else {
			return false;
		}

	}
	private boolean backTrack(int[] group,Deque<Integer> jobtime,int limit) {
		if (jobtime.size()==0) {
			return true;
		}
		int currInt=jobtime.poll();
		for (int i = 0; i < group.length; i++) {
			if (group[i]+currInt<=limit) {
				group[i]+=currInt;
				
				if (backTrack(group, jobtime, limit)) {
					return true;
				}
				group[i]-=currInt;
				if (group[i]==0) {
					break;
				}
			}
		}
		jobtime.addLast(currInt);
		
		return false;
	}
}