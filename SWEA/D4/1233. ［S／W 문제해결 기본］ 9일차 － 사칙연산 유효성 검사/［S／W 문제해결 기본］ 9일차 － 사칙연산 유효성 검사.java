import java.io.*;
import java.util.*;
/**
 * 작성자 : 박범수
 * 문제 : SWEA 1233 사칙연산
 * 제출 : 2024년 2월 6일
 * 
 * 아이디어:
 * 계산이 가능한 방식이 성립되기 위해서는 먼저 연산자는 아래에 무조건 두 개의 자식이 존재해야하고
 * 숫자의 경우에는 자식이 하나도 존재해서는 안된다.
 * 그리고 이후 연산자 아래에는 계산하면서 올라왔을 때 자식이 모두 숫자여야하는데, 이때 숫자 아래에는 자식이 존재하지 않으므로,
 * 리프노드는 모두 숫자가되고, 리프노드가 아닌 노드의 경우에는 모두 연산자가 된다.
 * 밑에서부터 생각해본다면, 리프노드들의 부모노드들은 모두 연산자이며 두가지의 자식을 지녔으며, 모두 숫자이기에 계산이 가능하고, 계산 후 숫자로
 * 값을 바꾼다면 트리의 높이가 1 줄어들고, 리프노드들은 모두 숫자이며, 리프노드가 아닌 노드는 모두 연산자가 되며
 * 이를 반복한다면 최종값이 하나가 남을때 까지 반복할 수 있다.
 * 고로 연산자 아래에는 무조건 두개의 자식이 존재하고, 숫자 아래에는 자식이 존재하지 않는다면, 모두 계산 가능하다.
 * 입력받는 동시에 이를 확인하면서 해결하였다.
*/
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case=1;test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			boolean check = true;
			for(int i=0;i<N;i++) {
				
				String[] node = br.readLine().split(" ");
				if(node[1].equals("+")||node[1].equals("-")||node[1].equals("*")||node[1].equals("/")) {
					if(!(node.length==4)) {
						check=false;
					}
				}
				else {
					if(!(node.length==2)) {
						check=false;
					}
				}
			}
			if(!check) {
				System.out.printf("#%d %d\n",test_case,0);
			}
			else {
				System.out.printf("#%d %d\n",test_case,1);	
			}
		}
	}
}
