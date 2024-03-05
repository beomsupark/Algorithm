import java.io.*;
import java.util.*;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < (1 << N); i++) {

			int[][] copy = new int[N][N];

			int answer = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					copy[j][k] = board[j][k];
				}
			}

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					switchs(0, j, copy);
					answer++;
				}
			}
			// 나머지 변경
			int currentmin = run(copy, answer);

			if (currentmin != -1) {
				min = Math.min(min, currentmin);
			}

		}

		if (min == Integer.MAX_VALUE) {
			System.out.print(-1);
		} else {
			System.out.print(min);
		}
	}

	private static int run(int[][] copy, int answer) {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i - 1][j] == 1) {
					switchs(i, j, copy);
					answer++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (copy[N-1][i] == 1) {
				return -1;
			}
		}
		return answer;

	}

	private static void switchs(int y, int x, int[][] board) {
		int[] dx = { 0, 0, 0, -1, 1 };
		int[] dy = { 0, -1, 1, 0, 0 };

		for (int i = 0; i < 5; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				change(ny, nx, board);
			}
		}
	}

	private static void change(int y, int x, int[][] board) {

		if (board[y][x] == 1) {

			board[y][x] = 0;

		} else if (board[y][x] == 0) {

			board[y][x] = 1;
		}
	}
}
