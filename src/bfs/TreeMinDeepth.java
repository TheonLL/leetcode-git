package bfs;
import java.util.LinkedList;
import java.util.Queue;

import bfs.BinaryTree;
public class TreeMinDeepth {
	
	public static int minDeepth(BinaryTree root) {
		if (root==null) {return 0;}
		//create queue store Node
		Queue<BinaryTree> queue=new LinkedList<BinaryTree>();
		// create step to record result
		int step=1;
		//initial queue
		queue.offer(root);
		//iterate all queue
		while (queue.size()!=0) {
			int size=queue.size();
			for (int i=0;i<size;++i) {
			BinaryTree currenBinaryTree=queue.poll();
			if (currenBinaryTree.right==null&&currenBinaryTree.left==null) {return step;}
			if (currenBinaryTree.right!=null) {
				queue.offer(currenBinaryTree.right);
			}
			if (currenBinaryTree.left!=null) {
				queue.offer(currenBinaryTree.left);
			}		
			step++;
			}
		}
		return step;
	}
	
	
	
	public static void main(String[] args) {
		Integer[] nodeList=new Integer[] {3,9,20,null,null,15,7};
		Integer[] nodeList1=new Integer[] {1,2,2,3,3,null,null,4,4};
		BinaryTree tree=BinaryTree.createTree(nodeList, 0);
		System.out.println(minDeepth(tree));
	}

}
