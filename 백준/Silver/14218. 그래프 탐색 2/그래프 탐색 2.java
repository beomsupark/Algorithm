import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
	int count;
	int num;
	public Node(int count, int num) {
		this.count=count;
		this.num=num;
	}
}
public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] list = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right =Integer.parseInt(st.nextToken());
			list[left][right]=1;
			list[right][left]=1;
		}
		int add = Integer.parseInt(br.readLine());
		for(int i=0;i<add;i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right =Integer.parseInt(st.nextToken());
			list[left][right]=1;
			list[right][left]=1;
			for(int num : bfs(list,n+1)) {
				sb.append(num+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static int[] bfs(int[][] list,int n) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0,1));
		int[] answer = new int[n+1];
		Arrays.fill(answer, -1);
		answer[1]=0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=1;i<n;i++) {
				if(list[node.num][i]==1&&answer[i]==-1) {
					answer[i]=node.count+1;
					q.add(new Node(node.count+1,i));
				}
			}
		}
		return Arrays.copyOfRange(answer, 1, n);
	}
}
