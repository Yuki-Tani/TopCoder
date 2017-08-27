// BEGIN CUT HERE
/*
PROBLEM STATEMENT
LYC and owaski are pet dogs of Zhangzj. They like playing on a tree.

The tree has N vertices, indexed from 0 to (N - 1). On each edge of the tree, there is a number between 0 and 1,023, inclusive. LYC will choose a path on the tree, calculate the bitwise xor of the numbers on the edges of the path.
(The bitwise xor of zero numbers is 0. This applies if the path has no edges.)
Then, LYC will erase all edges of the path.
This will divide the tree into several connected components, each of which will be a tree again.

Once LYC is done, Owaski will choose one of those components.
Then, he will choose a path in that component and calculate the bitwise xor of the numbers on its edges.

Finally, the two dogs will share the values they computed with each other, and together they will compute one final number F: the bitwise xor of their two numbers. Their goal is to work together to maximize the value of F. You are given int[]s parent and w of (N - 1) elements. For each valid i, there is an edge connecting the (i + 1)-th vertex and the parent[i], and the number on the edge is w[i].

Compute and return the largest possible value of the final number F.

DEFINITION
Class:TwoDogsOnATree
Method:maximalXorSum
Parameters:int[], int[]
Returns:int
Method signature:int maximalXorSum(int[] parent, int[] w)


CONSTRAINTS
-N will be between 1 and 1,000, inclusive.
-Both parent and w will contain exactly (N - 1) elements.
-For each valid i, parent[i] will be between 0 and i, inclusive.
-For each valid i, w[i] will be between 0 and 1,023, inclusive.


EXAMPLES

0)
{0, 0, 0, 0}
{1, 2, 4, 8}

Returns: 15

The tree contains 5 vertices and 4 edges. LYC can choose the path 1 &rarr 0 &rarr 2, and Owaski can choose the path 3 &rarr 0 &rarr 4. LYC's number will be 1 xor 2 = 3. Owaski's number will be 4 xor 8 = 12. The answer will be 3 xor 12 = 15.

1)
{0, 1, 2, 3, 4, 5, 6, 7, 8}
{3, 2, 6, 5, 8, 1, 3, 4, 3}

Returns: 15

The tree forms a chain of 10 vertices and 9 edges. LYC can choose the whole chain, and Owaski can choose a path containing a single vertex. The number LYC gets will be 15, and because Owaski's path contains no edges, the number will be 0. Therefore the answer will be 15 xor 0 = 15.

2)
{0, 0, 2, 2, 4, 4, 5, 6}
{13, 16, 12, 11, 3, 1, 4, 2}

Returns: 31

LYC can choose the path 4 &rarr 6 &rarr 8, and Owaski can choose the path 0 &rarr 2 &rarr 3. 

3)
{0, 0, 2, 0, 1, 2, 2, 4, 6, 1, 5}
{628, 589, 815, 864, 459, 507, 733, 239, 904, 592, 818}

Returns: 1017



4)
{}
{}

Returns: 0



*/
// END CUT HERE
import java.util.*;
public class TwoDogsOnATree {
    public int maximalXorSum(int[] parent, int[] w) {
        return 0;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TwoDogsOnATree()).maximalXorSum(new int[] {0, 0, 0, 0}, new int[] {1, 2, 4, 8}),15);
            eq(1,(new TwoDogsOnATree()).maximalXorSum(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, new int[] {3, 2, 6, 5, 8, 1, 3, 4, 3}),15);
            eq(2,(new TwoDogsOnATree()).maximalXorSum(new int[] {0, 0, 2, 2, 4, 4, 5, 6}, new int[] {13, 16, 12, 11, 3, 1, 4, 2}),31);
            eq(3,(new TwoDogsOnATree()).maximalXorSum(new int[] {0, 0, 2, 0, 1, 2, 2, 4, 6, 1, 5}, new int[] {628, 589, 815, 864, 459, 507, 733, 239, 904, 592, 818}),1017);
            eq(4,(new TwoDogsOnATree()).maximalXorSum(new int[] {}, new int[] {}),0);
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
