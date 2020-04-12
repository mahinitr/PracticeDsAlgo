package trees;

import java.util.LinkedList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SerializeDeserializeTree {

    private int heightOfTree(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        StringBuilder ans = new StringBuilder();
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        int h = heightOfTree(root);
        int c = 0;
        while(!q1.isEmpty() || !q2.isEmpty()){
            while(!q1.isEmpty()){
                TreeNode node = q1.poll();
                String s = (node != null) ? String.valueOf(node.val) : "null";
                ans.append(s + ",");
                if(c < h){
                    if(node != null){
                        q2.add(node.left);
                        q2.add(node.right);
                    }else{
                        q2.add(null);
                        q2.add(null);
                    }
                }
            }
            c++;
            while(!q2.isEmpty()){
                TreeNode node = q2.poll();
                String s = (node != null) ? String.valueOf(node.val) : "null";
                ans.append(s + ",");
                if(c < h){
                    if(node != null){
                        q1.add(node.left);
                        q1.add(node.right);
                    }else{
                        q1.add(null);
                        q1.add(null);
                    }
                }
            }
            c++;
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(nodes.length == 0) {
            return null;
        }
        TreeNode root = null;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        if(!"null".equals(nodes[0])){
            root = new TreeNode(Integer.parseInt(nodes[0]));
            q1.add(root);
        } else{
            return null;
        }
        int c=1;
        while(!q1.isEmpty() && c < nodes.length){
            TreeNode node = q1.poll();
            TreeNode left = null, right = null;
            if(c < nodes.length && !"null".equals(nodes[c])){
                left = new TreeNode(Integer.parseInt(nodes[c]));
            }
            c++;
            if(c < nodes.length && !"null".equals(nodes[c])){
                right = new TreeNode(Integer.parseInt(nodes[c]));
            }
            c++;
            if(node!= null){
                node.left = left;
                node.right = right;
            }
            q1.add(left);
            q1.add(right);
        }
        return root;
    }


    public static void main(String[] args){
        TreeNode root;
        SerializeDeserializeTree obj = new SerializeDeserializeTree();
        String serializedStr;

        serializedStr = obj.serialize(null);
        System.out.println(serializedStr);
        root = obj.deserialize(serializedStr);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);

        root = new TreeNode(1);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);
        root = obj.deserialize(serializedStr);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);
        root = obj.deserialize(serializedStr);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);
        root = obj.deserialize(serializedStr);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);
        root = obj.deserialize(serializedStr);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);
        root = obj.deserialize(serializedStr);
        serializedStr = obj.serialize(root);
        System.out.println(serializedStr);
    }
}




// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
