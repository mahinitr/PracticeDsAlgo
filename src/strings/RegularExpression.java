package strings;

public class RegularExpression {

    public boolean isMatchBadCode(String s, String p) {
        int m = s.length();
        int n = p.length();
        int i=0, j=0;
        char prevChr = 1;
        int startI = m;
        while(i < m && j < n){
            if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
                i++;
                j++;
                prevChr = 1;
                startI = m;
                continue;
            }
            else if(p.charAt(j) == '*'){
                prevChr = 1;
                if(j > 0 && p.charAt(j-1) != '*'){
                    char prev = p.charAt(j-1);
                    prevChr = prev;
                    startI = i-1;
                    while(i < m && (prev == '.' || s.charAt(i) == prev))
                        i++;
                    int cnt = 0;
                    j++;
                    while(j < n && p.charAt(j) == prev) {
                        cnt++;
                        j++;
                    }
                    if(i - startI < cnt){
                        return false;
                    }
                }else {
                    j++;
                }
            }
            else if(p.charAt(j) != s.charAt(i)){
                prevChr = 1;
                startI = m;
                if(j+1 < n && p.charAt(j+1) == '*'){
                    j = j + 2;
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(prevChr != 1){
            int cnt = 0;
            while(j < n){
               if(j+1 < n && p.charAt(j+1) == '*') {
                   j = j + 2;
                   continue;
               }
               if(p.charAt(j) == prevChr){
                   cnt++;
                   j++;
               }else{
                   return false;
               }
            }
            if(m - startI < cnt)
                return false;
        }else{
            while(j < n){
                if(j+1 < n && p.charAt(j+1) == '*') {
                    j = j + 2;
                    continue;
                }else{
                    return false;
                }
            }
        }
        return i >= m && j >= n;

    }


    public boolean isMatch(String s, String p) {
        if(p.isEmpty())
            return s.isEmpty();
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }else{
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String arg[]){
        RegularExpression re = new RegularExpression();
        System.out.println(re.isMatch("abc","a*bc") == true);
        System.out.println(re.isMatch("a","ab*") == true);
        System.out.println(re.isMatch("abc","...") == true);
        System.out.println(re.isMatch("abc","abc") == true);
        System.out.println(re.isMatch("aaaa","a*") == true);
        System.out.println(re.isMatch("aaaaa",".*") == true);
        System.out.println(re.isMatch("abcd",".*") == true);
        System.out.println(re.isMatch("aaaab","a*b") == true);
        System.out.println(re.isMatch("aaaaaaaab","a*c") == false);
        System.out.println(re.isMatch("abc","...") == true);
        System.out.println(re.isMatch("aab","c*a*b") == true);
        System.out.println(re.isMatch("abccc",".bc*") == true);
        System.out.println(re.isMatch("iiiii","i*") == true);
        System.out.println(re.isMatch("ab",".*c") == false);
        System.out.println(re.isMatch("aaaaaa","aa*aaa") == true);
        System.out.println(re.isMatch("aaaaaa","a*aaa") == true);
        System.out.println(re.isMatch("aa","a*aaa") == false);
        System.out.println(re.isMatch("aa","aa*aa") == false);
        System.out.println(re.isMatch("aaaaaaaabc","a*aaabc") == true);
        System.out.println(re.isMatch("aaabc","a*aaabc") == true);
        System.out.println(re.isMatch("aabc","a*aaabc") == false);
        System.out.println(re.isMatch("aaabc","aaabc") == true);
        System.out.println(re.isMatch("aabc","*aaabc") == false);
        System.out.println(re.isMatch("mississippi","mis*is*ip*.") == true);
        System.out.println(re.isMatch("mississippi",".is*.*") == true);
        System.out.println(re.isMatch("mississippi",".is*.s*.p") == false);
        System.out.println(re.isMatch("missssissippi","mis*.s*d*ip*.") == true);
        System.out.println(re.isMatch("aaa","ab*a*c*a") == true);
        System.out.println(re.isMatch("aaa","ab*a*c*b") == false);
        System.out.println(re.isMatch("aaa","ab*a*c*a*a*aa") == true);
        System.out.println(re.isMatch("aaa","ab*a*c*a*a*aa*a") == true);
        System.out.println(re.isMatch("aaa","ab*a*c*a*a*aa*aaa") == false);
        System.out.println(re.isMatch("aaa","ab*a*c*a*a") == true);
        System.out.println(re.isMatch("aaa","ab*a*cba") == false);
        System.out.println(re.isMatch("bbbba",".*a*a") == true);
        System.out.println(re.isMatch("bbbbaa",".*a*aa") == true);
        System.out.println(re.isMatch("bbbbaabaa",".*a*aab*aa") == true);
    }

}
