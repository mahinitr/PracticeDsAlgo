package graphs;

public class CycliGraphDisjointSetFindUnionByRank {

    static class Edge{
        int src;
        int dest;
    }

    static class Subset{
        int parent;
        int rank;

        Subset(int parent, int rank){
            this.parent = parent;
            this.rank = rank;
        }
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

        Subset find(int i, Subset[] subsets){
            if(subsets[i].parent != i){
                subsets[i] = find(subsets[i].parent, subsets);
            }
            return subsets[i];
        }

        void union(Subset xSet, Subset ySet){
            if(xSet.rank < ySet.rank){
                xSet.parent = ySet.parent;
            }else if(ySet.rank < xSet.rank){
                ySet.parent = xSet.parent;
            }else{
                xSet.parent = ySet.parent;
                ySet.rank++;
            }
        }

        boolean isCyclic(){
            Subset[] subsets = new Subset[v];

            for(int i=0; i<v; i++){
                subsets[i] = new Subset(i, 0);
            }

            for(int i=0; i<e; i++){
                Edge edge = edges[i];
                Subset xSubset = find(edge.src, subsets);
                Subset ySubset = find(edge.dest, subsets);
                if(xSubset.parent == ySubset.parent){
                    return true;
                }
                union(xSubset, ySubset);
            }
            return false;
        }

    }

    public static void main(String args[]){
        Graph graph = new Graph(6,6);
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
        graph.edges[5].src = 4;
        graph.edges[5].src = 5;

        if(graph.isCyclic()){
            System.out.println("Graph has Cycle");
        }else{
            System.out.println("Graph doesn't have Cycle");
        }


    }
}
