import java.io.*;
import java.util.*;

public class Main {
	static class node {
		int y;
		int x;
		int point;
		int jumpcount;

		public node(int y, int x, int point, int jumpcount) {
			this.y = y;
			this.x = x;
			this.point = point;
			this.jumpcount = jumpcount;
		}
	}

	static int K;
	static int W;
	static int H;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		boolean check[][][] = new boolean[K + 1][H][W];
		boolean[][] wall = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					wall[i][j] = true;
				}
			}
		}
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(0, 0, 0, K));
		check[K][0][0] = true;
		int dy[] = { 0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1 };
		int dx[] = { -1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
		int answer = -1;
		while (!queue.isEmpty()) {
			node a = queue.poll();
			if (a.y == H - 1 && a.x == W - 1) {
				answer = a.point;
				break;
			}	
			for (int i = 0; i < 12; i++) {
				int ny = a.y + dy[i];
				int nx = a.x + dx[i];
				if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
					if (check[a.jumpcount][ny][nx] || wall[ny][nx])
						continue;
					if (i < 4) {
						check[a.jumpcount][ny][nx] = true;
						queue.add(new node(ny, nx, a.point + 1, a.jumpcount));
					} else {
						if (a.jumpcount != 0 && !check[a.jumpcount - 1][ny][nx]) {
							check[a.jumpcount - 1][ny][nx] = true;
							queue.add(new node(ny, nx, a.point + 1, a.jumpcount - 1));
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
