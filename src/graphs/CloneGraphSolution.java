package graphs;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;


public class CloneGraphSolution {

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Node> newNodes = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.pop();
            visited.put(curr.val, true);
            Node newNode = newNodes.get(curr.val);
            if(newNode == null){
                newNode = new Node(curr.val);
                newNodes.put(curr.val, newNode);
            }
            for(Node oldNeighbor : curr.neighbors){
                Node newNeighbor = newNodes.get(oldNeighbor.val);
                if(newNeighbor == null){
                    newNeighbor = new Node(oldNeighbor.val);
                    newNodes.put(oldNeighbor.val, newNeighbor);
                }
                newNode.neighbors.add(newNeighbor);
                if(visited.get(oldNeighbor.val) == null){
                    visited.put(oldNeighbor.val, true);
                    queue.add(oldNeighbor);
                }
            }
        }
        return newNodes.get(node.val);
    }

    void test1(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node newNode = cloneGraph(node1);
        //System.out.println(newNode.val);
        Node.DFS(newNode);


    }

    void test2(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node3.neighbors.add(node5);
        node4.neighbors.add(node1);
        node4.neighbors.add(node5);
        node5.neighbors.add(node3);
        node5.neighbors.add(node4);

        Node newNode = cloneGraph(node1);
        //System.out.println(newNode.val);
        Node.DFS(newNode);

    }

    public static void main(String[] args){
        CloneGraphSolution cloner = new CloneGraphSolution();
        cloner.test1();
        System.out.println();
        cloner.test2();
    }

}
