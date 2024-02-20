import java.io.*;
import java.util.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		int[] head = new int[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			//System.out.println(num);
			int[] list2= new int[num];
			
			for(int j=0;j<num;j++) {
				list2[j]=Integer.parseInt(st.nextToken());
			}
			
			for(int j=0;j<num-1;j++) {
				list[list2[j]].add(list2[j+1]);
				head[list2[j+1]]++;
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		// 진입 차수 0
		for(int i=1;i<=N;i++) {
			if(head[i]==0) {
				q.add(i);
				check[i]=true;
			}
		}
		// q에 넣고 자식 찾기
		while(!q.isEmpty()) {
			int num = q.poll();
			sb.append(num+"\n");
			for(int next: list[num]) {
				if(!check[next]) {
					head[next]--;
					if(head[next]==0) {
						q.add(next);
						check[next]=true;
					}

				}
			}
		}
		boolean count = true;
		for(int i=1;i<=N;i++) {
			if(!check[i]) {
				count=false;
				break;
			}
		}
		if(count) {
			System.out.println(sb);
		}else {
			System.out.println(0);
		}
		
	}
}
