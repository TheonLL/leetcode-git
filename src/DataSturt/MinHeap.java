package DataSturt;

import java.util.PriorityQueue;

public class MinHeap {
	public static void main(String[] args) {
		// 用优先列队设置最小堆
		int len=9;
		PriorityQueue<Integer> minHeap=new PriorityQueue<>(len,(a,b)->a-b);
		//填充最小堆
		for (int i = 0; i < args.length; i++) {
			minHeap.add(3);
			//弹出最小的
			minHeap.poll();
			//取最小的值
			minHeap.peek();
		}
		// 用优先列队设置最大堆
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>(len,(a,b)->b-a);
		
	}

}
