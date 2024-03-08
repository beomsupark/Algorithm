
import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(divide(nums,0,N-1));
	}
	public static int divide(int[] nums, int start, int end) {
		if(start>=end) {
			return nums[start];
		}
		int mid = (start+end)/2;
		
		// 합친값 계산
		
		int left_max= divide(nums,start,mid);
		int right_max=divide(nums,mid+1,end);
		
		int max=Math.max(left_max, right_max);
		
		// 연결되면서 생성된 직사각형 계산
		int left = mid;
		int right = mid+1;
		int min = Math.min(nums[left], nums[right]);
		int centerMax= min*(right-left+1);
		
		while(left>start||right<end) {
			
			if(right!=end&&(left==start || nums[left-1]<=nums[right+1])) {
				right++;
				min=Math.min(min, nums[right]);
			}else {
				left--;
				min=Math.min(min, nums[left]);
			}
			centerMax= Math.max(centerMax,min*(right-left+1));
		}
		return Math.max(max, centerMax);
	}
}
