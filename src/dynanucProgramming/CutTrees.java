package dynanucProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CutTrees {
	public static void main(String[] args) {
		int[] cuts=new int[] {5,6,1,4,2};
		SolutionCutTrees solutionCutTrees=new SolutionCutTrees();
		System.out.println(solutionCutTrees.cutCost(9, cuts));
		}

}


class SolutionCutTrees{
	static int allCost=0;
	static List<Integer> costList=new ArrayList<>();
 	public int cutCost(int TreeLength,int[] cuts) {
		List<Integer> nowTreeLength=new ArrayList<>();
		nowTreeLength.add(0);
		nowTreeLength.add(TreeLength);
		backTrack(nowTreeLength, cuts,0);
		System.out.println("==================");
		Collections.sort(costList);
		System.out.println(costList.toString());
		
		return costList.get(costList.size()-1);				
	}
	private void backTrack(List<Integer> nowTreeLength,int[] nowCuts,int index) {
			//回溯结束条件
			for (int i = index; i <nowCuts.length; ++i) {

					System.out.println("indes");
					System.out.println(i);
					System.out.println(nowCuts[i]) ;
					//选择切入点
					int nowLength=findLen(nowTreeLength, nowCuts[i]);
					
					allCost+=nowLength;
					System.out.println(allCost);
					nowTreeLength.add(nowCuts[i]);
					if (i+1==nowCuts.length) {
						System.out.println("-----------------");
						System.out.println(allCost);
						costList.add(allCost);
						return;
					}
					backTrack(nowTreeLength, nowCuts, i+1);
					nowTreeLength.remove(nowTreeLength.size()-1);
					allCost-=nowLength;
				}

						
	}
	
	private int findLen(List<Integer> nowTreeLength,int cut) {
		int left=0;
		int right=0;
		Collections.sort(nowTreeLength);
		System.out.println(nowTreeLength.toString());
		
		for (Integer integer : nowTreeLength) {
			if (integer<cut) {
				left=integer;
			}else {
				right=integer;
				break;
			}
		}
		System.out.println("cheng");
		System.out.println(right-left);
		return right-left;
	}
}