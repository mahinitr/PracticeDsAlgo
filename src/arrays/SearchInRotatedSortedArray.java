package arrays;

public class SearchInRotatedSortedArray {

    int binarySearch(int[] nums, int target, int l, int r){
        if(r<l){
            return -1;
        }
        int m = (l+r)/2;
        if(nums[m] == target){
            return m;
        }
        if(nums[l] <= nums[m]){
            if(nums[l] <= target && target < nums[m]){
                return binarySearch(nums, target, l, m-1);
            }else{
                return binarySearch(nums, target, m+1, r);
            }
        }else{
            if(nums[m] < target && target <= nums[r]){
                return binarySearch(nums, target, m+1, r);
            }else{
                return binarySearch(nums, target, l, m-1);
            }
        }
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public static void main(String args[]){
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        int[] arr1 = new int[]{4,5,6,7,0,1,2};
        System.out.println(obj.search(arr1, 0));
        System.out.println(obj.search(arr1, 8));
        System.out.println(obj.search(arr1, 5));

        arr1 = new int[]{5,1,3};
        System.out.println(obj.search(arr1, 5));
    }

}
