import java.io.*;
import java.util.*;

public class Main{
	static int movelist[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		movelist = new int[K + 2];
		movelist[K] = K;
		if (N >= K) {
			System.out.println(N - K);
			for (int i = N; i >= K; i--) {
				System.out.print(i + " ");
			}
		} else {
			bfs(K, N);
			int count = 0;
			Queue<Integer> q = new ArrayDeque<>();
			while (movelist[N] != N) {
				q.add(N);
				N = movelist[N];
				count++;
			}
			q.add(K);
			System.out.println(count);
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
		}

	}

	public static void bfs(int k, int n) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(k);
		while (!q.isEmpty()) {
			int num = q.poll();
			if (num == n) {
				return;
			}
			if (num % 2 == 0 && num > n && movelist[num / 2] == 0) {
				q.add(num / 2);
				movelist[num / 2] = num;
			}
			if (num + 1 < k + 2 && movelist[num + 1] == 0) {
				q.add(num + 1);
				movelist[num + 1] = num;
			}
			if (num - 1 < k + 2 && movelist[num - 1] == 0) {
				q.add(num - 1);
				movelist[num - 1] = num;
			}
		}
	}
}
