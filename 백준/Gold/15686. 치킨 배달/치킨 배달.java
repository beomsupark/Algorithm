
import java.io.*;
import java.util.*;

class node {
	int y;
	int x;
	int count;

	public node(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public node(int y, int x, int count) {
		this.y = y;
		this.x = x;
		this.count = count;
	}
}

public class Main{
	static int N;
	static int M;
	static ArrayList<node> q;
	static ArrayList<node> start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] list = new int[N][N];
		q = new ArrayList<>();
		start = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if (list[i][j] == 2) {
					q.add(new node(i, j));
				} else if (list[i][j] == 1) {
					start.add(new node(i, j));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < (1 << q.size()); i++) {
			if (Integer.bitCount(i) == M) {
				min = Math.min(min, bfs(i, list, q.size()));
			}
		}
		System.out.println(min);
	}

	public static int bfs(int visited, int[][] list, int n) {

		int answer = 0;
		for (node home : start) {
			answer += bfs(home, list,visited,n);
		}


		return answer;
	}

	private static int bfs(node home, int[][] list,int visited,int n) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if((visited&(1<<i))>0) {
				min = Math.min(min, Math.abs(home.y-q.get(i).y)+Math.abs(home.x-q.get(i).x));
			}
		}
		return min;
	}

}
