package arrays;

public class FirstLastLocationOfTarget {

    int getIdx(int[] nums, boolean left, int target){
        if(nums.length == 0){
            return -1;
        }
        int l = 0;
        int h = nums.length-1;
        while(l<h-1){
            int m = (l+h)/2;
            if(left){
                if(target <= nums[m]){
                    h=m;
                }else{
                    l=m+1;
                }
            }else{
                if(nums[m] <= target){
                    l=m;
                }else{
                    h=m-1;
                }
            }
        }
        if(nums[l] == target && nums[h] == target){
            return (left) ? l : h;
        }else if(nums[l] == target){
            return l;
        }else if(nums[h] == target){
            return h;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        res[0] = getIdx(nums, true, target);

        res[1] = getIdx(nums, false, target);
        return res;
    }

    public static void main(String[] args){
        FirstLastLocationOfTarget obj = new FirstLastLocationOfTarget();

        int[] nums = new int[]{1,2,3,4,4,4,4,5,6,7};
        int target = 4;
        int[] res = obj.searchRange(nums, target);
        System.out.println(res[0] + ", " + res[1]);

        nums = new int[]{1,2,3,4,5,6,6,6,7};
        target = 6;
        res = obj.searchRange(nums, target);
        System.out.println(res[0] + ", " + res[1]);

        nums = new int[]{1,2,3,4,5,6,6,6,7};
        target = 8;
        res = obj.searchRange(nums, target);
        System.out.println(res[0] + ", " + res[1]);

    }

}
