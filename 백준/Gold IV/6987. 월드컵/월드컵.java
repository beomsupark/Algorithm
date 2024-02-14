import java.io.*;
import java.util.*;

public class Main{
	static int list[][] = new int[4][18];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 18; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 4; i++) {
			System.out.print(isPossible(list[i],0,0,1)+" ");
		}
	}

	public static int isPossible(int[] arr,int depth, int num, int current) {
		if(depth==15) {
			int sum=0;
			for(int temp : arr) {
				sum+=temp;
			}
			if(sum!=0) {
				return 0;
			}
			return 1;
		}
		if(current==6) {
			return isPossible(arr,depth,num+1,num+2);
		}
		int data = 0;
		for(int i=0;i<3;i++) {
			if(arr[num*3+i]!=0&&arr[current*3+2-i]!=0) {
				arr[num*3+i]--;
				arr[current*3+2-i]--;
				data+=isPossible(arr,depth+1,num,current+1);
				arr[num*3+i]++;
				arr[current*3+2-i]++;
			}
		}
		if(data!=0) {
			return 1;
		}
		return 0;
	}
}
