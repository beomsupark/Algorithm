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
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[][] list = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			list[left][right]=1;
			list[right][left]=1;
		}
		System.out.print(bfs(list,n+1,start,target));
	}
	public static int bfs(int[][] list,int n,int start,int target) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0,start));
		int[] answer = new int[n+1];
		Arrays.fill(answer, -1);
		answer[start]=0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=1;i<n;i++) {
				if(list[node.num][i]==1&&answer[i]==-1) {
					answer[i]=node.count+1;
					q.add(new Node(node.count+1,i));
				}
			}
		}
		return answer[target];
	}
}
