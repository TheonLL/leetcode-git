package AlgorithmTemplate;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author: 11983
 * @date: 21/08/30 9:33
 * @description:
 */

public class Template {
    public static void main(String[] args) {
        String[] sArr=new String[]{"cat","cats","and","sand","dog"};
        ArrayList<String> arrayList= (ArrayList<String>) Arrays.asList(sArr);

    }
    //回溯思想-深度优先
    private  void  Dfs(TreeNode1 root){
        if (root==null){
            return;
        }
        Dfs(TreeNode1.left);
        Dfs(TreeNode1.right);


    }
    // 回溯思想-广度优先
    private  void  Bfs(TreeNode1 root){
        Queue<TreeNode1> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode1 node=queue.poll();
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);

            }
        }
    }

    // 递归
    int parameter1;
    public void  recursion(int parameter){
        if(parameter>100){
            return;
        }
        recursion(parameter1);
    }


}
class TreeNode1{
    public static TreeNode1 right;
    public static TreeNode1 left;


}