import java.io.*;
import java.util.*;
public class Main{
	static int N;
	static int[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list= new int[N];
		for(int i=0;i<N;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		nextPermutation();
	}
	
	public static void nextPermutation() {
		int index=-1;
		for(int i=N-2;i>=0;i--) {
			if(list[i]<list[i+1]) {
				index=i;
				break;
			}
		}
		//System.out.println(index);
		if(index==-1) {
			System.out.println("-1");
			return;
		}
		
		for(int i=N-1;i>index;i--) {
			if(list[index]<list[i]) {
				swap(index,i);
				break;
			}
		}
		index++;
		int end = N-1;
		while(index<end) {
			swap(index++,end--);
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(list[i]+" ");
		}
	}
	
	public static void swap(int left, int right) {
		int temp = list[left];
		list[left]=list[right];
		list[right]=temp;
	}
}
