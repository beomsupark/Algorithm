	import java.awt.Point;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.*;
	import java.lang.Long;
import java.math.BigInteger;
	
		public class Main 
		{	
			static int a,b;
			@SuppressWarnings("unchecked")
			public static void main(String args[])
			{
				LinkedList<Integer> D = new LinkedList<Integer>();
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				String[] s = null;
				try {
					s = bf.readLine().split(" ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a= Integer.parseInt(s[0]);
				b= Integer.parseInt(s[1]);
				int[] ca = new int[b];
				for(int i=0;i<a;i++)
				{
					D.addLast(i+1);
				}
				try {
					s=bf.readLine().split(" ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<b;i++)
				{
					ca[i]= Integer.parseInt(s[i]);
				}
					/*D.addFirst(D.pollLast());//오른쪽
				
					D.addLast(D.pollFirst());//왼쪽*/
				int count=0;
				for(int i=0;i<b;i++)
				{
					while(D.peekFirst()!=ca[i])
					{
						//System.out.println((D.indexOf(ca[i])+1)+" "+(D.size()-D.indexOf(ca[i])));
						//System.out.println(D);
						if(D.indexOf(ca[i])+1<=(D.size()-D.indexOf(ca[i])))
						{
							D.addLast(D.pollFirst());
							count++;
						}
						else
						{
							D.addFirst(D.pollLast());
							count++;
						}
						
					}
					D.pollFirst();
				}
				System.out.println(count);
				
			}
		}
		
			
		