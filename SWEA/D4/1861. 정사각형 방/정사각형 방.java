import java.io.*;
import java.util.*;
public class Solution {
	static int N;
	static int[][] array;
	static HashMap<Integer,Integer> map = new HashMap<>();
	static boolean[][] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			N = Integer.parseInt(br.readLine());
			array = new int[N][N];
			check = new boolean[N][N];
			for(int i=0;i<N;i++) {
				st =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					array[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			// 
			int answer =1;
			int point =1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(check[i][j]) {
						continue;
					}
					int num = calAnswer(i,j);
					if(num>answer) {
						answer=num;
						point=array[i][j];
					}
					else if(num==answer&&array[i][j]<point) {
						point=array[i][j];
					}
				}
			}
			System.out.printf("#%d %d %d\n",test_case,point,answer);
		}
	}
	private static int calAnswer(int y, int x) {
		// TODO Auto-generated method stub
		int tempy = y;
		int tempx = x;
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		int count=1;
		while(!check[y][x]) {
			check[y][x]=true;
			for(int i=0;i<4;i++) {
				if(y+dy[i]<N&&y+dy[i]>=0&&x+dx[i]<N&&x+dx[i]>=0) {
					if(array[y+dy[i]][x+dx[i]]==array[y][x]+1) {
						if(check[y+dy[i]][x+dx[i]]) {
						
							count= map.get(array[y+dy[i]][x+dx[i]])+1;
							break;
						}
						y+=dy[i];
						x+=dx[i];
						count++;
						break;
					}
				}
			}
		}
		map.put(array[tempy][tempx],count);
		return count;
	}
}
