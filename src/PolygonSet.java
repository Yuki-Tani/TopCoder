// BEGIN CUT HERE
/*
PROBLEM STATEMENT
We call a set X good if:

|X| >= 3.
There exist a postive area polygon such that each side has a different length, and the set of lengths of sides is X.

You are given a set S, return the number of subsets that is good.

DEFINITION
Class:PolygonSet
Method:count
Parameters:int[]
Returns:long
Method signature:long count(int[] S)


CONSTRAINTS
-S will contain between 3 and 50 elements, inclusive.
-Each number in S will be between 1 and 100, inclusive.
-Numbers in S will be distinct.


EXAMPLES

0)
{1,2,3,4}

Returns: 2

We have 2 good sets: {2,3,4} and {1,2,3,4}. Note that {1,2,3} is not good since the triangle will have an area equals to 0.

1)
{90,91,92,93,94,95,96,97,98,99}

Returns: 968

Any subset with size at least 3 is good, so we have 2^10 - 1 - 10 - 10*9/2 = 968 good sets.

2)
{2,5,8,7,4,3,9,1,6}

Returns: 402



3)
{11,12,13,14,15,91,92,93,94,95}

Returns: 838



4)
{1,2,3,4,5,6,7,8,9,100}

Returns: 402



*/
// END CUT HERE
import java.util.*;
public class PolygonSet {
    public long count(int[] S) {
    	 long[] box = new long[5001];
         box[0] = 1;
         Arrays.sort(S);
         long ans = 0;
         for(int i=0;i<S.length;i++){
         	for(int j=S[i]+1;j<box.length;j++){
         		ans += box[j];
         	}
         	for(int j=box.length-1;j>=S[i];j--){
         		box[j] += box[j-S[i]];
         	}
         }
         return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
    	int[] test = new int[50];
    	Arrays.fill(test,1);
    	System.out.println(new PolygonSet().count(test));
        try {
            eq(0,(new PolygonSet()).count(new int[] {1,2,3,4}),2L);
            eq(1,(new PolygonSet()).count(new int[] {90,91,92,93,94,95,96,97,98,99}),968L);
            eq(2,(new PolygonSet()).count(new int[] {2,5,8,7,4,3,9,1,6}),402L);
            eq(3,(new PolygonSet()).count(new int[] {11,12,13,14,15,91,92,93,94,95}),838L);
            eq(4,(new PolygonSet()).count(new int[] {1,2,3,4,5,6,7,8,9,100}),402L);
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
