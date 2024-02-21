import java.io.*;
import java.util.*;

public class Main{
	static class node {
		int y;
		int x;
		int type;

		public node(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}

		@Override
		public String toString() {
			return "node [y=" + y + ", x=" + x + ", type=" + type + "]";
		}

	}

	static int min = Integer.MAX_VALUE;
	static ArrayList<node> cctvList;
	static int N;
	static int M;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		cctvList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] >= 1 && board[i][j] <= 5) {
					cctvList.add(new node(i, j, board[i][j]));
				}
			}
		}

		backtracking(0, board);

		System.out.print(min);
	}

	public static void backtracking(int depth, int[][] board) {
		if (depth == cctvList.size()) {
			min = Math.min(min, getZero(board));
			return;
		}
		node cctv = cctvList.get(depth);
		
		if (cctv.type == 1) {
			
			int[] dist = {1,2,4,8};// U, D, L, R
			for(int index: dist) {
				backtracking(depth+1,next(index,cctv,board));
			}
		}
		if (cctv.type == 2) {
			int[] dist = {3,12};// U, D, L, R
			for(int index: dist) {
				backtracking(depth+1,next(index,cctv,board));
			}
		}
		if (cctv.type == 3) {
			int[] dist = {9,10,6,5};// U, D, L, R
			for(int index: dist) {
				backtracking(depth+1,next(index,cctv,board));
			}
		}
		if (cctv.type == 4) {
			int[] dist = {13,11,14,7};// U, D, L, R
			for(int index: dist) {
				backtracking(depth+1,next(index,cctv,board));
			}
		}
		if (cctv.type == 5) {
			int[] dist = {15};// U, D, L, R
			for(int index: dist) {
				backtracking(depth+1,next(index,cctv,board));
			}
		}
	}

	private static int[][] copyMap(int[][] board) {
		int[][] next = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				next[i][j]=board[i][j];
			}
		}
		// TODO Auto-generated method stub
		return next;
	}

	private static int[][] next(int index,node cctv,int[][] board) {
		int[][] next = copyMap(board);
		for(int i=0;i<4;i++) {
			if((index&(1<<i))>0) {
				if(i==0) {//up
					upBoard(cctv.y,cctv.x,next);
				}
				if(i==1) {//down
					downBoard(cctv.y,cctv.x,next);
				}
				if(i==2) {//left
					leftBoard(cctv.y,cctv.x,next);
				}
				if(i==3) {//right
					rightBoard(cctv.y,cctv.x,next);
				}
			}
		}
		return next;
	}

	private static void rightBoard(int y, int x, int[][] next) {
		for(int i=x;i<M;i++) {
			if(next[y][i]==6)break;
			if(next[y][i]==0)next[y][i]=-1;
		}
		
	}

	private static void leftBoard(int y, int x, int[][] next) {
		for(int i=x;i>=0;i--) {
			if(next[y][i]==6)break;
			if(next[y][i]==0)next[y][i]=-1;
		}
		
	}

	private static void downBoard(int y, int x, int[][] next) {
		for(int i=y;i<N;i++) {
			if(next[i][x]==6)break;
			if(next[i][x]==0)next[i][x]=-1;
		}
		
	}

	private static void upBoard(int y, int x, int[][] next) {
		for(int i=y;i>=0;i--) {
			if(next[i][x]==6)break;
			if(next[i][x]==0)next[i][x]=-1;
		}
	}

	private static int getZero(int[][] map) {

        int count = 0;

        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){

                if (map[i][j] == 0)
                    count++;
            }
        }

        return count;
    }

}
