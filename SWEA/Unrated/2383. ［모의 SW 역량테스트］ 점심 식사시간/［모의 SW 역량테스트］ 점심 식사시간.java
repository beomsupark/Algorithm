import java.io.*;
import java.util.*;

public class Solution{
	static class human {
		int y;
		int x;

		public human(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int board[][] = new int[N][N];

			ArrayList<human> humanlist = new ArrayList<>();
			ArrayList<human> stail = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {
						humanlist.add(new human(i, j));
					}
					if (board[i][j] >= 2 && board[i][j] <= 10) {
						stail.add(new human(i, j));
					}
				}
			}
			int humanCount = humanlist.size();
			int[][] dist = new int[2][humanCount];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < (1 << humanCount); i++) {
				Arrays.fill(dist[0], -1);
				Arrays.fill(dist[1], -1);
				for (int j = 0; j < humanCount; j++) {
					if ((i & (1 << j)) > 0) {// 첫번째 계단
						dist[0][j] = Math.abs(humanlist.get(j).y - stail.get(0).y)
								+ Math.abs(humanlist.get(j).x - stail.get(0).x);
					} else { // 두번째 계단
						dist[1][j] = Math.abs(humanlist.get(j).y - stail.get(1).y)
								+ Math.abs(humanlist.get(j).x - stail.get(1).x);
					}
				}
				// 첫째 계단 실행
				int count1 = move(dist[0], board[stail.get(0).y][stail.get(0).x]);
				// 둘째 계단 실행
				int count2 = move(dist[1], board[stail.get(1).y][stail.get(1).x]);
				min = Math.min(min, Math.max(count1, count2));
			}
			System.out.println("#" + t + " " + min);
		}
	}
	private static int move(int[] dist, int length) {
		Arrays.sort(dist);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<dist.length;i++) {
			if(dist[i]!=-1) {
				list.add(dist[i]);
			}
		}
		for(int i=0;i<list.size();i++) {
			if(i<=2) {
				list.set(i,list.get(i)+length+1);
			}
			else {
				if(list.get(i)>=list.get(i-3)) {
					list.set(i,list.get(i)+length+1);
				}else {
					list.set(i,list.get(i-3)+length);
				}
			}
		}
		if(list.size()==0) {
			return 0;
		}
		else {
			return list.get(list.size()-1);
		}
		
	}
}
