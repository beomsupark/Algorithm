import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int list[];
	static int max = Integer.MIN_VALUE;
	static boolean[] check;
	static int[] data;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new int[N];
		data = new int[N];
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0);
		System.out.println(max);
	}

	public static void backtracking(int depth) {
		if (depth == N) {
			int sum=0;
			for(int i=0;i<N-1;i++) {
				sum+=(Math.abs(list[data[i]]-list[data[i+1]]));
			}
			max = Math.max(sum,max);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				continue;
			}
			data[depth]=i;
			check[i]=true;
			backtracking(depth+1);
			check[i]=false;
		}

	}
}
