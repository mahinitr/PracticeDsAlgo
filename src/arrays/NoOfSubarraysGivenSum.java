package arrays;

import java.util.*;

public class NoOfSubarraysGivenSum {

    static int noOfSubarrays(int[] arr, int sum){
        int res = 0;
        Map<Integer,Integer> count = new HashMap<>();
        int currSum = 0;
        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            if(currSum == sum){
                res++;
            }
            if(count.containsKey(currSum - sum)){
                res = res + count.get(currSum - sum);
            }
            Integer c = count.get(currSum);
            if(c == null){
                count.put(currSum, 1);
            }else{
                count.put(currSum, c+1);
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(noOfSubarrays(new int[]{10,2,-2,-20,10}, -10));
    }

}
