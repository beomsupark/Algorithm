
import java.util.Stack;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main
{	
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long tree_num;
		long	goal_length;
		long[] list;
		String[] s =bf.readLine().split(" ");
		tree_num = Long.parseLong(s[0]);
		goal_length = Long.parseLong(s[1]);
		list = new long[(int) tree_num];
		s=bf.readLine().split(" ");
		long max =0;
		for(int i=0;i<tree_num;i++)
		{
			list[i]=Long.parseLong(s[i]);
			if(max<list[i])
			{
				max=list[i];
			}
		}
		long bottom =0;
		long top=max;
		while(top>=bottom)
		{
			long mid = (bottom+top)/2;
			long answer=0;
			for(int i=0;i<tree_num;i++)
			{
				if(list[i]>=mid)
				{
					answer+=list[i]-mid;
				}
			}
			
			if(answer>=goal_length)
			{
				bottom=mid+1;
			}
			else
			{
			
				top=mid-1;
			}
		}
		System.out.println(top);
	}
}

