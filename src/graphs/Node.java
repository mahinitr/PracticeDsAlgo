package graphs;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    static public void DFS(Node node){
        if(node == null){
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap();
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.pop();
            visited.put(curr.val, true);
            System.out.print(curr.val + "->");
            for(Node neighbor : curr.neighbors){
                System.out.print(neighbor.val + " ");
                if(visited.get(neighbor.val)==null){
                    visited.put(neighbor.val, true);
                    queue.add(neighbor);
                }
            }
        }
    }

}