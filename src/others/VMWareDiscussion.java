package others;

import java.util.*;

class ImmutableClass{

    private final int id;
    private final String name;

    ImmutableClass(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return id + " - " + name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}




/*

Two threads - t1 - prints odd, t2 - prints even
1,2,3,4,5,6,7,8,9

 */


class EvenOddThreadClass extends Thread{

    int n;
    boolean odd;
    //static Boolean odd = true;

    EvenOddThreadClass(int n, boolean odd){
        this.n = n;
        this.odd = odd;
    }

    public void run(){
        int start = 2;
        if(odd){
            start = 1;
        }
        for(int i = start; i <= n; i=i+2) {

            System.out.println(i);
        }

        for(int i = 1; i <= n; i=i+1) {
            if(odd){
                System.out.println(i);

            }else{
                System.out.println(i);

            }

        }

    }

}


class OddThreadClass extends Thread{

    int n;

    OddThreadClass(int n){
        this.n = n;
    }

    public void run(){
        for(int i = 1; i <= n; i=i+2) {
            try {
                sleep(1);
                System.out.println(i);
            }catch(InterruptedException e){

            }
        }
    }

}

class EvenThreadClass extends Thread{

    int n;

    EvenThreadClass(int n){
        this.n = n;
    }

    public void run(){
        for(int i = 2; i <= n; i=i+2) {
            try {
                sleep(1);
                System.out.println(i);
            }catch(InterruptedException e){

            }
        }
    }

}



class SingltonClass{

    int id;
    static SingltonClass obj;

    private SingltonClass(){

    }

    public synchronized static SingltonClass getInstance(){
        if(obj == null) {
            obj = new SingltonClass();
        }
        return obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



/*

sequence of brackets - {[()]}, {[()}]


{ - }
( - )
[ - ]

stack -   {, [, (
{
[
(
) - pop from stack ( - check if they related...
stack -   {, [
] - pop from stack [ - check if they related...
stack -   {
} - pop from stack { - check if they related...
stack -

if stack is empty, return true
else false,

 */



/*
stream of data...
First 2bytes - file name
next 2bytes - length of file
file contents

md5 -> file_name

md51->f1, f3
md52->f2, f5
md53->f4, f6


 */




public class VMWareDiscussion {

    public static void main(String[] args){
       /* ImmutableClass obj = new ImmutableClass(1, "Mahesh");
        System.out.println(obj.getId());

        int n = 10;
        EvenOddThreadClass oddT = new EvenOddThreadClass(n, true);
        oddT.start();
        try {
            Thread.sleep(5);
        }catch(InterruptedException e){

        }
        EvenOddThreadClass evenT = new EvenOddThreadClass(n, false);
        evenT.start();*/

        SingltonClass obj = SingltonClass.getInstance();
        obj.setId(10);
        System.out.println(obj.getId());

    }

}



class TestClass{

    /*public void print(List<Integer> list){

    }*/

    public void print(List<String> list){

    }

}




