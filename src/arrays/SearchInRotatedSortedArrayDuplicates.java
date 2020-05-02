package arrays;



public class SearchInRotatedSortedArrayDuplicates {

    public static void main(String[] args){
        SearchInRotatedSortedArrayDuplicates obj = new SearchInRotatedSortedArrayDuplicates();
        System.out.println(obj.search(new int[]{1,1,1,2,2,2,2,2,2,5,0,0,1}, 6)==false);
        System.out.println(obj.search(new int[]{0,0,1,1,1,1,2,2,2,2,2,2,5}, 0)==true);
        System.out.println(obj.search(new int[]{4,4,5,0,0,2,2,2,2,4,4,4,4}, 3)==false);
        System.out.println(obj.search(new int[]{2,2,2,2,4,4,4,4,4,4,5,0,0}, 3)==false);
        System.out.println(obj.search(new int[]{2,2,2,2,4,4,4,4,4,4,5,0,0}, 0)==true);
        System.out.println(obj.search(new int[]{2,2,2,2,4,4,4,4,4,4,5,0,0}, 3)==false);
        System.out.println(obj.search(new int[]{2,2,2,2,4,4,4,4,4,4,5,0,0}, 2)==true);
        System.out.println(obj.search(new int[]{1,1,1,1,2,2,2,2,2,2,5,0,0}, 1)==true);
        System.out.println(obj.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1}, 3)==false);
        System.out.println(obj.search(new int[]{1,1,3,1,1,1,1,1,1,1,1,1,1}, 3)==true);
        System.out.println(obj.search(new int[]{1,1,1,1,1,1,1,1,1,3,1,1,1}, 3)==true);
    }

    boolean binarySearch(int[] nums, int n, int l, int h){
        if(l > h){
            return false;
        }
        int m= (l+h)/2;
        if(nums[m] == n){
            return true;
        }
        if(nums[l] < nums[m]){
            if(nums[l] <= n && n < nums[m]){
                return binarySearch(nums, n, l, m-1);
            }else{
                return binarySearch(nums, n, m+1, h);
            }
        }else if(nums[m] < nums[h]){
            if(nums[m] < n && n <= nums[h]){
                return binarySearch(nums, n, m+1, h);
            }else{
                return binarySearch(nums, n, l, m-1);
            }
        }else{
            if(binarySearch(nums, n, l, m-1)){
                return true;
            }else{
                return binarySearch(nums, n, m+1, h);
            }
        }
    }

    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    /*
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(nums[m] == target){
                return true;
            }
            if(nums[l] <= nums[m]){
                if(nums[l] <= target && target <= nums[m]){
                    h = m-1;
                }else{
                    l = m+1;
                }
            }else{
                if(nums[m] <= target && target <= nums[h]){
                    l = m+1;
                }else{
                    h = m-1;
                }
            }
        }
        return false;
    }
    */

}