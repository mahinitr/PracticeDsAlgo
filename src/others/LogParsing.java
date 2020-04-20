package others;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class IpCode{
    String ip;
    int code;
    IpCode(String ip, int code){
        this.ip = ip;
        this.code = code;
    }
}

public class LogParsing {

    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    static private IpCode extractCode(String log){
        String ip = log.split(" - - ")[0];
        String codeStr = log.split("HTTP/1.1\" ")[1].split(" ")[0];
        int code = 0;
        try{
            code = Integer.parseInt(codeStr);
        }catch(Exception e){

        }
        return new IpCode(ip, code);
    }

    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> ips = new HashMap<>();
        while(scanner.hasNext()){
            String log = scanner.nextLine();
            IpCode res = extractCode(log);
            if(res.code >= 400){
                Integer count = ips.get(res.ip);
                if(count == null){
                    count = 0;
                }
                ips.put(res.ip, count + 1);
            }
        }
        ips = sortByValue(ips);
        for(Map.Entry<String, Integer> aa : ips.entrySet()){
            System.out.print(aa.getKey() + " " + aa.getValue());
        }
    }
}