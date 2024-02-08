import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] dohwa = new boolean[100][100];
		//첫줄 입력
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		// 검은색 색종이 정보 입력
		// 전체 배열에 색 칠하기
		int n = Integer.parseInt(st.nextToken());
		for (int i=0;i<n;i++) {
			s= br.readLine();
			st= new StringTokenizer(s);
			int x1 = Integer.parseInt(st.nextToken());
			int x2= (x1+10) >= 100 ? 100:(x1+10);
			int y1 = Integer.parseInt(st.nextToken());
			int y2 = (y1+10) >= 100 ? 100 :(y1+10);
			docolor(dohwa,x1,x2,y1,y2);
		}
		int count=0;
		for (int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(dohwa[i][j]) {
					count++;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
	public static void docolor(boolean[][] array,int x1, int x2, int y1, int y2) {
		for(int i=x1;i<x2;i++) {
			for(int j =y1;j<y2;j++) {
				array[j][i]=true;
			}
		}
	}
}