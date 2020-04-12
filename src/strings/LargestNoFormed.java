package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNoFormed {

    static class ExtendedString{
        String s1;
        String s2;

        ExtendedString(String s1, String s2){
            this.s1= s1;
            this.s2 = s2;
        }

        public String toString(){
            return "S1 - " + s1 + "; S2 - " + s2;
        }

    }

    static String getLargestNo(String[] arr){
        int n = 0;

        //find the length of largest no
        for(String s : arr){
            if(n < s.length()){
                n = s.length();
            }
        }

        // form the objects of extended version
        List<ExtendedString> extendedStrings = new ArrayList<>();
        for(String s1 : arr){
            StringBuilder s2 = new StringBuilder();
            int j=0;
            for(int i=0; i<n+1; i++){
                if(j>=s1.length()){
                    j=0;
                }
                s2.append(s1.charAt(j++));
            }

            ExtendedString extendedString = new ExtendedString(s1, s2.toString());
            extendedStrings.add(extendedString);
        }



        Collections.sort(extendedStrings, new Comparator<ExtendedString>() {
            @Override
            public int compare(ExtendedString o1, ExtendedString o2) {
                return o2.s2.compareTo(o1.s2);
            }
        });

        for(ExtendedString extendedString : extendedStrings){
            System.out.println(extendedString);
        }

        StringBuilder result = new StringBuilder();
        for(ExtendedString extendedString : extendedStrings){
            result.append(extendedString.s1);
        }
        return result.toString();

    }

    public static void main(String[] args){
        System.out.println(getLargestNo(new String[]{"59","54","81","536","58","9"}));
        System.out.println(getLargestNo(new String[]{"1","34","3","98","9","76","45","4","12","121"}));
    }

}
