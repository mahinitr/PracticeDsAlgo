package arrays;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

  /*
  *
  * [[X, X, X],
  *  [X, O, -],
  *  [O, X, O]]

  * [[X, X, o],
  *  [X, O, -],
  *  [O, X, O]]
  *
  * Find out who won, is it the X or the O or is it that no one won
  *

  [ X  X  O ]
  [ O  O  X ]
  [ O  O  X ]


  [[X]     ]
  [        ]
  [        ]


  N * N

  len(filled) = N


  ///List the unit test-cases

  1. checkInBoard vertically
  2. checkInBoard horizontally
  3. checkInDiagonal diagonally(true)
  4. checkInDiagonal diaogannly(false)
  5. getWinner(baord)


  //API design - URL shortening services

  //my.urlshort.com


  GET http://my.urlshort.com/short/url?url=<logn-url> : shortening service
  GET http://my.urlshort.com/<endoded-code> - : redirect service


  Shortening Service:


  @(short)
  class ShortengingApp{

    @resource("url/")
    void short(){

    }

  }



  class Shortner{

    String shortern(String url){
      return url;
    }

  }

  class URLModel{
    String longUrl;
    String shortURl;
    long time;
  }


  class DataLayer{

    void save(URLModel){

    }

    String getURL(shortUrl){

    }

  }


  clas RedirectApp{

     CacheLayer();

  }


  Redirect Service



  @("redirect")
  class Redirector{

    inject CacheLayer;

   @resource("url/")
    void redirect(){
      if(CacheLayer.get()){
      }
    }

  }


  class CacheLayer(){

    clientConn;

    String get(key){

    }

  }



  http://my.urlshort.com/<endoded-code>
  HTTP 302
  HTTP 4XX



  S - single
  O -
  L -
  I -
  D -

  Reactive programming
  atleast once, atmost once, idempotency in message streaming




  *
  */

class WinnerInBoard {

    char checkInBoard(char[][] board, int N, boolean vertical){
        char res = ' ';
        for(int i=0; i<N; i++){
            int noX = 0;
            int noO = 0;
            for(int j=0; j<N; j++){
                char ch;
                if(vertical){
                    ch = board[j][i];
                }else{
                    ch = board[i][j];
                }
                if(ch == 'X'){
                    noX++;
                }else if(ch == 'O'){
                    noO++;
                }
            }
            if(noX == N){
                res = 'X';
                break;
            }else if(noO == N){
                res = 'O';
                break;
            }
        }
        return res;
    }


    char checkInDiagonal(char[][] board, int N, boolean isTopLeft){
        char res = ' ';
        int noX = 0;
        int noO = 0;
        for(int i=0; i<N; i++){
            char ch;

            if(isTopLeft){
                ch = board[i][i];
            }else{
                ch = board[i][N-1-i];
            }
            if(ch == 'X'){
                noX++;
            }else if(ch == 'O'){
                noO++;
            }
        }

        if(noX == N){
            res = 'X';
        }else if(noO == N){
            res = 'O';
        }
        return res;
    }


    char getWinner(char[][] board){
        char res = ' ';
        int N = board.length;

        // horizontally
        res = checkInBoard(board, N, false);
        if(res != ' '){
            return res;
        }

        //vortically
        res = checkInBoard(board, N, true);
        if(res != ' '){
            return res;
        }

        //top-left-diagonal
        res = checkInDiagonal(board, N, true);
        if(res != ' '){
            return res;
        }

        //top-right-diagonal
        res = checkInDiagonal(board, N, false);

        return res;
    }



    public static void main(String[] args) {


        WinnerInBoard obj = new WinnerInBoard();
        char[][] board = new char[][]{
                {'X','X','O'},
                {'O','O','O'},
                {'X','O','O'}
        };

        char res = obj.getWinner(board);
        if(res == ' '){
            System.out.println("No one won.");
        }else{
            System.out.println(res + " won");
        }



        board = new char[][]{
                {'X','X','X'},
                {'O','X','O'},
                {'X','O','O'}
        };

        res = obj.getWinner(board);
        if(res == ' '){
            System.out.println("No one won.");
        }else{
            System.out.println(res + " won");
        }


        board = new char[][]{
                {'X','O','X','X'},
                {'O','O','X','-'},
                {'X','O','O','X'},
                {'X','X','O','X'}
        };


        res = obj.getWinner(board);
        if(res == ' '){
            System.out.println("No one won.");
        }else{
            System.out.println(res + " won");
        }


        board = new char[][]{
                {'X','X','O','X'},
                {'O','O','X','O'},
                {'X','X','O','X'},
                {'X','X','O','X'}
        };

        res = obj.getWinner(board);
        if(res == ' '){
            System.out.println("No one won.");
        }else{
            System.out.println(res + " won");
        }



    }
}
