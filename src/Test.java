import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



public class Test {

    public static void main(String[] args){
        int sum = 0;
        for(int i=1; i<=19; i++){
            System.out.println(i + ", " + (i+1) + " - " + (i ^ (i+1)));
            sum = sum + (i ^ (i+1));
        }
        System.out.println(sum);

        sum = 0;
        for(int i=1; i<=10; i++){
            System.out.println(i + ", " + (20-i+1) + " - " + (i ^ (20-i-1)));
            sum = sum + i ^ (20-i+1);
        }
        System.out.println(sum);

        System.out.println();
        int[] nums = new int[]{10, 5, 6, 9, 20, 8};
        Arrays.sort(nums);
        sum = 0;
        for(int i=0; i<nums.length-1; i=i+2){
            sum = sum + (nums[i] ^ nums[i+1]);
            System.out.println(nums[i] + ", " +  nums[i+1] + " - " + (nums[i] ^ nums[i+1]));
        }

        System.out.println(sum);
        sum = 0;
        for(int i=0; i<nums.length/2; i++){
            sum = sum + (nums[i] ^ nums[nums.length - i - 1]);
            System.out.println(nums[i] + ", " +  nums[nums.length - i - 1] + " - " + (nums[i] ^ nums[nums.length - i - 1]));
        }
        System.out.println(sum);


        Set<Integer> set = new HashSet<>();




    }



    static void test4(){
        String s = "true";
        Boolean val = Boolean.parseBoolean(s);
        System.out.println(val);
        s = "TRUE";
        val = Boolean.parseBoolean(s);
        System.out.println(val);
        s = "mahesh";
        val = Boolean.parseBoolean(s);
        System.out.println(val);
        s = "False";
        val = Boolean.parseBoolean(s);
        System.out.println(val);

        System.out.println("true".equalsIgnoreCase("TrUe"));
    }


    static void test3(){
        for(int i=0; i<100;i++){
            System.out.println("creating thread - " + (i+1));
            new ThreadClass().start();
        }
    }

    static void test2() {

        try {
            BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(2);
            bQueue.put("Java");
            System.out.println("Item 1 inserted into BlockingQueue");
            bQueue.put("JDK");
            System.out.println("Item 2 is inserted on BlockingQueue");
            bQueue.put("J2SE");
            bQueue.offer("J2SE");
            bQueue.add("J2SE");
            System.out.println("Done");
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    static void test1(){
        int result = 0;

        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRuE");
        Boolean b4 = new Boolean("false");

        if (b1 == b2)result = 1;
        if (b1.equals(b2))result = result + 10;
        if (b2 == b4)result = result + 100;
        if (b2.equals(b4))result = result + 1000;
        if (b2.equals(b3))result = result + 10000;
        System.out.println(result);
    }

}

class Singleton{
    private static  Singleton INSTANCE;

    private Singleton(){
        System.out.println("Creating singleton object");
    }

    public static Singleton getINSTANCE(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}

class ThreadClass extends Thread{
    public void run(){
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Singleton obj = Singleton.getINSTANCE();
    }
}















/*
class Parent
{
    int a=100;
    public void display()
    {
        System.out.println("Display in parent A: "+a);
    }
}

class Child extends Parent
{
    int b=200;

    public void display()
    {
        System.out.println("Display in parent B: "+b);
    }
}

public class Test
{
    public static void main(String args[])
    {
        Parent obj = new Child();
        obj.display();
    }
}*/



/*

public class Test
{
    public static void mythrow()
    {
        System.out.print("L0 ");
        throw new RuntimeException();
    }
    public static void main(String [] args)
    {
        try
        {
            System.out.print("L1 ");
            mythrow();
        }
        catch(Exception e)
        {
            System.out.print("L2 ");
        }
        finally
        {
            System.out.print("L3 ");
        }
        System.out.println("L4 ");
    }
}


*/



/*class Test
{
    public static void main(String [] args)
    {
        int x = 0x80000000;
        System.out.print(x + " and ");
        x = x >>> 31;
        System.out.println(x);
    }
}*/


/*

public class Test
{
    Test()
    {
        System.out.print("out");
    }

    class Inner
    {
        Inner()
        {
            System.out.print("in");
        }
        public void go()
        {
            System.out.print("go_in");
        }
    }

    public static void main (String [] args)
    {
        Test obj = new Test();
        obj.fun();
    }
    void fun()
    {
        (new Inner() {}).go();
    }
}*/

/*
public class Test{
    public void foo( boolean a, boolean b)
    {
        if( a )
        {
            System.out.println("A");
        }
        else if(a && b)
        {
            System.out.println( "A && B");
        }
        else
        {
            if ( !b )
            {
                System.out.println( "notB") ;
            }
            else
            {
                System.out.println( "ELSE" ) ;
            }
        }
    }
*/
/*

    private int [3] a [ ];
    static int [ ] b;
    public [ ] int c;
    private int d [3];
    public int e [ ];
    public final int [ ] f = new int[]{};
*//*

*/
/*
public void test(int x)
{
    int odd = 1;
    if(odd)
    {
        System.out.println("odd");
    }
    else
    {
        System.out.println("even");

    }
}*//*


    public static void main (String [] args)
    {
        Test obj = new Test();
        obj.foo(true, true);
        obj.foo(true, false);
        obj.foo(false, true);
        obj.foo(false, false);




    }


}
*/



/*



public class Test
{
    public static void main (String[] args)
    {
        method();
    }
    public static int method()
    {
        try
        {
            System.out.println("try");
            int x =33/0;
            System.out.println(11);
            return 11;
        }
        catch(Exception e)
        {
            System.out.println("catch");
            System.out.println(17);
            return 17;
        }
        finally
        {
            System.out.println("finally");
            System.out.println(88);
            return 88;
        }
    }
}
*/




/*class MyClass
{
    public static void main (String[] args)
    {
        int A1[] = {1, 2, 3};
        int A2[] = {1, 2, 3};
        if (A1.equals(A2))
            System.out.println("Same");
        else
            System.out.println("Not same");
    }
}*/

/*

class Test extends Thread
{
    final StringBuffer str1 = new StringBuffer();
    final StringBuffer str2 = new StringBuffer();

    public static void main(String args[])
    {
        final Test obj = new Test();

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    obj.str1.append("1");
                    obj.str2.append("A");
                    System.out.println(obj.str1);
                    System.out.println(obj.str2);
                }
            }
        }.start();

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    obj.str1.append("2");
                    obj.str2.append("B");
                    System.out.println(obj.str2);
                    System.out.println(obj.str1);
                }
            }
        }.start();
    }
}
*/


/*

class Source
{
    public static void main(String arg[])
    {
        String __$1____str="These Variables!";
        String $s=__$1___str;
        int a=31,b=a++;
        int @q=12;
        if ($s=="These Variables")
            System.out.println("True");
        else
            System.out.println("False");
    }
}*/




/*
import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        // Let us create a list of strings
        List<String>  list = new ArrayList<String>();
        list.add("DoSelect");
        list.add("InMobi");
        list.add("CampusHash");
        list.add("mKhoj");
        list.add("Microsoft");

        System.out.println("Original: " + list);

        Collections.rotate(list, -2);

        System.out.println("Rotated: " + list);
    }
}*/

/*

class Source
{
    public static void main(String args[])
    {
        double a = 354.03;
        int  b = 256;
        byte c = (byte) a;
        byte d = (byte) b;
        System.out.println(c + "\t"  + d);
    }
}*/
