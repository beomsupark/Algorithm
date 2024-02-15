import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{

	static int[][] arr = new int[9][9];
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] aMove = new int[M];
			int[] bMove = new int[M];
			int[] aps[] = new int[A][4];
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					aps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int current_aX = 1;
			int current_aY = 1;
			int current_bX = 10;
			int current_bY = 10;
			int[] dx = { 0, 0, 1, 0, -1 };
			int[] dy = { 0, -1, 0, 1, 0 };
			// 0일때
			ArrayList<Integer> aaps = new ArrayList<>();
			ArrayList<Integer> baps = new ArrayList<>();
			for (int j = 0; j < A; j++) {
				if (Math.abs(current_aY - aps[j][1]) + Math.abs(current_aX - aps[j][0]) <= aps[j][2]) {
					aaps.add(j);
				}
				if (Math.abs(current_bY - aps[j][1]) + Math.abs(current_bX - aps[j][0]) <= aps[j][2]) {
					baps.add(j);
				}
			}
			int max = 0;
			if (aaps.isEmpty() && baps.isEmpty()) {
				
			} else if (aaps.isEmpty()) {
				for (int b : baps) {
					max = Math.max(max, aps[b][3]);
				}
			} else if (baps.isEmpty()) {
				for (int a : aaps) {
					max = Math.max(max, aps[a][3]);
				}
			} else {
				for (int a : aaps) {
					for (int b : baps) {
						if (a == b) {
							max = Math.max(max, aps[a][3]);
						} else {
							max = Math.max(max, aps[a][3] + aps[b][3]);
						}
					}
				}
			}
			answer += max;
			// 0 이후
			for (int i = 0; i < M; i++) {
				current_aX += dx[aMove[i]];
				current_aY += dy[aMove[i]];
				current_bX += dx[bMove[i]];
				current_bY += dy[bMove[i]];

				aaps = new ArrayList<>();
				baps = new ArrayList<>();
				for (int j = 0; j < A; j++) {
					if (Math.abs(current_aY - aps[j][1]) + Math.abs(current_aX - aps[j][0]) <= aps[j][2]) {
						aaps.add(j);
					}
					if (Math.abs(current_bY - aps[j][1]) + Math.abs(current_bX - aps[j][0]) <= aps[j][2]) {
						baps.add(j);
					}
				}
				max = 0;
				if (aaps.isEmpty() && baps.isEmpty()) {
					continue;
				} else if (aaps.isEmpty()) {
					for (int b : baps) {
						max = Math.max(max, aps[b][3]);
					}
				} else if (baps.isEmpty()) {
					for (int a : aaps) {
						max = Math.max(max, aps[a][3]);
					}
				} else {
					for (int a : aaps) {
						for (int b : baps) {
							if (a == b) {
								max = Math.max(max, aps[a][3]);
							} else {
								max = Math.max(max, aps[a][3] + aps[b][3]);
							}
						}
					}
				}
				answer += max;
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}