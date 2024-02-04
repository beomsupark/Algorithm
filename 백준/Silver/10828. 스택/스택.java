import java.util.*;
import java.io.*;

class st {
	ArrayList<Integer> list = new ArrayList<>();
	int index = 0;

	public void push(int num) {
		list.add(num);
		index++;
	}

	public int pop() {
		if (index == 0) {
			return -1;
		}
		int num = list.get(index-1);
		list.remove(index-1);
		index --;
		return num;
	}

	public int size() {
		return index;
	}

	public int empty() {
		return index == 0 ? 1 : 0;
	}

	public int top() {
		if (index == 0) {
			return -1;
		}
		return list.get(index-1);
	}
}

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st stack = new st();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (s.equals("top")) {
				System.out.println(stack.top());
			} else if (s.equals("size")) {
				System.out.println(stack.size());
			} else if (s.equals("empty")) {
				System.out.println(stack.empty());
			} else if (s.equals("pop")) {
				System.out.println(stack.pop());
			}
		}

	}

}
