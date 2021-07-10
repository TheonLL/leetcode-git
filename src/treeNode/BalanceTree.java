package treeNode;
import java.sql.PseudoColumnUsage;

import treeNode.BinaryTree;

public class BalanceTree {
	/*
	 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
	 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
	 */

	public static boolean ifBalanceTree(BinaryTree tree) {
		
		return deepth(tree)==-1?false:true;
	}
	public static int deepth(BinaryTree tree) {
		// detect binaryTree if null
		if (tree==null) return 0;
		
		int left=deepth(tree.left);
		if(left==-1) return -1;
		int right=deepth(tree.right);
		if(right==-1) return -1;
		return Math.abs(right-left)<2?Math.max(right, left)+1:-1;
		
		
	}
	public static void main(String[] args) {
		Integer[] nodeList=new Integer[] {3,9,20,null,null,15,7};
		Integer[] nodeList1=new Integer[] {1,2,2,3,3,null,null,4,4};
		BinaryTree tree=BinaryTree.createTree(nodeList1, 0);
		System.out.println(ifBalanceTree(tree));
	}
}
