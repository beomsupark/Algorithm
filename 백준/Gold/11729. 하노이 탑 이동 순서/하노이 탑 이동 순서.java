import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;
public class Main
	{
		static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)
	{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int n =Integer.parseInt(bf.readLine());
			int k=1;
			for(int i=0;i<n;i++)
			{
				k=k*2;
			}
			System.out.println(k-1);
			hanoi(n,"1","2","3");
			bw.append(sb);
			bw.flush();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
	public static void hanoi(int n,String a, String b, String c)
	{
		if(n==1)
		{	
			sb.append(a +" "+ c +"\n");
			return;
		}
		hanoi(n-1,a,c,b);
		sb.append(a +" "+ c +"\n");
		hanoi(n-1,b,a,c);
		return;	
	}
	}


