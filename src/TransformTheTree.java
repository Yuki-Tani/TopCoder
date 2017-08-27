// BEGIN CUT HERE
/*
PROBLEM STATEMENT

	You have a tree consisting of N nodes. The nodes are conveniently numbered 0 through N-1. You are given an int[] parents that consists of N-1 elements. For each 1 ? i < N, the parent of node i is node parents[i-1].



	Your goal is to transform the tree into a path. In order to accomplish that you are allowed to use the following operation multiple times:
	
		Choose an edge {u, v}.
		Remove the edge {u, v} obtaining two trees T1 and T2 in this way -- T1 containing u and T2 containing v.
		Choose any node w from T1 and any node z from T2.
		Add the edge {w, z}.
	



	Return the minimum number of operations needed to transform the given tree into a path.


DEFINITION
Class:TransformTheTree
Method:countCuts
Parameters:int[]
Returns:int
Method signature:int countCuts(int[] parents)


CONSTRAINTS
-N will be between 1 and 50, inclusive.
-parents will contain exactly N ? 1 elements.
-For each i, parents[i] will be between 0 and i, inclusive.


EXAMPLES

0)
{0, 0, 1, 2, 1}

Returns: 1

Initially, the tree contains the following edges: 0-1, 0-2, 1-3, 2-4, and 1-5.
This tree is not a path, but we can change it into a path in a single operation.
One optimal solution looks as follows:
Remove the edge 1-5.
This produces two trees: T1 is a path on five vertices and T2 is a single isolated vertex.
Then, add the edge 4-5.
Doing so produces the path 3-1-0-2-4-5.

1)
{0, 0, 0, 0, 0, 0}

Returns: 4

One optimal sequence of operations looks as follows:

	 Cut the edge 0-3, add the edge 2-3.
	 Cut the edge 0-2, add the edge 1-2.
	 Cut the edge 0-6, add the edge 5-6.
	 Cut the edge 0-5, add the edge 4-5.

After applying these operations the resulting tree is 3-2-1-0-4-5-6.

2)
{0, 0, 1, 2, 3, 4, 5, 6}

Returns: 0

The given tree is already a path.

3)
{}

Returns: 0



4)
{0, 1, 2, 3, 2, 5, 0, 7, 8, 9, 8, 11}

Returns: 2

The following provides the minimum number of operations:

	 Cut the edge 2-5, add the edge 6-10.
	 Cut the edge 8-9, add the edge 5-12.


5)
{0, 1, 2, 0, 4, 5, 6, 4, 5, 6, 0, 11, 12}

Returns: 2



*/
// END CUT HERE
import java.util.*;
public class TransformTheTree {
    public int countCuts(int[] parents) {
    	int N = parents.length+1;
        int[] dim = new int[N];
        boolean[][] edge = new boolean[N][N];
        for(int i=1;i<=parents.length;i++){
        	dim[i]++;
        	dim[parents[i-1]]++;
        	edge[i][parents[i-1]] = true;
        	edge[parents[i-1]][i] = true;
        }
        int[] pow = new int[N];
        boolean[][] powEdge = new boolean[N][N];
        
       	for(int i=0;i<N;i++){
       		if(dim[i]>=3){
       			for(int j=0;j<N;j++){
       				if(edge[i][j] && dim[j]>=3){
       					pow[i]++;
       					powEdge[i][j] = true;
       				}
       			}
       		}
        }
       	int ans = 0;
       	for(int k=0;k<N;k++){
       		for(int i=0;i<N;i++){
       			if(dim[i]>=3){
       				if(pow[i]==0){
       					ans += dim[i] - 2;
       					dim[i] = 2;
       				}else if(pow[i]==1){
       					ans += dim[i] - 2;
       					dim[i] = 2;
       					for(int j=0;j<N;j++){
       						if(powEdge[i][j]){
       							dim[j] --;
       							pow[j] --;
       							powEdge[j][i] = false;
       						}
       					}
       				}
       			}
       		}
       	}
       	return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TransformTheTree()).countCuts(new int[] {0, 0, 1, 2, 1}),1);
            eq(1,(new TransformTheTree()).countCuts(new int[] {0, 0, 0, 0, 0, 0}),4);
            eq(2,(new TransformTheTree()).countCuts(new int[] {0, 0, 1, 2, 3, 4, 5, 6}),0);
            eq(3,(new TransformTheTree()).countCuts(new int[] {}),0);
            eq(4,(new TransformTheTree()).countCuts(new int[] {0, 1, 2, 3, 2, 5, 0, 7, 8, 9, 8, 11}),2);
            eq(5,(new TransformTheTree()).countCuts(new int[] {0, 1, 2, 0, 4, 5, 6, 4, 5, 6, 0, 11, 12}),2);
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
