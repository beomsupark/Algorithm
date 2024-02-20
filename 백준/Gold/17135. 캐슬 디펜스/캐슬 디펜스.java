import java.io.*;
import java.util.*;

class Node {
	int y;
	int x;
	int count;

	public Node(int y, int x, int count) {
		this.y = y;
		this.x = x;
		this.count = count;
	}
}

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] list = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < (1 << m); i++) {
			if (Integer.bitCount(i) == 3) {
				max = Math.max(max, countEnemy(list, i, n, m, d));
			}
		}
		System.out.println(max);
	}

	public static int countEnemy(int[][] list, int position, int n, int m, int d) {

		boolean[][] checks = new boolean[n + 1][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				checks[i][j] = list[i][j] == 1 ? true : false;
			}
		}
		int answer = 0;

		for (int i = n; i > 0; i--) {
			Node[] counts = new Node[3];
			int count = 0;
			int plus = 0;
			for (int j = 0; j < m; j++) {
				if ((position & (1 << j)) > 0) {
					// 거리가 d 이하인 적 중에서 가까운 적 찾기 //아처를 한칸씩 올리기
					counts[count] = killEnemy(checks, i, j, d, m);
					// 없을 경우
					if (counts[count] == null) {
						continue;
					}
					count++;
				}
			}
			for (int t = 0; t < count; t++) {
				checks[counts[t].y][counts[t].x] = false;
			}
			
			plus = count;
			for (int t = 0; t < count; t++) {
				for (int t2 = t + 1; t2 < count; t2++) {
					if (counts[t].y == counts[t2].y&&counts[t].x == counts[t2].x) {
						plus--;
						break;
					}
				}
			}
			answer += plus;
		}
		return answer;
	}

	public static Node killEnemy(boolean[][] list, int y, int x, int d, int m) {
		boolean[][] checks = new boolean[y + 1][m];
		int dy[] = { 0, -1, 0 };
		int dx[] = { -1, 0, 1 };
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(y, x, 0));
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.count > d) {
				return null;
			}
			if (list[temp.y][temp.x] && temp.y != y) {
				return temp;
			}
			for (int i = 0; i < 3; i++) {
				if (temp.x + dx[i] >= 0 && temp.x + dx[i] < m && temp.y + dy[i] >= 0
						&& !checks[temp.y + dy[i]][temp.x + dx[i]]) {
					q.add(new Node(temp.y + dy[i], temp.x + dx[i], temp.count + 1));
					checks[temp.y + dy[i]][temp.x + dx[i]] = true;
				}
			}
		}
		return null;
	}

}
