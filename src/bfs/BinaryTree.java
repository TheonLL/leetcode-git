package bfs;

public class BinaryTree {
	   int val;
	   BinaryTree left;
	   BinaryTree right;
	   BinaryTree(int x) { val = x; }
	   
	   public static BinaryTree createTree(Integer []array,int index){
		   BinaryTree treeNode = null;
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
		        treeNode = new BinaryTree(value);
		        treeNode.left = createTree(array, 2*index+1);
		        treeNode.right = createTree(array, 2*index+2);
		        return treeNode;
		    }
		    return treeNode;
		}
}

