	import java.awt.Point;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.*;
	import java.lang.Long;
import java.math.BigInteger;
	
		public class Main 
		{	
			static int[][] map;
			static int count,a;
			static boolean[][] check;
			
			
			@SuppressWarnings("unchecked")
			public static void main(String args[])
			{
				ArrayList<Integer> ar = new ArrayList<Integer>();
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				String s = null;
				try {
					 s = bf.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int num=0;
				a=Integer.parseInt(s);
				map = new int[a][a];
				check = new boolean[a][a]; 
				String[] s1 = null;
				for(int i=0;i<a;i++)
				{
					try {
						s1 = bf.readLine().split("");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int j=0;j<a;j++)
					{
						map[i][j]= Integer.parseInt(s1[j]);
					}
				}
				for(int i=0;i<a;i++)
				{
					for(int j=0;j<a;j++)
					{
						if(map[i][j]!=0&&!check[i][j])
						{
							num++;
							count=0;
							dfs(j,i);
							ar.add(count);
						}
					}
				}
				Collections.sort(ar);
				System.out.println(num);
				for(Integer a : ar)
				{
					System.out.println(a);
				}
				
			}
			static void dfs(int i,int j)
			{
				LinkedList<Point> Q = new LinkedList<Point>();
				Q.offer(new Point(i,j));
				check[j][i]=true;
				while(!Q.isEmpty())
				{
					
					Point P=Q.poll();
					int y=P.y;
					int x=P.x;
					//System.out.println(y+" "+x);
					count++;
					int[] a1= {0,0,1,-1};
					int[] b1= {1,-1,0,0};
					for(int k=0;k<4;k++)
					{
						int ay = y+a1[k];
						int ax = x+b1[k];
						if((0<=ay&&ay<a)&&(0<=ax&&ax<a))
						{
							if(map[ay][ax]!=0&&!check[ay][ax])
							{
								Q.offer(new Point(ax,ay));
								check[ay][ax]=true;
							}
						}
					}
				}
			}
		}
		
			
		