package strings;

public class ZigZagPattern {

    public void convert(String s, int numRows) {
        if(s == null){
            return;
        }
        if(numRows == 1){
            System.out.println(s);
            return;
        }
        int startAdd = 2 * numRows - 2;
        int len = s.length();
        int a1 = startAdd;
        int a2 = 0;
        for(int i=0; i<numRows; i++){
            int currIndex = i;
            while(currIndex < len){
                System.out.print(s.charAt(currIndex));
                if(i == 0){
                    currIndex += a1;
                } else if(i == numRows-1){
                    currIndex += a2;
                } else{
                    currIndex += a1;
                    if(currIndex >= len){
                        break;
                    }
                    System.out.print(s.charAt(currIndex));
                    currIndex += a2;
                }
            }
            a1 = a1 - 2;
            a2 = startAdd - a1;
        }
        System.out.println();
    }

    public static void main(String args[]){
        ZigZagPattern obj = new ZigZagPattern();
        obj.convert("PAYPALISHIRING",1);
        obj.convert("PAYPALISHIRING",2);
        obj.convert("PAYPALISHIRING",3);
        obj.convert("PAYPALISHIRING",4);
        obj.convert("PAYPALISHIRING",7);
    }
}
