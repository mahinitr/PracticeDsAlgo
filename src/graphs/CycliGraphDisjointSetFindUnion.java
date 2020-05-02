package graphs;

public class CycliGraphDisjointSetFindUnion {

    static class Edge{
        int src;
        int dest;
    }

    static class Graph{
        int v;
        int e;
        Edge[] edges;
        Graph(int v,int e){
            this.e = e;
            this.v = v;
            this.edges = new Edge[e];
            for(int i=0; i<e; i++){
                this.edges[i] = new Edge();
            }
        }

        int find(int i, int[]parent){
            if(parent[i] == -1){
                return i;
            }
            return find(parent[i], parent);
        }

        void union(int i, int j, int[] parent){
            int xSet = find(i, parent);
            int ySet = find(j, parent);
            parent[xSet] = ySet;
        }

        boolean isCyclic(){
            int[] parent = new int[v];

            for(int i=0; i<v; i++){
                parent[i] = -1;
            }

            for(int i=0; i<e; i++){
                Edge edge = edges[i];
                int xSet = find(edge.src, parent);
                int ySet = find(edge.dest, parent);
                if(xSet == ySet){
                    return true;
                }
                union(xSet, ySet, parent);
            }
            return false;
        }

    }

    public static void main(String args[]){
        Graph graph = new Graph(6,5);
        graph.edges[0].src = 0;
        graph.edges[0].src = 1;
        graph.edges[1].src = 0;
        graph.edges[1].src = 2;
        graph.edges[2].src = 1;
        graph.edges[2].src = 3;
        graph.edges[3].src = 3;
        graph.edges[3].src = 4;
        graph.edges[4].src = 3;
        graph.edges[4].src = 5;
        //graph.edges[5].src = 4;
        //graph.edges[5].src = 5;

        if(graph.isCyclic()){
            System.out.println("Graph has Cycle");
        }else{
            System.out.println("Graph doesn't have Cycle");
        }


    }
}
