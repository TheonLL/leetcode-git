package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;



public class huawei01 {
public static void main(String[] args) throws Exception{
	System.out.println("00000");
	System.out.println(1111111);
	solutionHuaWei01 solutionHuaWei01=new solutionHuaWei01();
	System.out.println(222222222);
	System.out.println(solutionHuaWei01.findMax());
}
}


class solutionHuaWei01{
	public int findMax() throws Exception{
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String string=bufferedReader.readLine();
		String[] strArr=string.split(" ");
		//initial return 
		int maxNum=Integer.parseInt(strArr[0]);
		int setNum=Integer.parseInt(strArr[1]);
		if (setNum==0) {
			return 0;
		}else if (setNum==1) {
			return 1;
		} else {
			//创建二维数组存放
			int[][] timeSetArr=new int[setNum][2];
			
			// 循环读取接下来的输入
			for(int i=0;i<setNum;++i) {
				String string2=bufferedReader.readLine();
				String[] strArr2=string2.split(" ");
				int startTime=Integer.parseInt(strArr2[0]);
				int endTime=startTime+5*(Integer.parseInt(strArr2[2])-Integer.parseInt(strArr2[1]));
				timeSetArr[i][0]=startTime;
				timeSetArr[i][1]=endTime;						
			}
			System.out.println("完成输入！！");
			System.out.println(Arrays.deepToString(timeSetArr));
			// 对区间进行排序 按照从开始时间从小到大排序 按第一列进行排序
			Arrays.sort(timeSetArr,(o1,o2)->Integer.compare(o1[0], o2[0]));
			System.out.println(Arrays.deepToString(timeSetArr));
			int maxCarNum=1;
			int maxCarNUm2=1;
			for (int i=0;i<timeSetArr.length-1;++i) {
				if (timeSetArr[i][1]>timeSetArr[i+1][0]) {
					maxCarNum++;
					timeSetArr[i+1][1]=Math.min(timeSetArr[i][1], timeSetArr[i+1][1]);
				}else {
					maxCarNUm2=Math.max(maxCarNum, maxCarNUm2);
					maxCarNum=1;
					continue;
				}
			}
			return maxCarNUm2;
		}
		
	}
	
}