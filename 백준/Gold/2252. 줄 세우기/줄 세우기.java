import java.io.*;
import java.util.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		int[] head = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int left=Integer.parseInt(st.nextToken());
			int right=Integer.parseInt(st.nextToken());
			list[left].add(right);
			head[right]++;;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		// 진입 차수 0
		for(int i=1;i<=N;i++) {
			if(head[i]==0) {
				q.add(i);
			}
		}
		// q에 넣고 자식 찾기
		while(!q.isEmpty()) {
			int num = q.poll();
			sb.append(num+" ");
			for(int next: list[num]) {
				if(!check[next]) {
					head[next]--;
					if(head[next]==0) {
						q.add(next);
					}

				}
			}
		}
		
		System.out.println(sb);
	}
}
