import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static char[] list_dest;
	static int count = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] list = br.readLine().toCharArray();
		char[] list_2 = list.clone();
		list_dest = br.readLine().toCharArray();
		changeList(list_2,0);
		if(!switchList(list,0)&&!switchList(list_2,1)) {
			System.out.println("-1");
		}
		else {
			System.out.println(count);
		}
		
		
		
	}
	public static boolean switchList(char[] list, int num) {
		for(int i=1;i<N;i++) {
			if(list[i-1]!=list_dest[i-1]) {
				changeList(list,i);
				num++;
			}
		}
		if(list[N-1]==list_dest[N-1]) {
			count = Math.min(count,num);
			return true;
		}
		return false;
	}
	public static void changeList(char[] list,int num) {
		int[] dnum = { -1, 0, 1 };
		for (int i = 0; i < 3; i++) {
			if (num + dnum[i] >= 0 && num + dnum[i] < N) {
				if(list[num+dnum[i]]=='0') {
					list[num+dnum[i]]='1';
				}
				else {
					list[num+dnum[i]]='0';
				}
			}

		}

	}
}
