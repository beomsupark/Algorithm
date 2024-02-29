import java.io.*;
import java.util.*;

public class Solution{

	static class core {
		int y;
		int x;

		public core(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[][] board;
	static int N;
	static int coreMax = 0;
	static int lineMin = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			coreMax = 0;
			lineMin = Integer.MAX_VALUE;
			board = new int[N][N];
			ArrayList<core> coreList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {
						if (i != 0 && j != 0) {
							coreList.add(new core(i, j));
						}
					}
				}
			}
			backtracking(coreList, 0, 0, 0);
			System.out.println("#"+t+" "+lineMin);
		}
	}

	public static void backtracking(ArrayList<core> coreList, int depth, int Corecount, int lineCount) {
		int dy[] = { -1, 1, 0, 0 };
		int dx[] = { 0, 0, -1, 1 };
		if (depth == coreList.size()) {
			if (Corecount > coreMax) {
				coreMax = Corecount;
				lineMin = lineCount;
			} else if (Corecount == coreMax) {
				lineMin = Math.min(lineMin, lineCount);
			}
			return;
		}
		// 각 코어 내방향
		core current = coreList.get(depth);
		for (int i = 0; i < 4; i++) {
			if (canfill(current.y, current.x, dy[i], dx[i])) {
				int linei = createLine(current.y, current.x, dy[i], dx[i], 1);
				backtracking(coreList, depth + 1, Corecount + 1, lineCount + linei);
				createLine(current.y, current.x, dy[i], dx[i], 0);
			}
		}
		backtracking(coreList, depth + 1, Corecount, lineCount);
	}

	public static boolean canfill(int y, int x, int dy, int dx) {
		y += dy;
		x += dx;
		while (isPossible(y, x)) {
			if (board[y][x] == 1) {
				return false;
			}
			y += dy;
			x += dx;
		}
		return true;
	}

	public static int createLine(int y, int x, int dy, int dx, int num) {
		int count = 0;
		y += dy;
		x += dx;
		while (isPossible(y, x)) {
			board[y][x] = num;
			y += dy;
			x += dx;
			count++;
		}
		return count;
	}

	public static boolean isPossible(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		}
		return false;
	}
}
