import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i =0; i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long list[][] = new long[n][m];
			for(int j=0;j<m;j++) {
				list[0][j]=j+1;
			}
			for(int j=1;j<n;j++) {
				for(int k=1;k<m;k++) {
					list[j][k]=list[j-1][k-1]+list[j][k-1];
				}
			}
			System.out.println(list[n-1][m-1]);
		}
		
	}
}
