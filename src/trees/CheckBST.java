package trees;


import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class CheckBST {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if(root == null){
            return root;
        }
        if(root.data > v1 && root.data > v2){
            return lca(root.left, v1, v2);
        }else if(root.data < v1 && root.data < v2){
            return lca(root.right, v1, v2);
        }else{
            return root;
        }
    }

    static boolean checkBSTUtil(Node root, List<Integer> prev){
        if(root == null){
            return true;
        }
        if(!checkBSTUtil(root.left, prev)){
            return false;
        }
        if(prev.size() == 0){
            prev.add(root.data);
        }else{
            if(prev.get(0) >= root.data){
                return false;
            }
            prev.remove(0);
            prev.add(0,root.data);
        }
        return checkBSTUtil(root.right, prev);
    }

    static boolean checkBST(Node root) {
        List<Integer> prev = new ArrayList<>();
        return checkBSTUtil(root, prev);
    }



    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    static void lowestCommonAnsestor(){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        System.out.println(checkBST(root));
    }
}