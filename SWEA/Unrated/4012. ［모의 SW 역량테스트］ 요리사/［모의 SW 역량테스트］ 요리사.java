
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution

{

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		for(int test_case =1; test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int sum = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			for (int i = 0; i < (1 << N); i++) {
				if (Integer.bitCount(i) == (N / 2)) {
					int[] list_1 = new int[N / 2];
					int[] list_0 = new int[N / 2];
					int count_1 = 0;
					int count_0 = 0;
					int temp_sum_1 = 0;
					int temp_sum_0 = 0;
					for (int j = 0; j < N; j++) {
						if (((1 << j) & i) > 0) {
							list_1[count_1] = j + 1;
							count_1++;
						} else {
							list_0[count_0] = j + 1;
							count_0++;
						}
					}
					for (int j = 0; j < N / 2; j++) {
						for (int k = 0; k < N / 2; k++) {
							temp_sum_1 += map[list_1[j] - 1][list_1[k] - 1];
							temp_sum_0 += map[list_0[j] - 1][list_0[k] - 1];
						}
					}
					if (temp_sum_1 >= temp_sum_0) {
						if ((temp_sum_1 - temp_sum_0) < sum) {
							sum = temp_sum_1 - temp_sum_0;
						}
					} else {
						if ((temp_sum_0 - temp_sum_1) < sum) {
							sum = temp_sum_0 - temp_sum_1;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",test_case,sum);
			
		}
		
		
		
		

		
	}

}