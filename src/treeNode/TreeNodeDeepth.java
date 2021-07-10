package treeNode;

public class TreeNodeDeepth {
	
	/*
	 * 输入一棵二叉树的根节点，求该树的深度。
	 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
	 */
	public static int treeDeepth(TreeNode treeNode) {
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		Integer[] nodeList=new Integer[] {3,9,20,null,null,15,7};
		TreeNode treeNode=createTree(nodeList, 0);
		System.out.printf("二叉树的深度为:%d",treeDeepth(treeNode));
		System.out.println("over!!");		
	}
	
	
	
	
	
	

	private static TreeNode createTree(Integer []array,int index){
	    TreeNode treeNode = null;
	    if (index<array.length) {
	        Integer value = array[index];
	        if (value == null) {
	            return null;
	        }
	        /*主要操作！！！*/
	        /*采用递归方式，每次执行此方法，就会生成一个根节点和两个子节点a和b，
			同时子节点a再往下，创建属于a的子节点c和d，b也是同理。
			index为当前的下标。
			*/
	        treeNode = new TreeNode(value);
	        treeNode.left = createTree(array, 2*index+1);
	        treeNode.right = createTree(array, 2*index+2);
	        return treeNode;
	    }
	    return treeNode;
	}

}






class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}