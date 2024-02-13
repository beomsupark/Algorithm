import java.io.*;
import java.util.*;
public class Solution {
	static int[] inyeong= new int[9];
	static int[] gyuyeong= new int[9];
	static int win=0;
	static int lose=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		for(int tc=1;tc<=TC;tc++) {
			sb.append("#").append(tc).append(" ");
			boolean[] list= new boolean[19];
			win=0;
			lose=0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				gyuyeong[i]=Integer.parseInt(st.nextToken());
				list[gyuyeong[i]]=true;
			}
			int count=0;
			for(int i=1;i<=18;i++) {
				if(!list[i]) inyeong[count++]=i;
			}
			do {
				battle();
			}while(nextPermutation());
			sb.append(win+" "+lose+"\n");
		}
		System.out.println(sb);
	}
	public static boolean nextPermutation() {
		int index=-1;
		for(int i=9-2;i>=0;i--) {
			if(inyeong[i]<inyeong[i+1]) {
				index=i;
				break;
			}
		}
		if(index==-1) {
			//System.out.println("-1");
			return false;
		}
		for(int i=9-1;i>index;i--) {
			if(inyeong[index]<inyeong[i]) {
				swap(index,i);
				break;
			}
		}
		index++;
		int end = 9-1;
		while(index<end) {
			swap(index++,end--);
		}
		
//		for(int i=0;i<9;i++) {
//			System.out.print(inyeong[i]+" ");
//		}
		return true;
	}
	
	public static void swap(int left, int right) {
		int temp = inyeong[left];
		inyeong[left]=inyeong[right];
		inyeong[right]=temp;
	}
	public static void battle() {
		int value=0;
		for(int i=0;i<9;i++) {
			if(inyeong[i]<gyuyeong[i]) {
				value+=inyeong[i]+gyuyeong[i];
			}
		}
		if(value>85) {
			win++;
			return;
		}
		lose++;
	}
}
