
/*
Rate limit requests from users, not more than 10 per sec.


fun(String id){
    if limit is crossed, return true // limit  = 10, 11
    else false, limit = <=10.
}

(t1, t2, t3, (t4, t5.... t10, t11), t12, t13, t14), .... t20

[], [], [], [], []

Map<secid, count> map


1: 5req -> 5 credit, 10->5
 2: 10req -> 5 cred, 15->5
 3: 0 req -> 15cred , 15->15
5: 0 req -> 25cred , 25->25
6: 20 req -> 15 cred , 35->15
max credits = 50




 */


import com.sun.tools.corba.se.idl.ExceptionEntry;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RateLimitter {

    int rateLimitSize;
    Map<Long, Integer> bucketCount;
    long lastSec;
    int maxSize;

    RateLimitter(int rateLimitSize, int maxSize){
        this.rateLimitSize = rateLimitSize;
        this.bucketCount  = new HashMap<>();
        this.lastSec = 0;
        this.maxSize = maxSize;
    }

    boolean isRateLimitted(){
        Calendar calendar = Calendar.getInstance();
        calendar.clear(Calendar.MILLISECOND);
        long sec = calendar.getTimeInMillis()/1000;
        Integer cnt = bucketCount.get(sec);
        if(cnt == null){
            if(lastSec == 0){
                lastSec = sec - 1;
            }
            cnt = bucketCount.get(lastSec);
            if(cnt == null){
                cnt = 0;
            }
            int diff = (int)(sec - lastSec);
            cnt = cnt + (rateLimitSize * diff);
            if(cnt > maxSize){
                cnt = maxSize;
            }
            System.out.println(sec + " - " + cnt);
            bucketCount.put(sec, cnt);
        }
        lastSec = sec;
        bucketCount.put(sec, --cnt);
        return cnt < 0;
    }

}


class BackendSystem{

    static final int size = 10;
    static final int maxSize = 50;
    Map<String, RateLimitter> map;

    BackendSystem(){
        map = new HashMap<>();
    }

    boolean serve(String id){
        RateLimitter rateLimitter = map.get(id);
        if(rateLimitter == null){
            rateLimitter = new RateLimitter(size, maxSize);
            map.put(id, rateLimitter);
        }
        if(rateLimitter.isRateLimitted()){
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String[] args){

        BackendSystem system = new BackendSystem();
        try {
            System.out.println("started");
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            Thread.sleep(1100);
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            Thread.sleep(1100);
            Thread.sleep(1100);
            Thread.sleep(1100);
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            System.out.println(system.serve("1"));
            Thread.sleep(1100);
            System.out.println(system.serve("1"));
            System.out.println("ended");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}