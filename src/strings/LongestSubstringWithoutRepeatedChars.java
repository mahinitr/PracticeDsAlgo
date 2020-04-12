package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatedChars {

    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }

        int result = 0, temp = 0;;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            charMap.clear();
            charMap.put(s.charAt(i), 1);
            int j = i+1;
            for(; j<s.length(); j++){
                if(charMap.containsKey(s.charAt(j)) && charMap.get(s.charAt(j)) == 1){
                    break;
                }
                charMap.put(s.charAt(j), 1);
            }
            temp = j-i;
            if(result < temp){
                result = temp;
                if(j == s.length()){
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatedChars obj = new LongestSubstringWithoutRepeatedChars();
        System.out.println(obj.lengthOfLongestSubstring("abcd"));
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("abcabcdbb"));
        System.out.println(obj.lengthOfLongestSubstring("abcabcdbb"));
        System.out.println(obj.lengthOfLongestSubstring(null));
        System.out.println(obj.lengthOfLongestSubstring(""));
        System.out.println(obj.lengthOfLongestSubstring("a"));
        System.out.println(obj.lengthOfLongestSubstring("ab"));
        System.out.println(obj.lengthOfLongestSubstring("aaa"));


    }
}
