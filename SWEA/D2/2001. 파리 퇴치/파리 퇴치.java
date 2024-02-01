import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N =Integer.parseInt(st.nextToken());
			int M =Integer.parseInt(st.nextToken());
			int[][] data = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					data[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int[] line = new int[N-M+1];
			int sum=0;
			for(int i=0;i<M;i++) {
				for(int j=0;j<M;j++) {
					sum+=data[i][j];
				}
			}
			line[0]=sum;
			int max = sum;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					if(j==0) {
						if(i==0) {
							//System.out.println(sum);
							continue;
						}
						sum=line[i-1];
						for(int k=0;k<M;k++) {
							sum+=data[i+M-1][k];
							sum-=data[i-1][k];
						}
						line[i]=sum;
						
					}
					else {
						for(int k=0;k<M;k++) {
							sum+=data[i+k][j+M-1];
							//System.out.print(data[i+k][j+M-1]+" ");
							sum-=data[i+k][j-1];
							//System.out.print(data[i+k][j-1]+" ");
						}
						//System.out.println(sum);
					}
					//System.out.println(i+" "+j+" "+sum);
					max = Math.max(max, sum);
				}
				
			}
			System.out.printf("#%d %d\n", test_case,max);
		}
	}
}
