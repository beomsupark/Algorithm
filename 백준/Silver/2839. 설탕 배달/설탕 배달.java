import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main
	{
	public static void main(String[] args)
	{
		 	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 	try {
		 		String[] s = bf.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int a_5 = a/5;
				int b;
				int answer=-1;
				for(int i =a_5;i>=0;i--)
				{
					b=a-((i)*5);
					if(b%3==0)
					{
						answer = i + b/3;
						break;
					}
				}
				bw.write(Integer.toString(answer));
				bw.flush();
				bw.close();
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}