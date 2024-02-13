import java.io.*;
import java.util.*;

public class Main{
	static int[] array;
	static int K;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N];
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i]=new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			tree[parent].add(child);
		}
		ArrayList<Integer> header = new ArrayList<>();
		header.add(0);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		System.out.print(calApple(0,header));
	}
	
	public static int calApple(int depth, ArrayList<Integer> list) {
		//System.out.println(list);
		if(depth>K||list.isEmpty()) {
			return 0;
		}
		int sum=0;
		for(int num : list) {
			sum+=array[num];
		}
		//System.out.println(sum);
		ArrayList<Integer> nextList = new ArrayList<>();
		for(int num : list) {
			for(int child : tree[num]) {
				nextList.add(child);
			}
		}
		
		return sum + calApple(depth+1,nextList);
	}
}
