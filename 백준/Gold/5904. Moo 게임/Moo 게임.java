import java.io.*;
import java.util.*;
public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char answer = divide(N);
		System.out.println(answer);
	}

	private static char divide(int n) {
		int before=0;
		int temp=0;
		int count=3;
		while(n>=temp) {
			before=temp;
			temp=temp*2+(count++);
		}
		count--;
		//System.out.println(temp);
		//System.out.println(before+" "+count+" ");
		if(n<=before+(count)) {
			if(n-before==1) {
				return 'm';
			}
			else {
				return 'o';
			}
		}
		//System.out.println("devide"+(n-before-count) );
		return divide(n-before-count);
	}
}
