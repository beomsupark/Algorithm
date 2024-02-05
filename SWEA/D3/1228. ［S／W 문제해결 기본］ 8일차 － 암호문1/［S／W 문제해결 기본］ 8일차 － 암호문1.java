import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T =10;
			
			for(int test_case =1;test_case<=10;test_case++) {
				int N = Integer.parseInt(br.readLine());
				LinkedList<Integer> list = new LinkedList<>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i=0;i<N;i++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				int M = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				for(int i=0;i<M;i++) {
					st.nextToken();
					int indexStart =Integer.parseInt(st.nextToken());
					int num =Integer.parseInt(st.nextToken());
					for(int j=0;j<num;j++) {
						list.add(indexStart++, Integer.parseInt(st.nextToken()));
					}
				}
				System.out.printf("#%d ",test_case);
				for(int i=0;i<10;i++) {
					System.out.printf("%d ",list.get(i));
				}
                System.out.println();
			}
	}
}
