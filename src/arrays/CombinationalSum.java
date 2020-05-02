package arrays;

import java.util.*;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

public class CombinationalSum {


    List<List<Integer>> findCandidates(int[] candidates, int start, int target){
        //System.out.println(start + " - " + target);
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0 || start == candidates.length){
            return res;
        }
        if(target < candidates[start]){
            return res;
        }
        if(candidates[start] == target){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[start]);
            res.add(list);
            return res;
        }
        List<List<Integer>> leftRes = findCandidates(candidates, start + 1, target);
        List<List<Integer>> rightRes = findCandidates(candidates, start, target - candidates[start]);
        for(List<Integer> list : rightRes){
            list.add(0, candidates[start]);
        }
        res.addAll(rightRes);
        res.addAll(leftRes);
        return res;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Map<Integer, List<List<Integer>>>> table = new ArrayList<>();
        for(int i=0; i<candidates.length; i++){
            table.add(new HashMap<>());
        }
        Arrays.sort(candidates);
        return findCandidates(candidates, 0, target);
    }

    public static void main(String[] args){
        CombinationalSum obj = new CombinationalSum();
        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 8));
        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(obj.combinationSum(new int[]{2,3,6,8}, 8));
    }

}
