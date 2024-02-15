import java.io.*;
import java.util.*;

public class Solution {
	static int[][] data;
	static int[][] check;
	static int N;
	static int Min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int list[][] = new int[N + 2][2];
			data = new int[N + 2][N + 2];
			Min = Integer.MAX_VALUE;
			check = new int[N][1 << N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(check[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < 2; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			getDistanceMatrix(N + 2, list);
			dfs(0, 0, 0, 0);
			sb.append(Min + "\n");
		}
		System.out.print(sb);
	}

	public static void dfs(int visited, int depth, int value, int start) {
		if (depth == N) {
			Min = Math.min(Min, value += data[start][1]);
			return;
		}
		for (int next = N - 1; next > -1; next--) {
			if ((visited & (1 << next)) == 0) {
				// System.out.println(start+" " + (next+2));
				value += data[start][2 + next];
				if (value < check[next][visited]) {
					check[next][visited] = value;
					dfs((visited | (1 << next)), depth + 1, value, 2 + next);
				}
				value -= data[start][2 + next];
			}
		}
	}

	public static int getDistance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x2 - x1);
	}

	public static void getDistanceMatrix(int N, int[][] list) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = getDistance(list[i][0], list[i][1], list[j][0], list[j][1]);
				data[i][j] = temp;
				data[j][i] = temp;
			}
		}
	}
}
