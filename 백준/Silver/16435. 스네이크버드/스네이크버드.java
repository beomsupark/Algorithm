import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);
		for (int i = 0; i < N; i++) {
			if(H<list[i]) {
				break;
			}
			H++;
		}
		System.out.print(H);
	}
}
