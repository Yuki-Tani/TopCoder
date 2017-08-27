// BEGIN CUT HERE
/*
PROBLEM STATEMENT
Zhangzj is the emperor of Yali empire and is esteemed by his people.

"Long live Zhangzj" is heard across the country. Needless to say, people in the empire hope their leader will live forever. However, everybody will die, unless others donate their lives to the person.

In the empire, there's a special way to donate life. There are some fixed words that are called exciting. Whenever someone speaks an exciting word, he automatically donates one second of his life to Zhangzj. For example, "toad" and "river" are exciting. Then, if somebody says the sequence of words "a", "toad", "jumps", "into", "the", "toad", "river", they donate three seconds to Zhangzj.

Given a String[] speech containing all the words someone says, and a String[] words containing all exciting words, return the number of seconds the speaker will donate to Zhangzj.

A word may appear multiple times in speech, but not in words.

DEFINITION
Class:LongLiveZhangzj
Method:donate
Parameters:String[], String[]
Returns:int
Method signature:int donate(String[] speech, String[] words)


CONSTRAINTS
-Both speech and words will contain between 1 and 50 elements, inclusive.
-All pairs of elements in words will be distinct.
-Each element of speech and words will consist only of lowercase English letters.
-The length of each element of speech and words will be between 1 and 50, inclusive.


EXAMPLES

0)
{"make", "topcoder", "great", "again"}
{"make", "america", "great", "again"}

Returns: 3

"make", "great" and "again" appear in speech and are exciting. Thus, the answer is 3.

1)
{"toads"}
{"toad"}

Returns: 0

The strings "toad" and "toads" are not identical, therefore this speaker does not donate any seconds to Zhangzj.

2)
{"a", "a"}
{"a"}

Returns: 2

Two elements of speech can be the same.

3)
{"je", "le", "ai", "deja", "vu", "et", "je", "le", "veux", "encore"}
{"i", "am", "having", "deja", "vu", "please", "stop", "the", "encore"}

Returns: 3



*/
// END CUT HERE
import java.util.*;
public class LongLiveZhangzj {
    public int donate(String[] speech, String[] words) {
        int ans = 0;
        for(int i=0;i<words.length;i++){
        	for(int j=0;j<speech.length;j++){
        		if(speech[j].equals(words[i])){
        			ans ++;
        		}
        	}
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new LongLiveZhangzj()).donate(new String[] {"make", "topcoder", "great", "again"}, new String[] {"make", "america", "great", "again"}),3);
            eq(1,(new LongLiveZhangzj()).donate(new String[] {"toads"}, new String[] {"toad"}),0);
            eq(2,(new LongLiveZhangzj()).donate(new String[] {"a", "a"}, new String[] {"a"}),2);
            eq(3,(new LongLiveZhangzj()).donate(new String[] {"je", "le", "ai", "deja", "vu", "et", "je", "le", "veux", "encore"}, new String[] {"i", "am", "having", "deja", "vu", "please", "stop", "the", "encore"}),3);
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
