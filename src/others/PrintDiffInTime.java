package others;

public class PrintDiffInTime {

    public static void main(String[] args){
        testPrintTimeDiff();
    }


    static void testPrintTimeDiff(){
        String str[] = new String[]{
                "23:05:38", "23:05:02", "23:04:59", "23:04:31", "23:05:37", "22:05:38"};
        String res[] = solve(str, "23:05:38");
        for(String s : res){
            System.out.println(s);
        }
    }

    static int getTimeInSec(String str){
        String[] splitted = str.split(":");
        int h = Integer.parseInt(splitted[0]);
        int m = Integer.parseInt(splitted[1]);
        int s = Integer.parseInt(splitted[2]);
        return h*60*60 + m*60 + s;
    }

    static String[] solve(String[] p, String r){
        // Write your code here
        String[] res = new String[p.length];
        int currTimeInSec = getTimeInSec(r);
        //System.out.println(currTimeInSec);
        for(int i=0; i<p.length; i++){
            String time = p[i];
            int pInSec = getTimeInSec(time);
            //System.out.println(pInSec);
            int diff = currTimeInSec - pInSec;
            if(diff == 0){
                res[i] = "now";
            }else if(diff == 1){
                res[i] = "1 second ago";
            }else if(diff < 60){
                res[i] = diff + " seconds ago";
            }else if(diff < 60 * 60){
                int minutes = diff/60;
                if(minutes == 1){
                    res[i] = minutes + " minute ago";
                }else {
                    res[i] = minutes + " minutes ago";
                }
            }else if(diff <= 60 * 60 * 60){
                int hours = (diff/60)/60;
                if(hours == 1){
                    res[i] = hours + " hour ago";
                }else {
                    res[i] = hours + " hours ago";
                }
            }
        }
        return res;
    }

}
