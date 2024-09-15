import java.util.*;

public class BinaryTree {
    static class TreeNode{
        TreeNode left,right;
        int data;

        TreeNode(int data){
            this.data=data;
            left=right=null;
        }

    }
    TreeNode root;

    public static void main(String[] args) {

        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        BinaryTree bt = new BinaryTree();

        bt.root = first;
        first.left=second;
        first.right=three;
        second.left=four;
        second.right=five;
        three.left=six;

        bt.preOrder(bt.root);
        bt.level(bt.root);
    }

    public void preOrder(TreeNode root){
        if(root==null)
            return;
        else{

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void level(TreeNode root){
        if(root==null)
            return;
        else {
            Queue q = new Queue();
            q.offer(root);
            q.dis();
            System.out.println(q.rear);
            System.out.println(q.front);
            while(q.length!=0){
                TreeNode temp = new TreeNode(q.dequeue());          //offer me right left nai ja raha
                System.out.println(temp.data + " ");
                if(temp.left!=null){
                    q.offer((temp.left));
                }
                if(temp.left!=null){
                    q.offer((temp.right));
                }

            }
        }
    }

}
