		
		import java.util.Stack;
		import java.awt.Point;
		import java.io.BufferedReader;
		import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
		import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
		import java.util.Scanner;
	
		
		public class Main
		{	
			static int[] parents;
			public static int union_find(int a)
			{
				if(parents[a]==a) return a;
				
				return parents[a]=union_find(parents[a]);
			}
			public static void union(int A,int B)
			{
				if(A==B) return;
				if(A<B)
				{
				parents[B]=A;
				}
				else
				{
				parents[A]=B;
				}
			}
			public static void main(String[] args) throws IOException
			{
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String[] s = br.readLine().split(" ");
				int N = Integer.parseInt(s[0]);
				s = br.readLine().split(" ");
				int M = Integer.parseInt(s[0]);
				parents = new int[N+1];
				for(int i=1;i<=N;i++)
				{
					parents[i]=i;
				}
				for(int i=1;i<=N;i++)
				{
					s = br.readLine().split(" ");
					for(int j=0;j<N;j++)
					{
						if(Integer.parseInt(s[j])==1)
						{
							int A=union_find(i);
							int B=union_find(j+1);
							union(A,B);
						}
					}
				}
				s=br.readLine().split(" ");
				int[] list = new int[M];
				boolean answer = true;
				int root=0;
				for(int i=0;i<M;i++)
				{
					list[i]=Integer.parseInt(s[i]);
					if(i==0)
					{
						root=parents[list[0]];
					}
					else
					{
						if(parents[list[i]]!=root)
						{
							answer=false;
							break;
						}
					}
				}
				if(answer)
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
