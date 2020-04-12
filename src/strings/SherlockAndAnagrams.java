package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s){
        Map<String, Integer> substringMap = new HashMap<>();
        int result = 0;

        for(int i=0; i< s.length(); i++){
            int end = s.length()-1;
            if(i>0){
                end = s.length();
            }
            for(int j=i; j< end; j++){
                String substring = s.substring(i,j+1);
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                String newSubString = new String(chars);
                Integer count = substringMap.get(newSubString);
                if(count == null){
                    count = 0;
                }
                count++;
                substringMap.put(newSubString, count);
            }
        }

        for(String subStr : substringMap.keySet()){
            int count = substringMap.get(subStr);
            result = result + (count * (count - 1)) / 2;
        }

        return result;
    }

    public static void main(String args[]){
        System.out.println(sherlockAndAnagrams("cdcd"));
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("kkkk"));

    }

}
