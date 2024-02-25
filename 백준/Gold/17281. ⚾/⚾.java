import java.io.*;
import java.util.*;

public class Main{
	static int max = -1;
	static int[] list = new int[9];
	static int board[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][9];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		list[3]=0;
		backtracking(0,0);
		System.out.println(max);
	}
	public static void backtracking(int depth, int visited) {
		if(depth==3) {
			backtracking(depth+1,visited|(1<<0));
			return;
		}
		if(depth==9) {
			play();
			return;
		}
		for(int i=1;i<9;i++) {
			if((visited&(1<<i))==0){
				list[depth]=i;
				backtracking(depth+1,visited|(1<<i));
			}
		}
	}

	private static void play() {
		int answer =0;
		int ining =0;
		//N번의 이닝 진행
		int count=0;
		while(ining<N) {
			int outCount =0;
			int ground=0;
			while(outCount!=3) {
				int a = board[ining][list[(count++)%9]];
				if(a==0) {
					outCount++;
					continue;
				}
				else {
					ground=ground<<a;
					ground=ground|(1<<(a-1));
					for(int i=6;i>=3;i--) {
						if((ground&(1<<i))>0) {
							answer++;
							ground = ground&(~(1<<i));
						}
					}
				}
			}
			ining++;
		}
		max= Math.max(max,answer);
	}
	
	
	
}
