// BEGIN CUT HERE
/*
PROBLEM STATEMENT

You have certainly seen many tasks that start with some ridiculous made-up story. 
Well, this one is nothing like that.



Ivan A. is a smart boy.
He just got a sequence of nonnegative integers as a birthday present.
You are given this sequence in the int[] X.



Ivan A. adores the number 5.
He thinks that a sequence is pretty if the product of all its elements ends with the digit 5.
He now wants to change X into a pretty sequence.
In each step he can choose an element of X and replace one of its digits by any other digit.
For example, in a single step Ivan A. can change the number 1234 into the number 1734.



Compute and return the minimal number of steps needed to change X into a pretty sequence.


DEFINITION
Class:ILike5
Method:transformTheSequence
Parameters:int[]
Returns:int
Method signature:int transformTheSequence(int[] X)


NOTES
-It can be shown that any sequence X can be transformed into a pretty sequence in finitely many steps.
-It is allowed to change the leading digit of a number into a zero, but this is never needed in the optimal solution.


CONSTRAINTS
-X will contain between 1 and 50 numbers, inclusive.
-Each element of X will be between 0 and 10^6, inclusive.


EXAMPLES

0)
{5, 2, 8, 12}

Returns: 3

One optimal solution looks as follows:

Ivan A. changes the 2 to a 1.
Ivan A. changes the 8 to a 9.
Ivan A. changes the last digit of the number 12 from 2 to 9.

After these three steps he will have the sequence {5, 1, 9, 19}.
The product of its elements is 5 * 1 * 9 * 19 = 855, so this sequence is pretty.

1)
{1555}

Returns: 0

The number already ends in a 5.

2)
{0, 10, 100, 1000, 10000}

Returns: 5

Clearly, Ivan A. must change the last digit in each of these numbers, otherwise the product would end in a 0.
One optimal solution is to change this sequence into {7, 13, 105, 1005, 10003}.

3)
{1, 2, 2, 3, 3, 3, 4, 4, 4, 4}

Returns: 6



4)
{7890, 4861, 65773, 3769, 4638, 46000, 548254, 36185, 115}

Returns: 4



*/
// END CUT HERE

public class ILike5 {
    public int transformTheSequence(int[] X) {
        int even = 0;
        int five = 0;
        for(int i=0;i<X.length;i++){
        	if(X[i]%2==0) even ++;
        	if(X[i]%10==5) five ++;
        }
        if(even>0) return even;
        else if(five>0) return 0;
        else return 1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ILike5()).transformTheSequence(new int[] {5, 2, 8, 12}),3);
            eq(1,(new ILike5()).transformTheSequence(new int[] {1555}),0);
            eq(2,(new ILike5()).transformTheSequence(new int[] {0, 10, 100, 1000, 10000}),5);
            eq(3,(new ILike5()).transformTheSequence(new int[] {1, 2, 2, 3, 3, 3, 4, 4, 4, 4}),6);
            eq(4,(new ILike5()).transformTheSequence(new int[] {7890, 4861, 65773, 3769, 4638, 46000, 548254, 36185, 115}),4);
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
