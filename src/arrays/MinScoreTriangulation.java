package arrays;

import java.util.*;

class MinScoreTriangulation {

    int minScore(List<Integer> list){
        if(list.size() < 4){
            return list.get(0) * list.get(1) * list.get(2);
        }
        int n = list.size();
        int resSum = Integer.MAX_VALUE;
        int[][] table = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(table[i], -1);
        }
        for(int i=0; i<n; i++){
            for(int j=((i+2)%n); j!=((i+n-1)%n); j=((j+1)%n)){
                int currSum;
                System.out.println(i + ", " + j + ", " + (i+n-1)%n);
                if(table[j][i] != -1){
                    currSum = table[j][i];
                }else {
                    List<Integer> l1 = new ArrayList<>();
                    List<Integer> l2 = new ArrayList<>();
                    int a = i;
                    while (a != ((j + 1) % n)) {
                        l1.add(list.get(a));
                        a = (a + 1) % n;
                    }
                    a = j;
                    while (a != ((i + 1) % n)) {
                        l2.add(list.get(a));
                        a = (a + 1) % n;
                    }
                    currSum =  minScore(l1) + minScore(l2);
                    table[i][j] = currSum;
                }
                if(currSum < resSum){
                    resSum = currSum;
                }
            }
        }
        return resSum;
    }

    public int minScoreTriangulation(int[] A) {
        if(A.length < 3){
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<A.length; i++){
            list.add(A[i]);
        }
        return minScore(list);
    }

    public static void main(String[] args){
        MinScoreTriangulation obj = new MinScoreTriangulation();
        System.out.println(obj.minScoreTriangulation(new int[]{1,3,1,4,1,5}));

       /* System.out.println(obj.minScoreTriangulation(new int[]{1,2}));
        System.out.println(obj.minScoreTriangulation(new int[]{1,2,3}));
        System.out.println(obj.minScoreTriangulation(new int[]{3,7,4,5}));
        System.out.println(obj.minScoreTriangulation(new int[]{1,3,1,4,1,5}));
        System.out.println(obj.minScoreTriangulation(new int[]{6,3,8,5,3,9,1,7,5}));
        System.out.println(obj.minScoreTriangulation(new int[]{35,73,90,27,71,80,21,33,33,13,48,12,68,70,80,36,66,3,70,58}));
        */

    }

}