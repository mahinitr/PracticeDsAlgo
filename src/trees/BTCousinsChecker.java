package trees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.


                    1
                2        3
            4      5  6     7


            2, 3 are not cousins
            3, 4 are not cousins
            5, 7 are cousins
            6, 5 are not cousins


 */


class DummyNode{

}

public class BTCousinsChecker {

    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<Object> dq = new LinkedList<>();
        if(root == null){
            return false;
        }
        dq.add(root);
        dq.add(new DummyNode());
        int sum = x + y;
        Map<Integer, Integer> map = new HashMap<>();
        while(dq.size() != 0){
            Object curr = dq.poll();
            if(curr.getClass().getName() == DummyNode.class.getName()){
                sum = x + y;
                continue;
            }
            TreeNode currNode = (TreeNode)curr;
            if(currNode.val == x){
                sum = sum - currNode.val;
            } else if(currNode.val == y){
                sum = sum - currNode.val;
            }
            if(sum == 0){
                return map.get(x) != map.get(y);
            }
            if(currNode.left != null){
                dq.add(currNode.left);
                map.put(currNode.left.val, currNode.val);
            }
            if(currNode.right != null){
                dq.add(currNode.right);
                map.put(currNode.right.val, currNode.val);
            }
            Object temp = dq.peek();
            if(temp.getClass().getName() == DummyNode.class.getName()){
                dq.add(new DummyNode());
            }
        }
        return false;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BTCousinsChecker obj = new BTCousinsChecker();
        System.out.println(obj.isCousins(root,2,3) == false);
        System.out.println(obj.isCousins(root,3,4) == false);
        System.out.println(obj.isCousins(root,5,7) == true);
        System.out.println(obj.isCousins(root,6,7) == false);
    }

}


