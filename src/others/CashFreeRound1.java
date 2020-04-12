package others;
import java.util.*;

class FreqStack{

    Map<Integer, Integer> elemCountMap;
    Map<Integer, List<Integer>> countListMap;
    int maxCount;

    FreqStack(){
        elemCountMap = new HashMap<>();
        countListMap = new HashMap<>();
    }

    void push(int i){
        Integer count = elemCountMap.get(i);
        if(count == null){
            count = 0;
        }
        elemCountMap.put(i, ++count);
        maxCount = Math.max(count, maxCount);

        List<Integer> list = countListMap.get(count);
        if(list == null){
            list = new ArrayList<>();
            countListMap.put(count, list);
        }
        list.add(i);
    }

    int pop() throws Exception{
        if(countListMap.size() == 0){
            throw new Exception("Stack is empty");
        }
        List<Integer> list = countListMap.get(maxCount);
        int elem = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if(list.size() == 0){
            countListMap.remove(maxCount);
            maxCount--;
        }
        return elem;
    }

}

public class CashFreeRound1 {

    public static void main(String[] args){
        FreqStack stack = new FreqStack();

        //S - [5,7,5,7,4,5,7,4,5,6,7]
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        try {
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());



        }catch(Exception e){
            System.out.println("error");
        }


    }


}
