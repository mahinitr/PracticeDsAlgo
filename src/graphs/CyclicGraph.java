package graphs;
import java.util.List;
import java.util.ArrayList;

public class CyclicGraph {

    boolean isCyclicDFS(int course,
                        List<Integer>[] adjList,
                        boolean[] visited,
                        boolean[] recStack){
        if(recStack[course]){
            return true;
        }
        if(visited[course]){
            return false;
        }
        visited[course] = true;
        recStack[course] = true;
        for(int i=0; i<adjList[course].size(); i++){
            if(isCyclicDFS(adjList[course].get(i), adjList, visited, recStack)){
                return true;
            }
        }
        recStack[course] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        List<Integer>[] adjList = new List[numCourses];
        for(int i=0; i<numCourses; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            int s = prerequisites[i][0];
            int e = prerequisites[i][1];
            adjList[s].add(e);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        // dop DFS and check if there is a cycle in graph.
        for(int i=0; i<numCourses; i++){
            if(isCyclicDFS(i, adjList, visited, recStack)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        CyclicGraph obj = new CyclicGraph();
        int[][] prerequisites = new int[][]{{0,1},{0,3},{1,2},{1,3},{1,4},{2,4},{3,2},{4,3}};
        System.out.println(obj.canFinish(5, prerequisites));
    }

}
