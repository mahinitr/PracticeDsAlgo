package strings;

public class LongestCommonSubsequence {

    static int lengthOfLCS(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] table = new int[m+1][n+1];
        for(int i=m; i>=0; i--){
            for(int j=n; j>=0; j--){
                if(i==m || j==n){
                    table[i][j] = 0;
                } else if(s1.charAt(i) == s2.charAt(j)){
                    table[i][j] = 1 + table[i+1][j+1];
                }else{
                    table[i][j] = Math.max(table[i+1][j], table[i][j+1]);
                }
            }
        }
        return table[0][0];
    }

    public static void main(String[] ars){

        System.out.println(lengthOfLCS("ABC", "DAC") == 2);
        System.out.println(lengthOfLCS("ABCBDAB", "BDCABA") == 4);
        System.out.println(lengthOfLCS("ABCBDAB", "BDCABA") == 4);
        System.out.println(lengthOfLCS("A", "B") == 0);
        System.out.println(lengthOfLCS("", "") == 0);
        System.out.println(lengthOfLCS("BAB", "ABA") == 2);
        System.out.println(lengthOfLCS("ABCDGH", "AEDFHR") == 3);
        System.out.println(lengthOfLCS("AGGTAB", "GXTXAYB") == 4);
        System.out.println(lengthOfLCS("BACDB", "BDCB") == 3);



    }

}
