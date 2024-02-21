import java.io.*;
import java.util.*;
public class Main{
	static boolean visited[];
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		list = new ArrayList[N];
		visited= new boolean[N];
		for(int i=0;i<N;i++) {
			list[i]= new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int left= Integer.parseInt(st.nextToken()); 
			int right= Integer.parseInt(st.nextToken()); 
			list[left].add(right);
			list[right].add(left);
		}
		boolean check =false;
		for(int i=0;i<N;i++) {
			if(backtracking(0,i)) {
				check=true;
				break;
			}
		}
		if(check) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	public static boolean backtracking(int depth, int num) {
		if(depth==5) {
			return true;
		}
		boolean check= false;
		for(int next: list[num]) {
			if(visited[next]) continue;
			visited[next]=true;
			check= check||backtracking(depth+1,next);
			visited[next]=false;
		}
		return check;
	}
}
