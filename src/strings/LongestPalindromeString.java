package strings;

import javafx.util.Pair;

class LongestPalindromeString {


    private Pair getLongPal(String s, int x, int y, Pair[][] table){
        if(table[x][y] != null){
            return table[x][y];
        }
        if(x == y){
            table[x][y] = new Pair(x,x);
            return table[x][y];
        }
        if(y-x == 1){
            if(s.charAt(x) == s.charAt(y)){
                table[x][y] = new Pair(x,y);
            }else{
                table[x][y] = new Pair(x,x);
            }
            return table[x][y];
        }
        if(s.charAt(x) == s.charAt(y)){
            Pair<Integer, Integer> resPair;
            Pair<Integer, Integer> tempPair1 = getLongPal(s, x+1, y-1, table);
            if(tempPair1.getKey()-1 == x && tempPair1.getValue()+1 == y){
                table[x][y] = new Pair(x,y);
            }else{
                Pair<Integer, Integer> tempPair2 = getLongPal(s, x, y-1, table);
                if(tempPair2.getValue() - tempPair2.getKey() >= tempPair1.getValue() - tempPair1.getKey()){
                    resPair = tempPair2;
                }else{
                    resPair = tempPair1;
                }
                Pair<Integer, Integer> tempPair3 = getLongPal(s, x+1, y, table);
                if(resPair.getValue() - resPair.getKey() < tempPair3.getValue() - tempPair3.getKey()){
                    resPair = tempPair3;
                }
                table[x][y] = new Pair(resPair.getKey(), resPair.getValue());
            }
        }else{
            Pair resPair;
            Pair<Integer, Integer> tempPair1 = getLongPal(s, x, y-1, table);
            Pair<Integer, Integer> tempPair2 = getLongPal(s, x+1, y, table);
            if(tempPair1.getValue() - tempPair1.getKey() >= tempPair2.getValue() - tempPair2.getKey()){
                resPair = tempPair1;
            }else{
                resPair = tempPair2;
            }
            table[x][y] = new Pair(resPair.getKey(), resPair.getValue());
        }
        return table[x][y];
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0){
            return "";
        }
        Pair[][] table = new Pair[len][len];
        Pair<Integer, Integer> resPair = getLongPal(s, 0, len-1, table);
        return s.substring(resPair.getKey(), resPair.getValue()+1);
    }


    private Pair checkPalindrome(String s, int i1, int i2){
        Pair maxPair = new Pair(i1,i1);
        while(i1 >= 0 && i2 <= s.length()-1){
            if(s.charAt(i1) != s.charAt(i2)){
                break;
            }
            maxPair = new Pair(i1,i2);
            i1 -= 1;
            i2 += 1;
        }
        return maxPair;
    }

    public String longestPalindromeOptimized(String s) {
        int len = s.length();
        if(len == 0){
            return "";
        }
        Pair<Integer, Integer> longSoFar = new Pair(0,0);
        for(int i=0; i<len-1; i++){

            // even length palindromes
            Pair<Integer , Integer> currPair = checkPalindrome(s, i, i+1);
            if(currPair.getValue() - currPair.getKey() > longSoFar.getValue() - longSoFar.getKey()){
                longSoFar = currPair;
            }

            // odd length palindromes
            currPair = checkPalindrome(s, i-1, i+1);
            if(currPair.getValue() - currPair.getKey() > longSoFar.getValue() - longSoFar.getKey()){
                longSoFar = currPair;
            }
        }
        return s.substring(longSoFar.getKey(), longSoFar.getValue()+1);
    }

    public static void main(String args[]){
        LongestPalindromeString lps = new LongestPalindromeString();
        System.out.println(lps.longestPalindromeOptimized("").equals(""));
        System.out.println(lps.longestPalindromeOptimized("abc").equals("a"));
        System.out.println(lps.longestPalindromeOptimized("aba").equals("aba"));
        System.out.println(lps.longestPalindromeOptimized("paba").equals("aba"));
        System.out.println(lps.longestPalindromeOptimized("abap").equals("aba"));
        System.out.println(lps.longestPalindromeOptimized("tabap").equals("aba"));
        System.out.println(lps.longestPalindromeOptimized("btabbapb").equals("abba"));
        System.out.println(lps.longestPalindromeOptimized("bpabbatpb").equals("abba"));
        System.out.println(lps.longestPalindromeOptimized("bptabbapb").equals("abba"));
        System.out.println(lps.longestPalindromeOptimized("dbpabbapb").equals("bpabbapb"));
        System.out.println(lps.longestPalindromeOptimized("bpabbapbpb").equals("bpabbapb"));
        System.out.println(lps.longestPalindromeOptimized("babadabab").equals("babadabab"));
        System.out.println(lps.longestPalindromeOptimized("babad").equals("bab"));
        System.out.println(lps.longestPalindromeOptimized("cbbd").equals("bb"));
    }

}
