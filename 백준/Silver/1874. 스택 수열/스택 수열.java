import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<Integer>();
		int[] list = new int[N];
		StringBuilder sb = new StringBuilder("");
		int count =0;
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(br.readLine());
			if(count==-1) {
				break;
			}
			while(true) {
				if(st.empty()) {
					sb.append("+");
					st.push(++count);
				}
				else {
					if(st.peek().intValue()>list[i])
					{
						count=-1;
						break;
					}else if(st.peek().intValue()<list[i])
					{
						sb.append("+");
						st.push(++count);
					}
					else if(st.peek().intValue()==list[i])
					{
						sb.append("-");
						st.pop();
						break;
					}
				}
			}
		}
		if(count==-1) {
			System.out.println("NO");
		}
		else {
			char[] temp = sb.toString().toCharArray();
			for(char answer : temp) {
				System.out.println(answer);
			}
		}
	}
}
