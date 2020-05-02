package graphs;

/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2


Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */


import javafx.util.Pair;

import java.util.*;


class WTNode{
    int v;
    int weight;
    WTNode(int v, int weight){
        this.v = v;
        this.weight = weight;
    }
}


class WeightedGraph{

    int N;
    Map<Integer, List<WTNode>> adjList;

    WeightedGraph(int N){
        this.N = N;
        adjList = new HashMap<>();
    }

    void addEdge(int u, int v, int w){
        List<WTNode> edgeList = adjList.get(u);
        if(edgeList == null){
            edgeList = new ArrayList<>();
            adjList.put(u, edgeList);
        }
        WTNode node = new WTNode(v, w);
        edgeList.add(node);
    }

    int getDelayWeightOfPath(int k){
        Map<Integer, Integer> reached = new HashMap<>();
        //reached.put(k, 0);
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(k, 0));
        int maxTime = 0;
        while(queue.size() > 0){
            Pair<Integer, Integer> currPair = queue.poll();
            Integer tt = reached.get(currPair.getKey());
            if(tt == null){
                tt = currPair.getValue();
            } else if(currPair.getValue() < tt){
                tt = currPair.getValue();
            }else{
                continue;
            }
            reached.put(currPair.getKey(), tt);
            List<WTNode> edgeList = adjList.get(currPair.getKey());
            if(edgeList != null) {
                for (WTNode node : edgeList) {
                    queue.add(new Pair<>(node.v, node.weight + tt));
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : reached.entrySet()){
            if(entry.getValue() > maxTime){
                maxTime = entry.getValue();
            }
        }
        if(reached.size() == N){
            return maxTime;
        }else{
            return -1;
        }
    }

}



public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        WeightedGraph graph = new WeightedGraph(N);
        for(int[] arr : times){
            graph.addEdge(arr[0], arr[1], arr[2]);
        }
        return graph.getDelayWeightOfPath(K);
    }

    public static void main(String args[]){
        NetworkDelayTime obj = new NetworkDelayTime();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(obj.networkDelayTime(times, 4, 2) == 2);

        times = new int[][]{{1,2,1},{1,4,1},{2,3,1},{3,4,1},{4,5,1}};
        System.out.println(obj.networkDelayTime(times, 5, 1) == 2);
        System.out.println(obj.networkDelayTime(times, 5, 2) == -1);

        times = new int[][]{{1,2,1},{1,4,4},{2,3,1},{3,4,1},{4,5,1}};
        System.out.println(obj.networkDelayTime(times, 5, 1) == 4);

        times = new int[][]{{1,2,1},{2,1,1}};
        System.out.println(obj.networkDelayTime(times, 2, 1) == 1);
    }

}
