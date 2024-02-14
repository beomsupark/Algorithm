import java.io.*;
import java.util.*;

public class Main{
	static int C;
	static int R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[] list[] = new char[R][C];
		for(int i=0;i<R;i++) {
			char[] c = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				list[i][j]= c[j];
			}
		}
		int answer =0;
		for(int i=0;i<R;i++){
			answer+=steelGas(list,i,0);
		}
		System.out.println(answer);
	}
	
	public static int steelGas(char[][] list, int y, int x) {
		int[] dy = {-1,0,1};
		if(x==C-1) {
			list[y][x]='x';
			return 1;
		}
		int data=0;
		for(int i=0;i<3;i++) {
			if(y+dy[i]>=0&&y+dy[i]<R&&x+1>=0&&x+1<C&&list[y+dy[i]][x+1]=='.') {
				data+=steelGas(list,y+dy[i],x+1);
			}
			list[y][x]='x';
			if(data>0) {
				return 1;
			}
		}
		
		return 0;
	}
		
}
