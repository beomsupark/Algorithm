import java.io.*;
import java.util.*;
class Hamburger implements Comparable<Hamburger>{
	int taste;
	int cal;
	
	
	public Hamburger(int taste,int cal) {
		this.taste=taste;
		this.cal=cal;
		
	}

	@Override
	public int compareTo(Hamburger o) {
		
		return this.cal-o.cal;
	}
}
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			Hamburger[] list = new Hamburger[N+1];
			int dp[][] = new int[N+1][L+1];
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				list[i]= new Hamburger(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			// dp 테이블을 채우고, 마지막 값 출력
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=L;j++) {
					if(list[i].cal>j) {
						dp[i][j]=dp[i-1][j];
						continue;
					}
					dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-list[i].cal]+list[i].taste);
				}
			}
			System.out.printf("#%d %d\n",test_case,dp[N][L]);
			
		}
		
	}
}
