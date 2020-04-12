package arrays;

public class LongestIncreasingSubsequence {

    /*static int lengthOfLIS(int[] arr){
        int m = arr.length;
        if(m <= 1){
            return m;
        }
        int[][]table = new int[m][m];
        for(int k=m-2; k>=0; k--){
            for(int i=m-1; i>k; i--){
                if(i==m-1){
                    if(arr[k] < arr[i]){
                        table[k][i] = 2;
                    } else{
                        table[k][i] = 1;
                    }
                } else {
                    int len1 = table[k][i+1];
                    int len2 = table[i][i+1];
                    if(arr[k] < arr[i]){
                        len2 = len2 + 1;
                    }
                    table[k][i] = Math.max(len1, len2);
                }
            }
        }
        return table[0][1];
    }*/

    static int lengthOfLIS(int[] arr){
        int m = arr.length;
        int[] lis = new int[m];
        for(int i=0; i<m; i++){
            lis[i] = 1;
        }
        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && lis[j] + 1 > lis[i]){
                    lis[i] = lis[j] + 1;
                }
            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLIS(new int[]{10,5,30,15,35}) == 3);
        System.out.println(lengthOfLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}) == 6);
        System.out.println(lengthOfLIS(new int[]{1,2,3,4,5,6,7,8,9,10}) == 10);
        System.out.println(lengthOfLIS(new int[]{10,9,8,7,6,5,4,3,2,1}) == 1);
        System.out.println(lengthOfLIS(new int[]{10,5,20,6,30,7,40,8,9}) == 5);
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}) == 4);
        System.out.println(lengthOfLIS(new int[]{}) == 0);
        System.out.println(lengthOfLIS(new int[]{10}) == 1);
        System.out.println(lengthOfLIS(new int[]{10,10}) == 1);
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}) == 3);
    }

}
