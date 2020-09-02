package trees;

import java.util.LinkedList;
import java.util.Queue;


public class LeftViewPrinter {


    void printLeftView(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Node dummy = new Node(-1);
        q.add(dummy);
        q.add(root);
        boolean print = false;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data == -1){
                print = true;
                continue;
            }
            if(print){
                System.out.println(curr.data);
                print = false;
            }

            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
            Node nextNode = q.peek();
            if(nextNode != null){
                if(nextNode.data == -1){
                    q.add(dummy);
                }
            }
        }
    }

}
