package strings;

/*
Find the longest sequence of alphabets in a given string.  Input :
SACHINEFGDHONIIJKLMNOPKHOLI  EFG and IJKLMNOP are two sub strings which are in sequence.
We need the longest sequence so IJKLMNOP is the solution.  Output : IJKLMNOP 

Example Inputs:
A
ABCIEFGH
AB
ABC
GMJ
SACHINEFGDHONIIJKLMNOPKHOLI  EFG

ABCHGFE

EFGFEDC - GFEDC
GFEDCDE - GFEDC

*/

class LongestIncreasingSequenceOfAlphabets{

    String longSeq(String s){
        if(s.length() < 2){
            return null;
        }
        int maxI = -1;
        int maxJ = -1;
        int currI = 0;
        int currJ = 0;
        int currDI = 0;
        int currDJ = 0;
        int maxLen = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1) + 1){
                if((currDJ - currDI + 1) > maxLen){
                    maxLen = (currDJ - currDI + 1);
                    maxI = currDI;
                    maxJ = currDJ;
                }
                currDI = i;
                currDJ = i;
                currJ = i;
                continue;
            } else if(s.charAt(i) == s.charAt(i-1) - 1){
                if((currJ - currI + 1) > maxLen){
                    maxLen = (currJ - currI + 1);
                    maxI = currI;
                    maxJ = currJ;
                }
                currI = i;
                currJ = i;
                currDJ = i;
                continue;
            }
            if((currDJ - currDI + 1) > maxLen){
                maxLen = (currDJ - currDI + 1);
                maxI = currDI;
                maxJ = currDJ;
            }
            if((currJ - currI + 1) > maxLen){
                maxLen = (currJ - currI + 1);
                maxI = currI;
                maxJ = currJ;
            }
            currI = i;
            currJ = i;
            currDI = i;
            currDJ = i;
        }
        if((currJ - currI + 1) > maxLen){
            maxI = currI;
            maxJ = currJ;
            maxLen = (currJ - currI + 1);
        }
        if((currDJ - currDI + 1) > maxLen){
            maxI = currDI;
            maxJ = currDJ;
            maxLen = (currDJ - currDI + 1);
        }
        if(maxLen > 1){
            return s.substring(maxI, maxJ + 1);
        }else {
            return null;
        }
    }

    public static void main(String[] args){
        LongestIncreasingSequenceOfAlphabets obj = new LongestIncreasingSequenceOfAlphabets();
        System.out.println(obj.longSeq("ABCIDEF").equals("ABC"));
        System.out.println(obj.longSeq("ABCIDEFGB").equals("DEFG"));
        System.out.println(obj.longSeq("SACHINEFGDHONIIJKLMNOPKHOLI  EFG").equals("IJKLMNOP"));
        System.out.println(obj.longSeq("AB").equals("AB"));
        System.out.println(obj.longSeq("BA").equals("BA"));
        System.out.println(obj.longSeq("A") == null);
        System.out.println(obj.longSeq("GWN") == null);
        System.out.println(obj.longSeq("GFEDCDE").equals("GFEDC"));
        System.out.println(obj.longSeq("ABCDCB").equals("ABCD"));
        System.out.println(obj.longSeq("LKJIHIJKLMNOPQMEFGH").equals("HIJKLMNOPQ"));
    }

}









