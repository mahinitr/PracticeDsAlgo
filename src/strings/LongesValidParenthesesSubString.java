package strings;

public class LongesValidParenthesesSubString {

    private int ll(int n, String s){
        if(s.length() == 0 || s.length() == 1){
            return n;
        }
        if(s.charAt(0) == '(' && s.charAt(1) == ')'){
            return ll(n+2, s.substring(2));
        }else{
            return Math.max(n, ll(0, s.substring(1)));
        }
    }

    public int longestValidParentheses(String s) {
        return ll(0, s);
    }

    public static void main(String arg[]){
        LongesValidParenthesesSubString obj = new LongesValidParenthesesSubString();
        System.out.println(obj.longestValidParentheses("()") == 2);
        System.out.println(obj.longestValidParentheses(")(") == 0);
        System.out.println(obj.longestValidParentheses("())") == 2);
        System.out.println(obj.longestValidParentheses("(()") == 2);
        System.out.println(obj.longestValidParentheses("()()") == 4);
        System.out.println(obj.longestValidParentheses("(()()") == 4);
        System.out.println(obj.longestValidParentheses("()())") == 4);
        System.out.println(obj.longestValidParentheses(")()())") == 4);
        System.out.println(obj.longestValidParentheses(")()())()()())") == 6);
    }

}
