package arrays;


// package whatever; // don't place package name!

/*
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
import java.io.*;

class MinPathInMatrix {

    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        //System.out.println("code here");
        int[][] res = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int temp = 0;
                if(i<=0 && j<=0){
                    temp = 0;
                } else if(i<=0){
                    temp = res[i][j-1];
                } else if(j<=0){
                    temp = res[i-1][j];
                } else{
                    temp = Math.min(res[i][j-1], res[i-1][j]);
                }
                res[i][j] = grid[i][j] + temp;
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }

    public static void main (String[] args) {
        int[][] grid = new int[][]{
                { 1, 3, 9 },
                { 1, 5, 7 },
                { 4, 2, 1 }
        };

        MinPathInMatrix code = new MinPathInMatrix();
        int result = code.minPathSum(grid);
        System.out.println(result);

        grid = new int[][]{
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        };
        System.out.println(code.minPathSum(grid));
    }
}



