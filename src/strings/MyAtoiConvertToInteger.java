package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAtoiConvertToInteger {

    public static void main(String[] args){
        MyAtoiConvertToInteger atio = new MyAtoiConvertToInteger();
        System.out.println(atio.myAtoiRegex("   -4567mnn"));
        System.out.println(atio.myAtoiRegex("   4567ghh"));
        System.out.println(atio.myAtoiRegex("   3147483647 mbb"));
        System.out.println(atio.myAtoiRegex("   -3147483648"));
        System.out.println(atio.myAtoiRegex("   -56778 789 677 mmm"));
        System.out.println(atio.myAtoiRegex("   "));
        System.out.println(atio.myAtoiRegex("+"));
        System.out.println(atio.myAtoiRegex("-"));
        System.out.println(atio.myAtoiRegex("1"));
        System.out.println(atio.myAtoiRegex("-1"));
        System.out.println(atio.myAtoiRegex("A"));
        System.out.println(atio.myAtoiRegex("   +1234"));
        System.out.println(atio.myAtoiRegex("   -hjkhj"));
        System.out.println(atio.myAtoiRegex("   -1A"));
        System.out.println(atio.myAtoiRegex("   2A"));
        System.out.println(atio.myAtoiRegex("   -hjkhj 1234"));
    }

    public int myAtoiRegex(String str) {
        if(str == null){
            return 0;
        }
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        boolean negative = false;
        String numStr = "";
        int no;
        char ch1 = str.charAt(0);
        if(ch1 != '+' && ch1 != '-' && !('0' <= ch1 && ch1 <= '9')){
            return 0;
        }
        if(str.length() > 1) {
            char ch2 = str.charAt(1);
            if (ch1 == '-' || ch1 == '+') {
                if (ch2 < '0' || ch2 > '9') {
                    return 0;
                }
            }
            if (ch1 == '-') {
                negative = true;
            }

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                numStr = matcher.group();
            }
        }else{
            if('0' <= ch1 && ch1 <= '9'){
                numStr = "" + ch1;
            }
        }

        try{
            no = Integer.parseInt(numStr);
            no = negative ? -1 * no : no;
        }catch(NumberFormatException e){
            no = negative ? -2147483648  : 2147483647;
        }
        return no;
    }


    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        boolean negative = false;
        String numStr = "";

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(i == 0){
                if(ch == '-'){
                    negative = true;
                } else if('0' <= ch && ch <= '9'){
                    numStr = numStr + ch;
                } else if(ch != '+'){
                    return 0;
                }
                continue;
            }
            if(ch < '0' || ch > '9'){
                break;
            }
            numStr = numStr + ch;
        }

        if(numStr.length() == 0){
            return 0;
        }
        int no;
        try{
            no = Integer.parseInt(numStr);
            no = negative ? -1 * no : no;
        }catch(NumberFormatException e){
            no = negative ? -2147483648  : 2147483647;
        }
        return no;
    }

}
