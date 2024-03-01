import java.io.*;
import java.util.*;

public class Main{
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dist = new int[(1 << 10)];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[101][101];
		
		int N = Integer.parseInt(br.readLine());
		curve(10);
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d =Integer.parseInt(st.nextToken());
			int g =Integer.parseInt(st.nextToken());
			board[y][x]=1;
			for(int j=0;j<(1<<g);j++) {
				y=y+dy[(dist[j]+d)%4];
				x=x+dx[(dist[j]+d)%4];
				if(y>=0&&y<=100&&x>=0&&x<=100) {
					board[y][x]=1;
				}
			}
		}
//		for(int i=0;i<=100;i++) {
//			
//			for(int j=0;j<=100;j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		int[] dy1 = {0,1,0,1};
		int[] dx1 = {0,0,1,1};
		int answer =0;
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				int count =0;
				for(int t=0;t<4;t++) {
					int ny=i+dy1[t];
					int nx=j+dx1[t];
					if(ny>=0&&ny<=100&&nx>=0&&nx<=100&&board[ny][nx]==1) {
						count++;
					}
				}
				if(count==4) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static void curve(int depth) {
		if (depth == 0) {
			dist[0] = 0;
			return;
		}
		int last = (1 << depth);
		int mid = last / 2;
		curve(depth - 1);
		for (int i = mid; i < last; i++) {
			dist[i] = (dist[last - 1 - i] + 1) % 4;
		}
	}
}
