import java.io.*;
import java.util.*;

public class Solution {
	static int[][] data;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			data = new int[N][N];
			snail(N);
			System.out.printf("#%d\n",test_case);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(data[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		
	}
	
	private static void snail(int n) {
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		int y=0;
		int x=0;
		int dir =0;
		for(int i=1;i<=n*n;i++) {
			data[y][x]=i;
			if(y+dy[dir]>=0&&y+dy[dir]<n&&x+dx[dir]>=0&&x+dx[dir]<n&&data[y+dy[dir]][x+dx[dir]]==0) {
			}
			else {
				dir = (dir +1)%4;
			}
			y+=dy[dir];
			x+=dx[dir];
		}
	}
}
