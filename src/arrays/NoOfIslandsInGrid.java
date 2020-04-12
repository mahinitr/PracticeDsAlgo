package arrays;

public class NoOfIslandsInGrid {

    static final int[] dirI = new int[]{0, -1, 0, 1};
    static final int[] dirJ = new int[]{-1, 0, 1, 0};
    static final int total_dirs = 4;

    static void DFS(char[][]grid, int i, int j, boolean[][] visited, int m, int n){
        for(int k=0; k < total_dirs; k++){
            int newI = i + dirI[k];
            int newJ = j + dirJ[k];
            if(0 <= newI && newI < m && 0 <= newJ && newJ < n && grid[newI][newJ] == '1' && !visited[newI][newJ]){
                visited[newI][newJ] = true;
                DFS(grid, newI, newJ, visited, m, n);
            }
        }
    }

    static public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        if(m == 0){
            return count;
        }
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    visited[i][j] = true;
                    count++;
                    DFS(grid, i, j, visited, m, n);
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(numIslands(new char[][]{{}}));
        System.out.println(numIslands(new char[][]{{'1','0'},{'0','1'}}));
        System.out.println(numIslands(new char[][]{{'1','0','1'},{'0','1','0'}}));
        System.out.println(numIslands(new char[][]{{'1','0','1','1'},{'1','1','0','1'}}));
    }

}