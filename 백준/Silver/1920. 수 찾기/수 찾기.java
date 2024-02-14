import java.io.*;
import java.util.*;
public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		int M = Integer.parseInt(br.readLine());
		int[] keys = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			keys[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			if(binarySearch(list,keys[i])>=0) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		
	}
	
	public static int binarySearch(int[] arr, int key) {
		int start =0;
		int end = arr.length-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(key==arr[mid]) {
				return mid;
			}else if (key>arr[mid]){
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return -1;
	}
}
