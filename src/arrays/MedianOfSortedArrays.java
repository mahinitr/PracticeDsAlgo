package arrays;

public class MedianOfSortedArrays {

    private double median(int[] arr){
        int len = arr.length;
        if(len % 2 == 0){
            return (arr[len/2 - 1] + arr[len/2]) / 2.0;
        }else{
            return arr[(len+1)/2 - 1];
        }
    }



    public static void main(String[] args){
        MedianOfSortedArrays obj = new MedianOfSortedArrays();

        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(obj.median(arr));
    }

}
