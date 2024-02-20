import java.io.*;
import java.util.*;
class node{
	int y;
	int x;
	public node(int y, int x) {
		this.y=y;
		this.x=x;
	}
}
public class Main{
	static int N;
	static int M;
	static int[][] list;
	static int[][] answer;
	static int num_cheese;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		answer = new int[N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(answer[i],-1);
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				list[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 처음 공기 채우기
		fillBubble();
		// 빌때까지 공기 넣기
		int count=0;
		int num_cheese=0;
		while(true) {
			
			if(check()) {
				break;
			}
			num_cheese = find();	
			bfs(count++);
			
			
		}
		System.out.println(count);
		System.out.println(num_cheese);
	}
	private static int find() {
		int temp =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(answer[i][j]<0&&list[i][j]==1) {
					temp++;
				}
			}
		}
		return temp;
	}
	private static boolean check() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(answer[i][j]<0) {
					if(list[i][j]!=0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static void fillBubble() {
		int[] dy= {1,-1,0,0};
		int[] dx= {0,0,1,-1};
		Queue<node> q = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i==0||j==0||i==N-1||j==M-1) {
					q.add(new node(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			node temp = q.poll();
			answer[temp.y][temp.x]=0;
			for(int i=0;i<4;i++) {
				if(temp.y+dy[i]>=0&&temp.y+dy[i]<N&&temp.x+dx[i]>=0&&temp.x+dx[i]<M&&
						answer[temp.y+dy[i]][temp.x+dx[i]]==-1&&list[temp.y+dy[i]][temp.x+dx[i]]==0) {
					q.add(new node(temp.y+dy[i],temp.x+dx[i]));
					answer[temp.y+dy[i]][temp.x+dx[i]]=0;
				}
			}
		}
		
	}
	public static void bfs(int num) {
		int[] dy= {1,-1,0,0};
		int[] dx= {0,0,1,-1};
		Queue<node> q = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(answer[i][j]==num&&list[i][j]==0) {
					q.add(new node(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			node temp = q.poll();
			for(int i=0;i<4;i++) {
				if(temp.y+dy[i]>=0&&temp.y+dy[i]<N&&temp.x+dx[i]>=0&&temp.x+dx[i]<M&&
						answer[temp.y+dy[i]][temp.x+dx[i]]==-1) {
					if(list[temp.y+dy[i]][temp.x+dx[i]]==0) {
						q.add(new node(temp.y+dy[i],temp.x+dx[i]));
					}
					answer[temp.y+dy[i]][temp.x+dx[i]]=num+1;
					list[temp.y+dy[i]][temp.x+dx[i]]=0;
					
				}
			}
		}
	}
}
