import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int M;
	static int[][] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==1) {
				list=operation1();
			}
			if(num==2) {
				list=operation2();
			}
			if(num==3) {
				list=operation3();
			}
			if(num==4) {
				list=operation4();
			}
			if(num==5) {
				list=operation5();
			}
			if(num==6) {
				list=operation6();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(list[i][j]+" ");
			}
			System.out.println();
		}

	}
	// 상하 반전
	public static int[][] operation1() {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j] = list[N-1-i][j];
			}
		}
		return temp;
	}
	// 좌우 반전
	public static int[][] operation2() {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j] = list[i][M-1-j];
			}
		}
		return temp;

	}
	// 오른쪽으로 90도
	public static int[][] operation3() {
		int[][] temp = new int[M][N];
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				temp[j][i]=list[N-1-i][j];
			}
		}
		int temp_num = N;
		N=M;
		M=temp_num;
		return temp;
	}
	// 왼쪽으로 90도
	public static int[][] operation4() {
		int[][] temp = new int[M][N];
		for(int i = 0;i<N;i++) {
			for(int j= M-1;j>=0;j--) {
				temp[j][i]=list[i][M-1-j];
			}
		}
		int temp_num = N;
		N=M;
		M=temp_num;
		return temp;

	}
	// 4분할 해서 시계
	public static int[][] operation5() {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) { 
				int nextX=0;
				int nextY=0;
				if(i<N/2&&j<M/2) { //1사분면
					nextX=M/2;
				}else if(i<N/2&&j>=M/2) { // 2사분면
					nextY=N/2;
				}else if(i>=N/2&&j<M/2) { // 3사분면 
					nextY=-1*(N/2);
				}else { // 4사분면
					nextX=-1*(M/2);
				}
				 
				
				temp[i+nextY][j+nextX]=list[i][j];
			}
		}
		return temp;
	}
	// 4분할 해서 반시계
	public static int[][] operation6() {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) { 
				int nextX=0;
				int nextY=0;
				if(i<N/2&&j<M/2) { //1사분면
					nextY=N/2;
				}else if(i<N/2&&j>=M/2) { // 2사분면
					nextX=-1*(M/2);
				}else if(i>=N/2&&j<M/2) { // 3사분면 
					nextX=(M/2);
				}else { // 4사분면
					nextY=-1*(N/2);
				}
				 
				
				temp[i+nextY][j+nextX]=list[i][j];
			}
		}
		return temp;

	}
}
