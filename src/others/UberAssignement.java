package others;
import java.util.*;

public class UberAssignement {

    /*
    Move from 1 elem to last elem, by moving right upto k steps
   and the current element the score so far.
   Fint the maximum poossible score to reach last elem.
     */
    static long arrayJourney(int[] path, int k) {
        if(path.length == 0){
            return Integer.MIN_VALUE;
        }
        int[] scores = new int[path.length];
        Arrays.fill(scores, Integer.MIN_VALUE);
        scores[0] = path[0];
        for(int i=0; i < path.length;i++){
            for(int j=i+1; j<=i+k; j++){
                if(j>path.length-1){
                    break;
                }
                scores[j] = Math.max(scores[j], scores[i] + path[j]);
            }
        }
        return scores[path.length - 1];
    }


    static class Pair{
        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        public String toString(){
            return String.valueOf(i) + "," + String.valueOf(j);
        }

    }

    static class PairComparator implements Comparator<Pair>{
        public int compare(Pair p, Pair q){
            return p.i - q.i;
        }
    }
    static int smallestSetCoveringIntervals(int[] first, int[] last) {
        int m = first.length;
        PriorityQueue<Pair> pairs = new PriorityQueue<>(5,new PairComparator());
        for(int i=0; i<m; i++){
            Pair pair = new Pair(first[i],last[i]);
            pairs.add(pair);
        }

        int res = 0;
        if(pairs.size() == 0){
            return res;
        }
        if(pairs.size() == 1){
            Pair curr = pairs.poll();
            if(curr.j-curr.i>0){
                res = 1;
            }
            return res;
        }
        Pair prev = null;
        int toBeSelected = 2;
        for(int i=1; i<m; i++){
            Pair curr = pairs.poll();
            System.out.println(curr);
            if(prev == null){
                prev = curr;
                toBeSelected = 2;
                continue;
            }
            if(prev.j < curr.i){
                if(toBeSelected == 0){

                }
                res = res + toBeSelected;
                toBeSelected = 0;
                if(prev.j + 1 > curr.j){
                    prev = null;
                    toBeSelected = 2;
                }else{
                    prev = new Pair(prev.j + 1, curr.j);
                    toBeSelected = 0;
                }
            }else if(prev.j == curr.i){
                if(toBeSelected == 0){
                    prev = curr;
                    toBeSelected = 2;
                }else{
                    res = res + toBeSelected;
                    toBeSelected = 2 - toBeSelected;
                    prev = new Pair(prev.j+1, curr.j);
                }
            }else{
                res = res + 2;
                prev = curr;
                toBeSelected = 2;
            }
        }
        return res;
    }



    public static void main(String[] args){
        System.out.println(arrayJourney(new int[]{10, 2, -10, 5, 20}, 2));
        System.out.println(arrayJourney(new int[]{10}, 2));
        System.out.println(arrayJourney(new int[]{10, -2}, 2));
        System.out.println(arrayJourney(new int[]{}, 2));
        System.out.println(arrayJourney(new int[]{3, -4, -3, -5, 0}, 2));
        System.out.println(arrayJourney(new int[]{100, -70, -90, -80, 100}, 3));


        int a[] = new int[]{3,2,0,4};
        int b[] = new int[]{6,4,2,7};
        System.out.println(smallestSetCoveringIntervals(a,b));
    }



}
