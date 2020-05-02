package bits;

/*
Concatonate binary representations of N ints and module 10^9 + 7

N = 3
Output: 27
"1" + "10" + "11" = 11011 = 27.
N = 4
Output: 27
"1" + "10" + "11" + "100" = 4+8+16+64+128=220.

 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BigBinaryNoConcatBitsOfNInts {

    static List<Integer> bin(int n){
        List<Integer> bits = new ArrayList<>();
        int i = 31;
        while(n>0){
            bits.add(0,n & 1);
            n = n >> 1;
        }
        //System.out.println(n + " - " + bits);
        return bits;
    }

    static int getN(List<Integer> bits){
        double n = 0;
        for(int i=0; i < bits.size(); i++){
            n = n + bits.get(bits.size()-1-i) * Math.pow(2, i);
        }
        return (int)(n % (Math.pow(10,9) + 7));
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Integer> newBits = new ArrayList<>();
        for(int i=1; i<=n; i++){
            newBits.addAll(bin(i));
        }
        //System.out.println(newBits);
        int curr = getN(newBits);
        System.out.println(curr);
    }
}
