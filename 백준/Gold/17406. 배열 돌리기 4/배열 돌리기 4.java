import java.io.*;
import java.util.*;

class Command {
	int y;
	int x;
	int round;

	public Command(int y, int x, int round) {
		this.y = y;
		this.x = x;
		this.round = round;
	}
}

/**
 * [G4] 백준 17406 배열 돌리기 4 메모리 : 시간 : 코드 길이 : 각 회전을 O(NM)에 구현하고, K개만큼 회전 시켜야한다.
 * 또한 모든 가짓수를 따지는 데 이때 순서도 신경 써야 하므로 시간복잡도는 O(K!*NMK)가 된다. 제한 시간내에 풀 수 있으므로, 위와
 * 같은 방식으로 모든 경우를 고려하여, 모두 실행해 본 뒤 최솟값을 출력하였다.
 * 
 * @author 박범수
 * @see <a href="https://www.acmicpc.net/problem/17406">
 */
public class Main{

	static int N;
	static int M;
	static int K;
	static int min = Integer.MAX_VALUE;
	static boolean[] check;
	static Command[] comList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] list = new int[N][M];
		check = new boolean[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comList = new Command[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			comList[i] = new Command(Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken()));
		}
		backtracking(0,list);
		System.out.println(min);
	}

	public static void backtracking(int depth, int[][] list) {
		if (depth == K) { 
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += list[i][j];
				}
				min = Math.min(min, sum);
			}
			//System.out.println(Arrays.deepToString(list));
			return;
		}
		for (int i = 0; i < K; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			// 회전시킨 리스트 생성 후 삽입
			backtracking(depth + 1, rotate(list, i));
			check[i] = false;
		}
	}

	private static int[][] rotate(int[][] list, int num) {
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int direction =0;
		int[][] tempList = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tempList[i][j]=list[i][j];
			}
		}
		// 시작 지점 찾기
		for (int i = 1; i <= comList[num].round; i++) {
			int y = comList[num].y-i;
			int x = comList[num].x-i;
			for(int j=0;j<8*i;j++) {
				if(x+dx[direction]<(comList[num].x-i)||x+dx[direction]>(comList[num].x+i)||y+dy[direction]<(comList[num].y-i)||y+dy[direction]>(comList[num].y+i)) {
					direction=(direction+1)%4;
				}
				//System.out.println("이동: "+j+" y:"+y+" x:"+x);
				//System.out.println("옮기는 위치: "+j+" y:"+(y+dy[direction])+" x:"+(x+dx[direction]));
				tempList[y+dy[direction]][x+dx[direction]]=list[y][x];
				y+=dy[direction];
				x+=dx[direction];
			}
		}
		return tempList;
	}
}
