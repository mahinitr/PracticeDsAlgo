import java.util.HashMap;
import java.util.Map;
/*

public class Test {

    public static void main(String[] args){
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
*/


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



import java.util.*;
/*

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
}