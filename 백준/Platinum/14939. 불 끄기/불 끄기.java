import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		char[][] board = new char[N][N];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < (1 << N); i++) {

			char[][] copy = new char[N][N];

			int answer = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					copy[j][k] = board[j][k];
				}
			}

			for (int j = 0; j < 10; j++) {
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

	private static int run(char[][] copy, int answer) {
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (copy[i - 1][j] == 'O') {
					switchs(i, j, copy);
					answer++;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			if (copy[9][i] == 'O') {
				return -1;
			}
		}
		return answer;

	}

	private static void switchs(int y, int x, char[][] board) {
		int[] dx = { 0, 0, 0, -1, 1 };
		int[] dy = { 0, -1, 1, 0, 0 };

		for (int i = 0; i < 5; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny >= 0 && ny < 10 && nx >= 0 && nx < 10) {
				change(ny, nx, board);
			}
		}
	}

	private static void change(int y, int x, char[][] board) {
		
		if (board[y][x] == 'O') {
			
			board[y][x] = '#';
			
		} else if(board[y][x]=='#'){
			
			board[y][x] = 'O';
		}
	}
}
