package arrays.arrayManipulation;

import java.io.*;
import java.util.*;

class Operation{
    private int a;
    private int b;
    private int k;

    Operation(){

    }

    Operation(int a, int b, int k){
        this.a = a;
        this.b = b;
        this.k = k;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public void addK(int newK){
        this.k = this.k + newK;
    }

    @Override
    public String toString() {
        return a + " " + b + " " + k;
    }

    public Operation clone(){
        Operation op = new Operation(this.a, this.b, this.k);
        return op;
    }

}

public class Solution {

    static long getMaxValueInArray(int n, List<Operation> ops){
        if(ops.size() == 0){
            return 0;
        }
        List<Operation> trackOperations = new ArrayList<>();
        trackOperations.add(ops.get(0));
        int maxValue = ops.get(0).getK();
        int i = 1;
        Operation currOp = null;
        while (true){
            if(currOp == null){
                if(i < ops.size()){
                    currOp = ops.get(i++);
                }else {
                    break;
                }
            }
            int j = 0;
            for(;j < trackOperations.size();j++){
                Operation op = trackOperations.get(j);
                //Falls on left side of prev
                if(currOp.getA()< op.getA()){
                    if(currOp.getB() < op.getA()) {
                        trackOperations.add(j, currOp);
                        currOp = null;
                        break;
                    }
                    if(currOp.getB() <= op.getB()){
                        trackOperations.remove(j);
                        Operation op1 = new Operation(currOp.getA(), op.getA()-1, currOp.getK());
                        Operation op2 = new Operation(op.getA(), currOp.getB(), op.getK() + currOp.getK());
                        trackOperations.add(j++, op1);
                        trackOperations.add(j++, op2);
                        if(currOp.getB() + 1 <= op.getB()){
                            Operation op3 = new Operation(currOp.getB() + 1, op.getB(), op.getK());
                            trackOperations.add(j, op3);
                        }
                        currOp = null;
                        break;
                    } else{
                        Operation op1 = new Operation(currOp.getA(), op.getA()-1, currOp.getK());
                        trackOperations.add(j++, op1);
                        trackOperations.get(j).addK(currOp.getK());
                        //Operation op2 = new Operation(op.getA(), op.getB(), op.getK() + currOp.getK());
                        currOp = new Operation(op.getB()+1, currOp.getB(), currOp.getK());
                        continue;
                    }
                }
                if(op.getB() < currOp.getB()){
                    if(op.getB() < currOp.getA()){
                        continue;
                    }
                    trackOperations.remove(j);
                    if(op.getA() <= currOp.getA() - 1){
                        Operation op1 = new Operation(op.getA(), currOp.getA()-1, op.getK());
                        trackOperations.add(j++, op1);
                    }
                    Operation op2 = new Operation(currOp.getA(), op.getB(), currOp.getK() + op.getK());
                    trackOperations.add(j, op2);
                    currOp = new Operation(op.getB()+1, currOp.getB(), currOp.getK());
                    continue;
                }
                trackOperations.remove(j);
                if(op.getA() <= currOp.getA() - 1){
                    Operation op1 = new Operation(op.getA(), currOp.getA()-1, op.getK());
                    trackOperations.add(j++, op1);
                }
                Operation op2 = new Operation(currOp.getA(), currOp.getB(), currOp.getK() + op.getK());
                trackOperations.add(j++, op2);
                if(currOp.getB()+1 <= op.getB()){
                    Operation op3 = new Operation(currOp.getB() + 1, op.getB(), op.getK());
                    trackOperations.add(j, op3);
                }
                currOp = null;
                break;
            }
            if(currOp != null && j == trackOperations.size()){
                trackOperations.add(j, currOp);
                currOp = null;
            }
        }
        for(Operation op: trackOperations){
            System.out.println(op);
            if(maxValue < op.getK()){
                maxValue = op.getK();
            }
        }
        return maxValue;
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        List<Operation> ops = new ArrayList<>();
        for(int query[] : queries){
            //System.out.println(query[0] + " " + query[1] + " " + query[2]);
            Operation operation = new Operation(query[0], query[1],query[2]);
            ops.add(operation);
        }
        return getMaxValueInArray(n, ops);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];
        List<Operation> ops = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            //System.out.println(queriesRowItems[0]);
            /*for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }*/
            int A = Integer.parseInt(queriesRowItems[0]);
            int B = Integer.parseInt(queriesRowItems[1]);
            int K = Integer.parseInt(queriesRowItems[2]);
            Operation operation = new Operation(A,B,K);
            ops.add(operation);
        }

        //long result = arrayManipulation(n, queries);
        long result = getMaxValueInArray(n, ops);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
/*
100 4
10 20 1
1 5 1
6 20 1
15 30 1
35 40 1
*/

/*
100 5
10 20 1
10 20 1
12 16 1
10 15 1
15 20 1
*/

/*
100 7
10 20 1
1 5 1
30 40 1
6 25 1
23 27
45 50 1
51 60 1
*/

/*
100 13
10 20 1
1 5 1
30 40 1
41 50 1
22 26 1
12 16 1
10 20 1
15 20 1
10 15 1
5 15 1
5 25 1
15 35 1
10 10 1

ANS : 8
*/



}
