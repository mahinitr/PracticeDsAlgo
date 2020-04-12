package graphs;

import java.util.LinkedList;
import java.util.Iterator;

public class Graph {

    int v;
    LinkedList<Integer> adjList[];

    Graph(int v){
        this.v = v;
        adjList = new LinkedList[v];
        for(int i=0; i<v; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v){
        adjList[u].add(v);
    }

    void BFS(int s){
        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            int n = (Integer)queue.poll();
            System.out.print(n + " ");
            Iterator itr = adjList[n].listIterator();
            while(itr.hasNext()){
                int m = (Integer)itr.next();
                if(!visited[m]){
                    visited[m] = true;
                    queue.add(m);
                }
            }
        }
    }

    void DFSUtil(int v, boolean visited[]){
        visited[v] = true;
        System.out.print(v + " ");
        Iterator itr = adjList[v].listIterator();
        while(itr.hasNext()){
            int n = (Integer)itr.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    // works for disonnected graph as well...
    void DFS(){
        boolean visited[] = new boolean[v];
        for(int i=0; i<v; i++) {
            if(!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    boolean findPath(int p, int q){
        boolean exists = false;

        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(p);
        visited[p] = true;
        while(queue.size()!=0){
            int n = queue.poll();
            if(n==q){
                exists = true;
                break;
            }
            Iterator<Integer> itr = adjList[n].listIterator();
            while(itr.hasNext()){
                int m = itr.next();
                if(!visited[m]){
                    visited[m] = true;
                    queue.add(m);
                }
            }
        }

        return exists;
    }

    public static void main(String[] args){
        Graph g = new Graph(7);
        g.addEdge(0,3);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,2);
//        g.addEdge(4,0);

        g.addEdge(5,6);

        g.BFS(0);
        System.out.println();
        g.DFS();
        System.out.println();

        System.out.println("Path exists " + g.findPath(1,0));
        System.out.println("Path exists " + g.findPath(1,4));
        System.out.println("Path exists " + g.findPath(3,4));
        System.out.println("Path exists " + g.findPath(2,0));
        System.out.println("Path exists " + g.findPath(3,1));
        //System.out.println("Path exists " + g.findPath(0,0));

    }


}
