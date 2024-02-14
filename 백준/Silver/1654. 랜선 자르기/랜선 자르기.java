import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] list = new int[K];
		for (int i = 0; i < K; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(list);
		System.out.println(Search(list, N));
	}

	public static long Search(int[] arr, int k) {
		long start = 1;
		long end = arr[arr.length-1];
		long index=0;
		while(start<=end) {
			long mid = (start+end)/2;
			int sum=0;
			for(int num: arr) {
				sum+=num/mid;
			}
			if(sum>=k) {
				index= Math.max(index,mid);
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return index;
	}
}
