import java.io.*;
import java.util.*;
public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1)==Math.abs(o2)) {
				return o1-o2;
			}
			return Math.abs(o1)-Math.abs(o2);
		});
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i =0; i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			if(input==0) {
				if(queue.isEmpty()) {
					sb.append("0 \n");
				}
				else {
					sb.append(queue.poll()+" \n");
				}
				continue;
			}
			queue.add(input);
		}
		System.out.println(sb);
	}
}
