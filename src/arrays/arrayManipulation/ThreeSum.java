package arrays.arrayManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    List<Integer> sortTriplet(int a, int b, int c){
        List<Integer> triplet = new ArrayList<>();
        if(a<=b && a<=c){
            triplet.add(a);
            if(b<c){
                triplet.add(b);
                triplet.add(c);
            }else{
                triplet.add(c);
                triplet.add(b);
            }
        }else if(b<=c && b<=a){
            triplet.add(b);
            if(a<c){
                triplet.add(a);
                triplet.add(c);
            }else{
                triplet.add(c);
                triplet.add(a);
            }
        }else{
            triplet.add(c);
            if(a<b){
                triplet.add(a);
                triplet.add(b);
            }else{
                triplet.add(b);
                triplet.add(a);
            }
        }
        return triplet;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<String> stringHashSet = new HashSet<>();
        for(int i=0; i<=nums.length-3; i++){
            int remSum = sum - nums[i];
            HashSet<Integer> hSet = new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                if(hSet.contains(nums[j])){
                    List<Integer> sortedTriplet = sortTriplet(nums[i], remSum - nums[j], nums[j]);
                    StringBuilder stringBuilder =new StringBuilder();
                    for(Integer a : sortedTriplet){
                        stringBuilder.append(String.valueOf(a));
                    }
                    if(!stringHashSet.contains(stringBuilder.toString())){
                        triplets.add(sortedTriplet);
                        //hSet.remove(nums[j]);
                        stringHashSet.add(stringBuilder.toString());
                    }
                }else{
                    hSet.add(remSum - nums[j]);
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args){
        ThreeSum obj = new ThreeSum();
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println(obj.threeSum(arr));


        arr = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(obj.threeSum(arr));

        arr = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(obj.threeSum(arr));


    }

}
