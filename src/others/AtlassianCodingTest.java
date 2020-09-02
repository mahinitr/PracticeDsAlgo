package others;


/*

Voting function

Arrays.asList("A", "B", "A", "C", "D", "B", "A");  Output: "A"
String findWinner(List<String> votes) 

votes : 10M(A,B,C) ->

4 cand

Approach-1:
counter map: cand->count
maxCnt, maxCand
TimeL O(N), Space: O(M)


cand >= 3

each voter - 3 votes;
B(3), A(2), C(1)
D(3), E(2), F(1)

B, A, C
D, E, F
A, D, B
D, C, A

A - 2 + 3 + 1 = 6
B - 3 + 1
C - 1 + 2
D - 3 + 2 + 3 = 8
E - 2
F - 1

List<List<String>> votes


 */

import java.util.*;

public class AtlassianCodingTest {

    /*
    M: no of voters, N - no of cand, K = no of min votes for each voter
    Time: O(M*K)
    Space: O(N)
     */
    String findWinnerWeight(List<List<String>> votes){
        int noMaxVotes = 0;
        String candWithMaxVotes = "";
        Map<String, Integer> candToCountMap = new HashMap<>();

        for(int loopCounter=0; loopCounter<votes.size(); loopCounter++){
            List<String> currVotes = votes.get(loopCounter);
            int weight = currVotes.size();
            for(int votesCounter=0; votesCounter<currVotes.size(); votesCounter++){
                String candidate = currVotes.get(votesCounter);
                Integer count = candToCountMap.get(candidate);
                if(count == null){
                    count = 0;
                    candToCountMap.put(candidate , count);
                }
                count += weight;
                candToCountMap.put(candidate, ++count);
                if(count > noMaxVotes){
                    noMaxVotes = count;
                    candWithMaxVotes = candidate;
                }
                weight--;
            }
        }
        return  candWithMaxVotes;
    }

    String findWinner(List<String> votes){
        int noMaxVotes = 0;
        String candWithMaxVotes = "";
        Map<String, Integer> candToCountMap = new HashMap<>();
        for(int loopCounter=0; loopCounter<votes.size(); loopCounter++){
            String candidate = votes.get(loopCounter);
            Integer count = candToCountMap.get(candidate);
            if(count == null){
                count = 0;
                candToCountMap.put(candidate , count);
            }
            candToCountMap.put(candidate, ++count);
            if(count > noMaxVotes){
                noMaxVotes = count;
                candWithMaxVotes = candidate;
            }
        }

        return candWithMaxVotes;
    }

    public static void main(String[] args){
        AtlassianCodingTest test = new AtlassianCodingTest();
        System.out.println(test.findWinner(Arrays.asList("A", "B", "A", "C", "D", "B", "A")));
        System.out.println(test.findWinner(Arrays.asList("A", "B", "A", "C", "D", "B", "D")));

        List<List<String>> votes = new ArrayList<>();
        votes.add(Arrays.asList("B", "A", "C"));
        votes.add(Arrays.asList("D", "E", "F"));
        votes.add(Arrays.asList("A", "D", "B"));
        votes.add(Arrays.asList("D", "C", "A"));
        System.out.println(test.findWinnerWeight(votes));

        votes = new ArrayList<>();
        votes.add(Arrays.asList("B", "A", "C"));
        votes.add(Arrays.asList("D", "B", "F"));
        votes.add(Arrays.asList("B", "D", "E"));
        votes.add(Arrays.asList("D", "C", "A"));
        System.out.println(test.findWinnerWeight(votes));

    }

}
