// BEGIN CUT HERE
/*
PROBLEM STATEMENT
LYC is the pet dog of Emperor Zhangzj of Yali Empire. Zhangzj has a huge affluence. Besides his palace, he has multiple estates. One of them is the Long Mansion, a famous site in Yali. LYC loves to play. One day, he accidentally enters the labyrinthine Long Mansion.

The mansion can be seen as a grid of N rows, indexed from 0 to (N - 1) from up to down, and M columns, indexed from 0 to (M - 1) from left to right. Initially, LYC is standing on the cell in the top left corner.
The exit is in the bottom right corner.
In other words, LYC wants to travel from row 0 and column 0 to row (N - 1) and column (M - 1).
LYC can walk from one cell directly to another if and only if they share a side.
He wants to reach the exit as soon as possible..

Unfortunately, each cell contains some obstacles that slow LYC down. For each cell we know the time LYC needs to spend there while passing through the cell. LYC also needs to spend that amount of time in the initial cell and in the exit cell as well. There is a pattern to the obstacles: each column of the mansion looks the same. In other words, all cells within any given row contain the same obstacle type, and therefore they delay LYC by the same amount of time. For example, the entire first row are some bushes, the entire second row contains some walls, and so on. You are given the times in the int[] t. More precisely, LYC will spend t[i] time in each cell he visits in row i.

You are given one int M, and one int[] t. Return the minimal time LYC needs to spend to reach the exit.

DEFINITION
Class:LongMansionDiv2
Method:minimalTime
Parameters:int, int[]
Returns:long
Method signature:long minimalTime(int M, int[] t)


CONSTRAINTS
-N will be between 1 and 50, inclusive.
-M will be between 1 and 1,000,000,000, inclusive.
-t will contain exactly N elements.
-Each element of t will be between 1 and 1,000, inclusive.


EXAMPLES

0)
3
{1, 2, 1}

Returns: 6

LYC's path can be (0, 0) &rarr (0, 1) &rarr (1, 1) &rarr (2, 1) &rarr (2, 2). The time he spends will be 1 + 1 + 2 + 1 + 1 = 6. Note that the first and last cell count as well.

1)
4
{3, 2, 4, 2}

Returns: 17

This time, LYC's path can be (0, 0) &rarr (1, 0) &rarr (1, 1) &rarr (1, 2) &rarr (2, 2) &rarr (3, 2) &rarr (3, 3).

2)
5
{3, 2, 5, 4, 2, 8}

Returns: 32



3)
1000000000
{1000}

Returns: 1000000000000

Watch out for overflow.

4)
1
{1}

Returns: 1



*/
// END CUT HERE
import java.util.*;
public class LongMansionDiv2 {
    public long minimalTime(int M, int[] t) {
        Arrays.sort(t);
        long ans = 0;
        for(int i=0;i<t.length;i++){
        	if(i==0){
        		ans += ((long)t[i]) * M;
        	}else{
        		ans += t[i];
        	}
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new LongMansionDiv2()).minimalTime(3, new int[] {1, 2, 1}),6L);
            eq(1,(new LongMansionDiv2()).minimalTime(4, new int[] {3, 2, 4, 2}),17L);
            eq(2,(new LongMansionDiv2()).minimalTime(5, new int[] {3, 2, 5, 4, 2, 8}),32L);
            eq(3,(new LongMansionDiv2()).minimalTime(1000000000, new int[] {1000}),1000000000000L);
            eq(4,(new LongMansionDiv2()).minimalTime(1, new int[] {1}),1L);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
