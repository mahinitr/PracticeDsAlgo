package strings;


// package whatever; // don't place package name!

import java.io.*;

/*
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
*/



class CompareStringsWithBackSpace {

    public boolean backspaceCompare(String S, String T) {
        int noSHashes = 0;
        int noTHashes = 0;
        int i=S.length()-1;
        int j=T.length()-1;
        while(i>=0 && j>=0){
            do{
                if(S.charAt(i) == '#'){
                    noSHashes++;
                    i = i - 1;
                }else{
                    if(noSHashes > 0){
                        noSHashes--;
                        i = i - 1;
                    }
                }
            }while(noSHashes > 0 && i>=0);

            if(noSHashes<0){
                noSHashes = 0;
            }

            do{
                if(T.charAt(j) == '#'){
                    noTHashes++;
                    j = j - 1;
                }else{
                    if(noTHashes > 0){
                        noTHashes--;
                        j = j - 1;
                    }
                }
            }while(noTHashes > 0 && j>=0);

            if(noTHashes<0){
                noTHashes = 0;
            }


            if(i<0 || j<0){
                break;
            }
            if(S.charAt(i) != T.charAt(j)){
                return false;
            }
            i=i-1;
            j=j-1;
        }

        if(i>=0){
            do{
                if(S.charAt(i) == '#'){
                    noSHashes++;
                    i = i - 1;
                }else{
                    if(noSHashes > 0){
                        noSHashes--;
                        i = i - 1;
                    }
                }
            }while(noSHashes > 0 && i>=0);
        }


        if(j>=0){
            do{
                if(T.charAt(j) == '#'){
                    noTHashes++;
                    j = j - 1;
                }else{
                    if(noTHashes > 0){
                        noTHashes--;
                        j = j - 1;
                    }
                }
            }while(noTHashes > 0 && j>=0);
        }

        return (i<0 && j<0);

    }

    public static void main (String[] args) {
        //System.out.println("Hello Java");
        CompareStringsWithBackSpace code = new CompareStringsWithBackSpace();

        System.out.println(code.backspaceCompare("ab#c", "ad#c") == true);
        System.out.println(code.backspaceCompare("ab##", "c#d#") == true);
        System.out.println(code.backspaceCompare("a##c", "#a#c") == true);
        System.out.println(code.backspaceCompare("a#c", "b") == false);
        System.out.println(code.backspaceCompare("ibh##ef#jmo#", "iwow###ejabc###mab##") == true);
    }
}

