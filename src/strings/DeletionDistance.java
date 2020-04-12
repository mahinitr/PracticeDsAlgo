package strings;


import java.io.*;
import java.util.*;

class DeletionDistance {

    static int deletionDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int table[][] = new int[m+1][n+1];
        for(int i=m; i>=0; i--){
            for(int j=n; j>=0; j--){
                if(i==m || j==n){
                    table[i][j] = Math.max(m-i, n-j);
                } else if(str1.charAt(i) == str2.charAt(j)){
                    table[i][j] = table[i+1][j+1];
                } else {
                    table[i][j] = 1 + Math.min(table[i+1][j], table[i][j+1]);
                }
            }
        }
        return table[0][0];
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.get(0);
        System.out.println(deletionDistance("abc","gcb") == 4);
        System.out.println(deletionDistance("abcd","gcbd") == 4);
        System.out.println(deletionDistance("heat","hit") == 3);
        System.out.println(deletionDistance("some","some") == 0);
        System.out.println(deletionDistance("some","thing") == 9);
    }

}
