import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

	public class Main 
	{	
		static boolean check[];
		static int[][] map;
		static int a,b,c,d;
		public static void main(String args[])
		{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			try {
				String s[] = bf.readLine().split(" ");
				a = Integer.parseInt(s[0]);
				map = new int[a][a];
				check = new boolean[a];
				s=bf.readLine().split(" ");
				b = Integer.parseInt(s[0]);
				for(int i=0;i<b;i++)
				{
					s= bf.readLine().split(" ");
					c=Integer.parseInt(s[0]);
					d=Integer.parseInt(s[1]);
					map[c-1][d-1]=map[d-1][c-1]=1;
				}
				/*for(int i=0;i<a;i++)
				{
					for(int j=0;j<a;j++)
					{
						System.out.print(map[i][j]+" ");
					}
					System.out.println();
				}*/
				System.out.print(DFS());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static int DFS()
		{
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(1);
			int i1 =-1;
			while(!q.isEmpty())
			{
				int k= q.poll();
				if(check[k-1]==true)
				{
					continue;
				}
				else
				{
					i1++;
					check[k-1]=true;
					for(int i=0;i<a;i++)
					{
						if(map[k-1][i]==1&&!check[i])
						{
							q.offer(i+1);
						}
					}
				}
			}
			return i1;
		}
	}
	