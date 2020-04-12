import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.isEmpty();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //System.out.println(twoStrings("hi", "world"));
    }
    static int firstBitSetPos(int n){
        for(int i=0; i<32; i++){
            int bit = (n & (1<<i)) >= 1 ? 1 : 0;
            if(bit == 1){
                return i+1;
            }
        }
        return -1;
    }

    static String twoStrings(String s1, String s2){
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        for(int i=0; i < s1.length(); i++){
            hashtable.put(s1.charAt(i), 1);
        }
        for(int j=0; j < s2.length(); j++){
            if(hashtable.containsKey(s2.charAt(j))){
                return "YES";
            }
        }
        return "NO";
    }





}
