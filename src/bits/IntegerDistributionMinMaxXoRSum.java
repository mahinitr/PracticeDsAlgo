package bits;

/*
Minimum XOR sum and Maximim XOR sum,
Distribute N integers into N/2 integers, each pair's XOR is added.

N
N integers in N lines
 N=4, {1,2,3,4}
 output: 6 10

 */

import java.util.Scanner;

public class IntegerDistributionMinMaxXoRSum {

    static void minMaxXorSum(int[] arr){
        int sum = (arr[0] ^ arr[1]) + (arr[2] ^ arr[3]);
        System.out.println(sum);
        sum = (arr[0] ^ arr[2]) + (arr[1] ^ arr[3]);
        System.out.println(sum);
        sum = (arr[0] ^ arr[3]) + (arr[1] ^ arr[2]);
        System.out.println(sum);
    }

    public static void main(String[] args){
        /*Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }*/
        int[] arr = new int[]{1,2,3,4};
        minMaxXorSum(arr);
    }

}
