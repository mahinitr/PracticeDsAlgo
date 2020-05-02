package arrays;

import java.util.ArrayList;
import java.util.List;

public class PossiblePermutations {


    List<List<Integer>> genPermutations(int[] nums, int i){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        if(i >= nums.length-1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            res.add(list);
            return res;
        }
        List<List<Integer>> tempRes = genPermutations(nums, i+1);
        for(List<Integer> list : tempRes){
            for(int j=0; j<=list.size();j++){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(j, nums[i]);
                res.add(newList);
            }
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        return genPermutations(nums, 0);
    }

    public static void main(String[] args){
        PossiblePermutations obj = new PossiblePermutations();
        System.out.println(obj.permute(new int[]{}));
        System.out.println(obj.permute(new int[]{1}));
        System.out.println(obj.permute(new int[]{1,2}));
        System.out.println(obj.permute(new int[]{1,2,3}));
        System.out.println(obj.permute(new int[]{1,2,3,4}));
        System.out.println(obj.permute(new int[]{1,2,3,4,5}));
    }

}
