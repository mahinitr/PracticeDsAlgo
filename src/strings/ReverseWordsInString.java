package strings;

public class ReverseWordsInString {

    static String reversWords(String s){
        if(s == null || s.length() == 0 || !s.contains(".")){
            return s;
        }
        String temp = "";
        int i=s.length()-1;
        for(; i >= 0; i--){
            if(s.charAt(i) == '.'){
                break;
            }
            temp = s.charAt(i) + temp;
        }
        if(i>0){
            return temp + "." + reversWords(s.substring(0,i));
        }else{
            return temp + "." + "";
        }
    }

    public static void main(String[] args){
        System.out.println(reversWords("i.like.coding.job"));
        System.out.println(reversWords(".abc.def."));
        System.out.println(reversWords("abc"));
        System.out.println(reversWords("abc."));
        System.out.println(reversWords("A.B.C.D"));
        System.out.println(reversWords("abc.def.ghijkl.mnop.q.r.s"));
        System.out.println(reversWords(null));
        System.out.println(reversWords(""));
        System.out.println(reversWords("mahesh.reddy.kontham"));
    }

}
