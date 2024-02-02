import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 문제: BJ_2164_카드2
 * 결과: pass
 * 메모리:
 * 실행시간: 
 * @author 박범수
 * n이 2^n일 경우 마지막으로 남게 되는 값이 n^2임을 증명할 수 있다.
 * 이때 모든 수를 가장 가까운 2의 제곱수에 M을 더한 값이라고 생각한다면,
 * 제외하는 방식을 절반을 남기는 방식으로 생각하게 된다면, 홀수일 경우와 짝수일 경우로 나눌 수있다.
 * 이때 홀수일 경우 수와 순서는 는 M을 이진수화 한것을 뒤집은 것과 같다.
 * 이때 홀수가 나올 경우는 값이 밀리게 되므로, 주어지는 값을 위의 가장 가까운 제곱수 2^N+M으로 표현할때, M*2가 된다.
 */
public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 가장 가까운 2의 제곱수 찾기
		double power=Math.log(N) / Math.log(2);
		int num = (int) Math.floor(power);
		int minus = (int) Math.floor(Math.pow(2,num));
		// (N-가장 가까운 제곱수)*2가 정답이 된다.
		int answer =(N-minus)*2;
		if(answer==0) {
			System.out.println(N);
		}
		else {
		System.out.println(answer);
		}
		
	}
}
