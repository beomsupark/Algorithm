import java.io.*;
import java.util.*;

public class Main{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] board = new int[N];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(br.readLine());
		}
		// 초기 값
		int max = -1;
		int count = 0;
		for (int i = 0; i < k; i++) {
			if (hm.containsKey(board[i])) {
				hm.put(board[i], hm.get(board[i]) + 1);
			} else {
				count++;
				hm.put(board[i], 1);
			}
			
			if(!hm.containsKey(c)) {
				count++;
				max=Math.max(count,max);
				count--;
			}
			else {
				max=Math.max(count,max);
			}
			
		}
		// 진행
		for (int i = 1; i < N; i++) {
			// 이전 값 제거
			if (hm.get(board[i - 1]) == 1) {
				count--;
				hm.remove(board[i - 1]);
			} else {
				hm.put(board[i - 1], hm.get(board[i - 1]) - 1);
			}
			
			if (hm.containsKey(board[(i + k - 1)%N])) {
				hm.put(board[(i + k - 1)%N], hm.get(board[(i + k - 1)%N]) + 1);
			} else {
				count++;
				hm.put(board[(i + k - 1)%N], 1);
			}
			
			if(!hm.containsKey(c)) {
				count++;
				max=Math.max(count,max);
				count--;
			}
			else {
				max=Math.max(count,max);
			}
		}
		
		System.out.println(max);
	}
}
