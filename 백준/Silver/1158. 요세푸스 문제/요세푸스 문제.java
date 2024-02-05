import java.io.*;
import java.util.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("<");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		int count=1;
		while(q.size()!=1) {
			if(count==K) {
				sb.append(q.poll()+", ");
				count=1;
				continue;
			}
			q.add(q.poll());
			count++;
		}
		sb.append(q.poll()+">");
		System.out.println(sb);
	}
}
