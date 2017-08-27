package practice;

public class AkariDaisukiDiv2 {
	public static int countTuples(String S){
		int ans = 0;
		for (int i = 1; i <S.length() ; i++) {
			for(int w=1;w<S.length();w++){
				for(int j=i+w+1;j+w<S.length();j++){
					boolean ok=true;
					for(int k=0;k<w;k++){
						if(S.charAt(i+k)!=S.charAt(j+k)) ok = false;
					}
					if(ok) ans++;
				}
			}
		}
		return ans;
	}
}
