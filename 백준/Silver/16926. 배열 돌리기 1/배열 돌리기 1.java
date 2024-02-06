import java.io.*;
import java.util.*;
public class Main{
	static int[][] list;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				list[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<(Math.min(N,M))/2;i++) {
			rotate(i,R%((2*N)+(2*M)-4-(8*i)));
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(list[i][j]+" ");
			}
			System.out.println();
		}
	}	
	public static void rotate(int i, int plus) {
		Queue<Integer> q = new LinkedList<Integer>();
		int x = i;
		int y = i;
		int direction = 0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		// 제일 왼쪽 위의 위치가 도달하는 위치 찾기
		for(int index=0;index<plus;index++) {
			q.add(list[y][x]);
			if(x+dx[direction]>=M-i||y+dy[direction]>=N-i||x+dx[direction]<i||y+dy[direction]<i) {
				direction= (direction+1)%4;
			}
			x+=dx[direction];
			y+=dy[direction];
		}
		// 해당 위치부터 쌓기
		for(int index=0;index<((2*N)+(2*M)-4-(8*i));index++) {
			q.add(list[y][x]);
			list[y][x]=q.poll();
			if(x+dx[direction]>=M-i||y+dy[direction]>=N-i||x+dx[direction]<i||y+dy[direction]<i) {
				direction= (direction+1)%4;
			}
			x+=dx[direction];
			y+=dy[direction];
		}
		// 종료
	}
	
}
