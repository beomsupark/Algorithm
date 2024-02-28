import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					visited[i][j] = true;
				}
			}
		}
		int[][][] board = new int[3][N + 1][N + 1];// 오른쪽, 대각선, 아래로
		board[0][1][2] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == 1 && j == 2) {
					continue;
				}
				// 오른쪽 계산
				if (!visited[i][j]) {
					board[0][i][j] = board[0][i][j - 1] + board[1][i][j-1];
				}
				// 대각선 계산
				if (!visited[i][j] && !visited[i][j - 1] && !visited[i - 1][j]) {
					board[1][i][j] = board[0][i - 1][j - 1] + board[1][i - 1][j - 1] + board[2][i - 1][j - 1];
				}
				// 아래로 계산
				if (!visited[i][j]) {
					board[2][i][j] = board[1][i - 1][j] + board[2][i - 1][j];
				}
			}
		}
		System.out.println(board[0][N][N] + board[1][N][N] + board[2][N][N]);
	}
}
