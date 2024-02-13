		
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
	
		class A implements Comparable<A>
		{
			int a;
			int b;
			public A(int a,int b)
			{
				this.a=a;
				this.b=b;
			}
			@Override
			public int compareTo(A target)
			{
				if(this.b>target.b)
				{
					return 1;
				}
				else if(this.b<target.b)
				{
					return -1;
				}
				else
				{
					if(this.a>=target.a)
					{
						return 1;
					}
					else
					{
						return-1;
					}
				}
			}
		}
		public class Main
		{	
			public static void main(String[] args) throws IOException
			{
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String[] s = br.readLine().split(" ");
				int N = Integer.parseInt(s[0]);
				PriorityQueue<A> pq = new PriorityQueue<A>();
				for(int i=0;i<N;i++)
				{
					s = br.readLine().split(" ");
					pq.add(new A(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
				}	
				int last = Integer.MIN_VALUE;
				int count =0;
				for(int i=0;i<N;i++)
				{
					A aa = pq.poll();
					if(aa.a>=last)
					{
						count ++;
						last = aa.b;
					}
				}
				System.out.println(count);
			}
		}
