package trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class BinaryTreePaths {

    public List<String>  binaryTreePathsUtil(TreeNode root, String str){
        List<String> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        String path = String.valueOf(root.val);
        if(str != ""){
            path = str + "->" + path;
        }
        if(root.left == null && root.right == null){
            paths.add(path);
            return paths;
        }
        if(root.left != null){
            paths.addAll(binaryTreePathsUtil(root.left, path));
        }
        if(root.right != null){
            paths.addAll(binaryTreePathsUtil(root.right, path));
        }
        return paths;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePathsUtil(root, "");
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        BinaryTreePaths obj = new BinaryTreePaths();
        List<String> paths = obj.binaryTreePaths(root);
        for(String path : paths){
            System.out.println(path);
        }

    }

}
