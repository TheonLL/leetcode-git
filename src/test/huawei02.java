package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.PriorityQueue;


public class huawei02 {
	public static void main(String[] args)throws Exception {
		solutionHuaWei solutionHuaWei=new solutionHuaWei();
		System.out.println(solutionHuaWei.minTime());
		
	}

}

class solutionHuaWei{
	public int minTime()throws Exception {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String string=bufferedReader.readLine();
		String[] stringArrStrings=string.split(" ");
		int allMachineNum=Integer.parseInt(stringArrStrings[0]);
		int needCheckMachineNum=Integer.parseInt(stringArrStrings[1]);
		int[][] checkMachineArrayList=new int[needCheckMachineNum][2];
		for (int i = 0; i < needCheckMachineNum; i++) {

			String needTime=bufferedReader.readLine();
			String[] stringArrStrings2=needTime.split(" ");
			checkMachineArrayList[i][0]=Integer.parseInt(stringArrStrings2[0]);
			checkMachineArrayList[i][1]=Integer.parseInt(stringArrStrings2[1]);
		}
		//当测试仪器数量大于或等于需要测试设备数量
		if(allMachineNum>=needCheckMachineNum) {
			int[] tempArrayList=new int[needCheckMachineNum];
			int j=0;
			for (int i=0;i<needCheckMachineNum;++i) {
				tempArrayList[j]=checkMachineArrayList[i][0];
				j++;
			}
			return Arrays.stream(tempArrayList).max().getAsInt();
		//当测试仪器数量小于需要测试设备数量
		}else {
			Arrays.sort(checkMachineArrayList,(o1,o2)->Integer.compare(o1[0], o2[0]));
			Arrays.sort(checkMachineArrayList,(o1,o2)->Integer.compare(o1[1], o2[1]));
			// 创建最小堆 优先列队
			PriorityQueue< Integer> minHea=new PriorityQueue<>(allMachineNum,(a,b)->a-b);
			for (int i = 0; i < allMachineNum; i++) {
				minHea.add(checkMachineArrayList[i][0]);
			}
			for (int i = allMachineNum; i < needCheckMachineNum; i++) {
				minHea.add(minHea.poll()+checkMachineArrayList[i][0]);
			}			
			return minHea.peek();	 
		}
		
	}
	
}