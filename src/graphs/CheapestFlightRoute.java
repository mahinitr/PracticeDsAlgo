package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    You are given a huge list of airline ticket prices between different cities around the world on a given day.

        These are all direct flights. Each element in the list has the format (source_city, destination, price).  
        Consider a user who is willing to take up to k connections from their origin city A to their destination B.

        Find the cheapest fare possible for this journey and print the itinerary for that journey.  

        For example, our traveler wants to go from MAA to BLR with up to 3 connections, and our input flights are as follows:  
        [ ('MAA', 'HYD', 150), ('HYD', 'DEL', 400), ('MUM', 'BLR', 200), ('BLR', 'PUN', 80), ('MAA', 'COC', 800), ('HYD', 'MUM', 90), ('MAA', 'BLR', 500), ] 
        Due to some improbably low flight prices, the cheapest itinerary would be MAA -> HYD -> MUM -> BLR, costing $440.

        150+90+200

        INPUT: LIST OF PAIRS,  SRC, DEST, K


        MAA -> HYD, COC, BLR
        HYD -> DEL, MUM
        MUM -> BLR
        BLR -> PUN

        MAA -> ('MAA', 'HYD', 150), COC, BLR
        HYD -> DEL, MUM
        MUM -> BLR
        BLR -> PUN


        MAA, HYD

*/


class Ticket{
    String SRC;
    String DEST;
    int price;
    Ticket(String src, String dest, int price){
        this.SRC = src;
        this.DEST = dest;
        this.price = price;
    }
}

class FLightGraph{
    Map<String, List<Ticket>> adjList;

    FLightGraph(List<Ticket> tickets){
        adjList = new HashMap<>();
        for(Ticket ticket : tickets){
            List<Ticket> edges = adjList.get(ticket.SRC);
            if(edges == null){
                edges = new ArrayList<>();
                adjList.put(ticket.SRC, edges);
            }
            edges.add(ticket);
        }
    }

    int getCheapestV1(int k, String SRC, String DEST, int cost){
        if(k<=0){
            return Integer.MAX_VALUE;
        }
        List<Ticket> edges = adjList.get(SRC);
        int minCost = Integer.MAX_VALUE;
        if(edges != null) {
            for (Ticket edge : edges) {
                int currCost;
                if (edge.DEST == DEST) {
                    currCost = edge.price + cost;
                } else {
                    currCost = getCheapestV1(k - 1, edge.DEST, DEST, edge.price + cost);
                }
                if (minCost > currCost) {
                    minCost = currCost;
                }
            }
        }
        return minCost;
    }

    void getCheapestV2(String SRC, String DEST, int c, int cost, int k, Map<String, Integer> map){
        if(SRC == DEST){
            if(c-1 <= k){
                if(map.get(DEST) > cost){
                    map.put(DEST, cost);
                }
            }
            return;
        }
        List<Ticket> edges = adjList.get(SRC);
        for(Ticket edge : edges){
            getCheapestV2(edge.DEST, DEST, c+1, cost + edge.price, k, map);
        }
    }

    int getCheapestV2(List<Ticket> tickets, String SRC, String DEST, int k){
        FLightGraph obj = new FLightGraph(tickets);
        Map<String, Integer> map = new HashMap<>();
        map.put(DEST, Integer.MAX_VALUE);
        obj.getCheapestV2(SRC, DEST, 0, 0, k, map);
        return map.get(DEST);
    }
}


class CheapestFlightRoute{

    public static void main(String[] args){
        /*
        [ ('MAA', 'HYD', 150), ('HYD', 'DEL', 400), ('MUM', 'BLR', 200), ('BLR', 'PUN', 80), 
        ('MAA', 'COC', 800), ('HYD', 'MUM', 90), ('MAA', 'BLR', 500), ] 
         */
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("MAA","HYD",150));
        tickets.add(new Ticket("MAA","COC",800));
        tickets.add(new Ticket("MAA","BLR",500));
        tickets.add(new Ticket("HYD","DEL",400));
        tickets.add(new Ticket("HYD","MUM",90));
        tickets.add(new Ticket("MUM","BLR",200));
        tickets.add(new Ticket("BLR","PUN",80));

        FLightGraph fLightGraph = new FLightGraph(tickets);
        System.out.println(fLightGraph.getCheapestV1(4, "MAA", "BLR", 0));

        //System.out.println(fLightGraph.getCheapestV2(tickets, "MAA", "BLR", 4));

    }

}