import java.util.*;
import java.io.*;
class Node{
	int index;
	int value;
	public Node(int index, int value) {
		this.index = index;
		this.value = value;
	}
}
public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Node> stack = new Stack<>();
		for(int i =1; i<=N;i++) {
			Node temp = new Node(i,Integer.parseInt(st.nextToken()));
			
			while(!stack.isEmpty()&&stack.peek().value<temp.value) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			else {
				sb.append(stack.peek().index+" ");
			}
			stack.push(temp);
		}
		System.out.println(sb);
	}
}
