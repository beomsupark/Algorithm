import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K =Integer.parseInt(st.nextToken());
			int[] list = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(list);
			int count =0;
			int listcount=0;
			boolean check = true;
			for(int i=0;i<=list[N-1];i++) {
				if(i!=0 && i%M==0) {
					count+=K;
				}
				if(i==list[listcount]) {
					count--;
					listcount++;
				}
				if(count<0) {
					check=false;
					break;
				}
			}
			if(check) {
				System.out.printf("#%d Possible\n",t);
			}
			else {
				System.out.printf("#%d Impossible\n",t);
			}
		}
	}
}
