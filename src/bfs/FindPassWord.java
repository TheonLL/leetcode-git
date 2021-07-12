package bfs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindPassWord {
	public static void main(String[] args) {
		String[] deadends=new String[] {"0201","0101","0102","1212","2002"};
		solution s=new solution();
		System.out.println(s.findPassWordMin(deadends, "0202"));
}
}

class solution{
	/*
	 * 752. 打开转盘锁
	 */
	public int findPassWordMin(String[] deadends,String target) {
		Queue<String> queue=new LinkedList<>();
		Set<String> visitedSet=new HashSet<>();
		Set<String> deadSet=new HashSet<>();
		for(String str:deadends) deadSet.add(str);
		
		
		queue.offer("0000");
		visitedSet.add("0000");
		int step=0;
		while (queue.size()!=0) {
			int size=queue.size();
			for(int i=0;i<size;++i) {
				String currenString=queue.poll();
				if(currenString.equals(target)) return step;
				if(deadSet.contains(currenString)) continue;
				for(int j=0;j<4;++j) {
					String str1=addone(currenString, j);
					if (!visitedSet.contains(str1)) {
						queue.offer(str1);
						visitedSet.add(str1);
					}
					String str2=decone(currenString, j);
					if (!visitedSet.contains(str2)) {
						queue.offer(str2);	
						visitedSet.add(str2);
					}									
				}
			}
			step++;
		}
		return -1;
	}	
	private String addone(String str,int index) {
		char[]  chararr=str.toCharArray();
		if (chararr[index]=='9') {
			chararr[index]='0';
		}else {
			chararr[index]+=1;
		}
		return new String(chararr);	
	}
	private String decone(String str,int index) {
		char[]  chararr=str.toCharArray();
		if (chararr[index]=='0') {
			chararr[index]='9';
		}else {
			chararr[index]-=1;
		}
		return new String(chararr);	
	}
}	
	
