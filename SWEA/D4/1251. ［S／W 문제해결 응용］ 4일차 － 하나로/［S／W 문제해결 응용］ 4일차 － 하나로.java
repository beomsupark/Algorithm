import java.io.*;
import java.util.*;

public class Solution {
	static class edge implements Comparable<edge>{
		int start;
		int to;
		double weight;
		public edge(int start, int to, double weight) {
			this.start = start;
			this.to=to;
			this.weight=weight;
		}
		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight,o.weight);
		}
		
	}
	
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			parents=new int[N];
			int[] islandX = new int[N];
			int[] islandY = new int[N];
			for (int i = 0; i < N; i++) {
				parents[i]=i;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islandX[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islandY[i]=Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			PriorityQueue<edge> queue = new PriorityQueue<edge>();
			for(int i=0;i<N;i++) {
				
				for(int j=0;j<N;j++) {
					if (i == j) continue;
					double x1 = Math.pow(islandX[i]-islandX[j], 2);
					double y1 = Math.pow(islandY[i]-islandY[j], 2);
					double weight = E*(x1+y1);
					queue.add(new edge(i,j,weight));
				}
			}
			double answer=0;
			while(!queue.isEmpty()) {
				edge e = queue.poll();
				if(find(e.start)==find(e.to)) continue;
				union(e.start,e.to);
				answer+=e.weight;
			}
			System.out.println("#"+t+" "+Math.round(answer));
		}
	}
	
	private static void union(int a, int b) {
		a= find(a);
		b= find(b);
		if(a>=b) parents[a]=b;
		else parents[b]=a;
		
	}
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a]=find(parents[a]);
	}

}
