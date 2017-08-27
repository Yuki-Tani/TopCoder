// BEGIN CUT HERE
/*
PROBLEM STATEMENT
There is a card and at the beginning there is a number s on it, in each step you can do one of this operation:

Suppose the number on this card is x, change it into 2x+1.
Suppose the number on this card is x, change it into 3x+1.

Please compute and return the minimal number of operations to change the number of your card into t. If that is impossible, return -1.

DEFINITION
Class:MultiplyXPlusOne
Method:minimalSteps
Parameters:int, int
Returns:int
Method signature:int minimalSteps(int s, int t)


CONSTRAINTS
-s will be between 0 and 1,000,000, inclusive.
-t will be between 0 and 1,000,000, inclusive.


EXAMPLES

0)
1
22

Returns: 3

First we use operation 1, the number will become 2*1+1 = 3.
Then we use operation 1 again, we get 3*2+1 = 7.
Last we use operation 2, it will be 7*3+1 = 22.

1)
1
31

Returns: 3

Although we can get it by 1, 3, 7, 15, 31, we could use less steps by 1, 3, 10, 31.

2)
100
99

Returns: -1

We can't decrease the number, so it is impossible to get 99 from 100.

3)
55555
1000000

Returns: 3



4)
1
1

Returns: 0



*/
// END CUT HERE

public class MultiplyXPlusOne {
    public int minimalSteps(int s, int t) {
        if(s==t) return 0;
        if(s>t) return -1;
        int case1 = minimalSteps(2*s+1,t);
        int case2 = minimalSteps(3*s+1,t);
        if(case1==-1){
        	if(case2==-1){
        		return -1;
        	}else{
        		return case2 + 1;
        	}
        }else{
        	if(case2==-1){
        		return case1 + 1;
        	}else{
        		return Math.min(case1, case2) + 1;
        	}
        }
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new MultiplyXPlusOne()).minimalSteps(1, 22),3);
            eq(1,(new MultiplyXPlusOne()).minimalSteps(1, 31),3);
            eq(2,(new MultiplyXPlusOne()).minimalSteps(100, 99),-1);
            eq(3,(new MultiplyXPlusOne()).minimalSteps(55555, 1000000),3);
            eq(4,(new MultiplyXPlusOne()).minimalSteps(1, 1),0);
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
