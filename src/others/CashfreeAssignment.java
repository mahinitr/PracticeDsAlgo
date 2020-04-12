package others;

public class CashfreeAssignment {

    static int maxScore(int[][] steps){
        int n = steps.length;
        int[] scores = new int[n+1];
        for(int i=0; i<n; i++){
            int[] step = steps[i];

            //choose x
            int sum = step[0] + scores[i];
            int dest = i + 1;
            if(dest > n){
                dest = n;
            }
            scores[dest] = Math.max(scores[dest], sum);

            // choose y
            sum = step[1] + scores[i];
            dest = i + 2;
            if(dest > n){
                dest = n;
            }
            scores[dest] = Math.max(scores[dest], sum);

            // choose z
            sum = step[2] + scores[i];
            dest = i + 3;
            if(dest > n){
                dest = n;
            }
            scores[dest] = Math.max(scores[dest], sum);
        }
        return scores[n];
    }

    public static void main(String[] args){

        int[][] steps = new int[][]{{1, 2, 3},{4, 5, 6}};
        System.out.println(maxScore(steps));

        steps = new int[][]{{4, 7, 8},
                            {1, 2, 3},
                            {7, 8, 9 }
                            };
        System.out.println(maxScore(steps));

        steps = new int[][]{
                {4,7,8},
                {1,2,3},
                {7,8,9},
                {4,5,6},
                {10,15,20},
                {8,15,18},
                {10,12,14},
                {30,35,40}
        };
        System.out.println(maxScore(steps));

        steps = new int[][]{{1,2,3}};
        System.out.println(maxScore(steps));

        steps = new int[][]{};
        System.out.println(maxScore(steps));

    }

}
