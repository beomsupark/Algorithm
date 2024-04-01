import java.util.*;
import java.io.*;

public class Solution{

	static int p = 1234567891;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());
		long[] memo = new long[1000001];
		memo[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			memo[i] = (memo[i - 1] * i) % p;
		}

		for (int tc = 1; tc <= testCase; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			
			long a = memo[n];
			long b = pow((memo[n - r] * memo[r]) % p, p - 2);
			System.out.println("#" + tc + " " + (a * b) % p);
		}
	}

	private static long pow(long a, long b) {
		if (b == 0) {
			return 1;
		}
		// 반으로 나눈 거듭제곱 계산.
		long res = pow(a, b / 2);
		// 지수가 짝수인 경우.
		if (b % 2 == 0) {
			return (res * res) % p;
		}
		// 지수가 홀수인 경우
		else {
			return ((res * res) % p * a) % p;
		}
	}
}