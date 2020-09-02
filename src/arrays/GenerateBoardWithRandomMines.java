package arrays;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

> width = 8
> height = 4
> number_of_mines = 8
> generateBoard(width, height, numberOfMines)
*112*100
123*3222
01**31**
013*2122

 m*n cells, Mines

 scale - 1000*1000 = 1M cells



 indList : [1,2,3,4,5,6,7,8,9,10.... M*N] - size - (M*N)
 random - r is from 0 to M*N-1. indList[r]. r = 19
 indList : [1,2,3,4,5,6,7,8,9,10.... M*N] - size - (M*N)-1
 random - r is from 0 to M*N-2. indList[r]. r = 50

 2. 0 to M*N-1 (r)


*/

class GenerateBoardWithRandomMines {

    int[][] generateBoard(int m, int n, int mines){
        if(mines > m*n){
            return new int[0][0];
        }
        int[][] board = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(board[i], 0);
        }
        int c = 0;
        //System.out.println("initialised");
        Random random = new Random();
        while(c < mines){
            int cellNo = random.nextInt(m * n);
            //System.out.println(cellNo);
            int row = cellNo / n;
            int col = cellNo - (row * n);
            if(board[row][col] != -1){
                board[row][col] = -1;
                c++;
            }
        }
        //System.out.println("filled");
        int dirs = 8;
        int[] posI = new int[]{-1, -1,-1, 0, 0,  1, 1, 1};
        int[] posJ = new int[]{-1,  0, 1,-1, 1, -1, 0, 1};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int cnt = 0;
                if(board[i][j] == -1){
                    continue;
                }
                for(int k=0; k<dirs; k++){
                    int newI = i+posI[k];
                    int newJ = j+posJ[k];
                    if(0<=newI && newI<=m-1 && 0<=newJ && newJ<=n-1 && board[newI][newJ] == -1){
                        cnt++;
                    }
                }
                board[i][j] = cnt;
            }
        }
        System.out.println("done");

        return board;

    }


    public static void main(String[] args) {
        GenerateBoardWithRandomMines obj = new GenerateBoardWithRandomMines();
        int w = 5;
        int h = 0;
        int mines = 4;
        int[][] board = obj.generateBoard(h, w, mines);
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j] == -1){
                    System.out.print('*');
                }else{
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }



}

