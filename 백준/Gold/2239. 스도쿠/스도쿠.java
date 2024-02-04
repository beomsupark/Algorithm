import java.util.*;
import java.io.*;

public class Main{
	static int[][] list;
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				list[i][j] = s.charAt(j) - '0';
			}
		}
		batchSudoku(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d", list[i][j]);
			}
			System.out.println();
		}
	}

	private static void batchSudoku(int depth) {
		if (depth == 81) {
			check = true;
			//System.out.println("끝");
			return;
		}
		int i = depth / 9;
		int j = depth % 9;

		if (list[i][j] != 0) {
			batchSudoku(depth + 1);
		} else {
			for (int k = 1; k <= 9; k++) {
				if (possibleBatch(i, j, k)) {
					list[i][j] = k;
					batchSudoku(depth + 1);
					if (check) {
						return;
					}
					list[i][j] = 0;
				}
			}
			//System.out.println(i + " " + j + " " + depth);
		}
	}

	private static boolean possibleBatch(int i, int j, int k) {
		for (int t = 0; t < 9; t++) {
			if (list[i][t] == k || list[t][j] == k) {
				return false;
			}
			int n = (i / 3) * 3;
			int m = (j / 3) * 3;
			for (int t1 = n; t1 < n + 3; t1++) {
				for (int t2 = m; t2 < m + 3; t2++) {
					if (list[t1][t2] == k) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
