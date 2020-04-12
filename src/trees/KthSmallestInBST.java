package trees;

import java.util.Stack;

public class KthSmallestInBST {

    static public int kthSmallest(TreeNode root, int k) {
        int c = 0;
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while(stack.size() != 0 || temp != null){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            TreeNode node = stack.pop();
            c++;
            if(c==k){
                return node.val;
            }
            temp = node.right;
        }
        return -1;
    }

    public static void main(String[] args){

    }

}
