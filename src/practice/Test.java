package practice;

public class Test {
	public static void main(String[] args){
		System.out.println(1L<<50);
		System.out.println(C(50,25));
	}
	public static long[][] note = new long[100][100];
	public static long C(int i,int j){
		if(j==0 || j==i) return 1;
		if(note[i][j]!=0) return note[i][j];
		note[i][j] = C(i-1,j-1)+C(i-1,j);
		return note[i][j];
	}
}
