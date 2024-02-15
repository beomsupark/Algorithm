import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static int y;
	static int x;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char[][] list = new char[N][M];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					list[i][j] = temp[j];
				}
			}
			int count = Integer.parseInt(br.readLine());
			char[] commands = br.readLine().toCharArray();
			// 대포 위치 찾기
			find(list);
			// 위치 넣고 명령오 돌리기
			for (char command : commands) {
				if (command == 'U') {
					move(list,0);
				}
				if (command == 'D') {
					move(list,1);
				}
				if (command == 'L') {
					move(list,2);
				}
				if (command == 'R') {
					move(list,3);
				}
				if (command == 'S') {
					shoot(list);
				}

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(list[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	private static void shoot(char[][] list) {
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		char[] head = {'^','v','<','>'};
		int dist=0;
		for(int i=0;i<4;i++) {
			if(list[y][x]==head[i]) {
				dist=i;
			}
		}
		int tempy=y;
		int tempx=x;
		tempy+=dy[dist];
		tempx+=dx[dist];
		while(tempy>=0&&tempy<N&&tempx>=0&&tempx<M) {
			if(list[tempy][tempx]=='*') {
				list[tempy][tempx]='.';
				return;
			}
			if(list[tempy][tempx]=='#') {
				return;
			}
			tempy+=dy[dist];
			tempx+=dx[dist];
		}
		return;
		
	}
	private static void move(char[][]list, int dist) {
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		char[] head = {'^','v','<','>'};
		// 고개 돌리기
		// 이동
		list[y][x]='.';
		if(canMove(list,y+dy[dist],x+dx[dist])) {
			y+=dy[dist];
			x+=dx[dist];
		}
		list[y][x]=head[dist];
	}
	private static boolean canMove(char[][] list,int y, int x) {
		if(y>=0&&y<N&&x>=0&&x<M&&list[y][x]=='.') {
				return true;
		}
		return false;
	}
	private static void find(char[][] list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (list[i][j] == '<' || list[i][j] == '>' || list[i][j] == 'v' || list[i][j] == '^') {
					y = i;
					x = j;
					return;
				}
			}
		}
	}
	
}