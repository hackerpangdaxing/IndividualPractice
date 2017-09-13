package suanfa;
import java.util.Stack;
/**
 * Created by 胖大星 on 2017/9/6.
 */
public class BianliOfBinarryTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    /**
     * 方法一：大话数据结构中简便方法，可实现操作。
     * @param
     */

    public void preOrder(TreeNode node){
        if(node==null) return;
        System.out.print(node.val+"  ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.val+"  ");
        inOrder(node.right);
    }
    public void postOrder(TreeNode node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+"  ");
    }
    /**
     * 方法二：剑指offer中的方法：加入栈操作
     * @param
     */
    public void preOrder2(TreeNode node){
        Stack<TreeNode> stack=new Stack<TreeNode>();

        while(node!=null || !stack.empty()){
            //先遍历左子树
            while(node!=null){
                System.out.print(node.val+"  ");
                stack.push(node);
                node=node.left;//左子树遍历结束后，node==null,跳出此循环
            }
            //左子树遍历结束，继续遍历右子树
            if(!stack.isEmpty()){
                node=stack.pop();//一直返回，直到根节点处，node==null，即stack==isEmpty()
                node=node.right;
            }
        }
    }
    public void inOrder2(TreeNode node){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(node!=null || !stack.isEmpty()){

            while(node!=null){
                stack.push(node);//8 6  5
                node=node.left;    //6  5  null
            }

            if(!stack.isEmpty()){
                node=stack.pop();//5  6
                System.out.print(node.val+"  ");//5  6
                node=node.right;//null
            }
        }
    }
    //后序遍历暂时还不会
    /*public void postOrder2(TreeNode node){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(node!=null ||  !stack.isEmpty()){
            while(node!=null){
                stack.push(node);//8 6 5  7
                node=node.left;//6 5 null null
            }
            if(!stack.isEmpty()){
                node=stack.pop();//5 6     7
                node=node.right;//null 7  null

            }

        }
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        BianliOfBinarryTree bianli=new BianliOfBinarryTree();
        bianli.preOrder(root);
        System.out.println("《《前序遍历-------");
        bianli.inOrder(root);
        System.out.println("《《中序遍历-------");
        bianli.postOrder(root);
        System.out.println("《《后序遍历-------");
       /* bianli.preOrder2(root);
        System.out.println("方法二：《《前序遍历-------");
        bianli.inOrder2(root);
        System.out.println("方法二：《《中序遍历-------");
        // bianli.postOrder2(root);
        System.out.println("方法二：《《后序遍历-------");*/
    }
}
