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
	static char[][] data;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new char[N][N];
		for(int i=0;i<N;i++) {
			data[i]=br.readLine().toCharArray();
		}
		System.out.printf("%d %d",dfs(),bfs_js());
	}
	public static int dfs() {
		int[] dy= {-1,1,0,0};
		int[] dx= {0,0,-1,1};
		boolean[][] check = new boolean[N][N];
		Stack<node> st = new Stack<>();
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					count++;
					st.push(new node(i,j));
					check[i][j]=true;
					while(!st.isEmpty()) {
						node temp = st.pop();
						for(int t=0;t<4;t++) {
							if(temp.x+dx[t]>=0&&temp.x+dx[t]<N&&temp.y+dy[t]>=0&&temp.y+dy[t]<N&&
									!check[temp.y+dy[t]][temp.x+dx[t]]&&data[i][j]==data[temp.y+dy[t]][temp.x+dx[t]]) {
								check[temp.y+dy[t]][temp.x+dx[t]]=true;
								st.push(new node(temp.y+dy[t],temp.x+dx[t]));
							}
						}
					}
				}
			}
		}

		
		return count;
		
	}
	public static int bfs_js() {
		int[] dy= {-1,1,0,0};
		int[] dx= {0,0,-1,1};
		boolean[][] check = new boolean[N][N];
		Queue<node> q = new ArrayDeque<>();
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					count++;
					q.add(new node(i,j));
					check[i][j]=true;
					while(!q.isEmpty()) {
						node temp = q.poll();
						for(int t=0;t<4;t++) {
							if(temp.x+dx[t]>=0&&temp.x+dx[t]<N&&temp.y+dy[t]>=0&&temp.y+dy[t]<N&&!check[temp.y+dy[t]][temp.x+dx[t]]) {
								if(data[i][j]=='R'||data[i][j]=='G') {
									if(data[temp.y+dy[t]][temp.x+dx[t]]=='R'||data[temp.y+dy[t]][temp.x+dx[t]]=='G') {
										check[temp.y+dy[t]][temp.x+dx[t]]=true;
										q.add(new node(temp.y+dy[t],temp.x+dx[t]));
									}
								}
								else {
									if(data[i][j]==data[temp.y+dy[t]][temp.x+dx[t]]) {
										check[temp.y+dy[t]][temp.x+dx[t]]=true;
										q.add(new node(temp.y+dy[t],temp.x+dx[t]));
									}
								}
								
							}
						}
					}
				}
			}
		}

		
		return count;
		
	}
}
