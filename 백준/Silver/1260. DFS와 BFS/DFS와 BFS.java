	import java.awt.Point;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.*;
	
		public class Main 
		{	static boolean[] check1;
			static boolean[] check2;
			static int[][] map;
			static int a,b,c,d;
			public static void main(String args[])
			{
				Queue q = new LinkedList();
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				try {
					String s[] = bf.readLine().split(" ");
					a = Integer.parseInt(s[0]);
					b = Integer.parseInt(s[1]);
					c = Integer.parseInt(s[2]);
					check1=new boolean[a];
					check2=new boolean[a];
					map= new int[a][a];
					for(int i=0;i<b;i++)
					{
					s=bf.readLine().split(" ");
					int t=Integer.parseInt(s[0]);
					int k=Integer.parseInt(s[1]);
					map[t-1][k-1]=map[k-1][t-1]=1;
					}
					/*for(int i=0;i<a;i++)
					{
						for(int j=0;j<a;j++)
						{
							System.out.print(map[i][j]+" ");
						}
						System.out.println();
					}*/
					DFS(c);
					System.out.println();
					BFS(c);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		static void DFS(int f)
		{
			Stack s = new Stack();
			s.add(f);
			check1[f-1]=true;
			System.out.print(f+" ");
			while(!s.isEmpty())
			{
				
				int v=(int) s.peek();
				//System.out.println("check:"+v);
				boolean check= false;
				for(int i=0;i<a;i++)
				{
					/*System.out.println("map:"+map[v-1][i]);
					System.out.println("check1:"+check1[i]);*/
					if(map[v-1][i]==1&&!check1[i])
					{
						
						s.add(i+1);
						System.out.print((i+1)+" ");
						check1[i]=true;
						check=true;
						break;
					}
				}
				if(!check)
				{
					s.pop();
				}
			}
		}
		static void BFS(int f)
		{
			Queue q = new LinkedList();
			q.offer(f);
			while(!q.isEmpty())
			{
				
				int q1=(int) q.poll();
				if(check2[q1-1])
				{
					continue;
				}
				check2[q1-1]=true;
				System.out.print(q1+" ");
				for(int i=0;i<a;i++)
				{
					if(map[q1-1][i]==1&&!check2[i])
					{
						q.offer(i+1);
					}
				}
			}
		}
	}
		