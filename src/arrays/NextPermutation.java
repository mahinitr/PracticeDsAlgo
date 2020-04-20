package arrays;

public class NextPermutation {

    void insertAtRightPlace(int j, int[] nums){
        int a = nums[j];
        int k=j+1;
        for(;k<nums.length; k++){
            if(nums[k]<=a){
                break;
            }
        }
        nums[j] = nums[k-1];
        nums[k-1] = a;
    }

    void reverseArr(int[] nums, int l, int h){
        while(l<h){
            int t = nums[l];
            nums[l] = nums[h];
            nums[h] = t;
            l++;
            h--;
        }
    }

    public void nextPermutation(int[] nums) {
        for(int j=nums.length-2; j>=0; j--){
            if(nums[j]<nums[j+1]){
                insertAtRightPlace(j, nums);
                reverseArr(nums, j+1, nums.length-1);
                return;
            }
        }
        reverseArr(nums, 0, nums.length-1);
    }

    public static void main(String[] args){
        NextPermutation obj = new NextPermutation();
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,9,4,8,5,3,2};
        int[] arr3 = new int[]{5,4,3,2,1};
        int[] arr4 = new int[]{1,9,4,8,6,5,3,2};
        int[] arr5 = new int[]{1,9,7,8,6,5,3,2};
        int[] arr6 = new int[]{1,3,2};
        obj.nextPermutation(arr1);
        obj.nextPermutation(arr2);
        obj.nextPermutation(arr3);
        obj.nextPermutation(arr4);
        obj.nextPermutation(arr5);
        obj.nextPermutation(arr6);
        for(int i=0; i<arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i=0; i<arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        for(int i=0; i<arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        for(int i=0; i<arr4.length; i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        for(int i=0; i<arr5.length; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();
        for(int i=0; i<arr6.length; i++) {
            System.out.print(arr6[i] + " ");
        }
    }

}
