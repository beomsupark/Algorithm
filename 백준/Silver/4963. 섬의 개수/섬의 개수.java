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
	static int[][] board;
	static boolean[][] visited;
	static int[] dy= {-1,1,0,0,-1,1,1,-1};
	static int[] dx= {0,0,-1,1,1,1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			if(M==0&&N==0) {
				break;
			}
			board = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j]==1&&!visited[i][j]) {
						count++;
						dfs(i,j);
//						bfs();
					}
				}
			}
			System.out.println(count);
		}
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		
	}
	private static void dfs(int y, int x) {
		visited[y][x]=true;
		Stack<node> stack = new Stack<>();
		stack.push(new node(y,x));
		while(!stack.isEmpty()) {
			node temp = stack.pop();
			for(int i=0;i<8;i++) {
				if(temp.x+dx[i]>=0&&temp.x+dx[i]<M&&temp.y+dy[i]>=0&&temp.y+dy[i]<N
						&& !visited[temp.y+dy[i]][temp.x+dx[i]]&&board[temp.y+dy[i]][temp.x+dx[i]]==1) {
					visited[temp.y+dy[i]][temp.x+dx[i]]=true;
					stack.push(new node(temp.y+dy[i],temp.x+dx[i]));
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
}
