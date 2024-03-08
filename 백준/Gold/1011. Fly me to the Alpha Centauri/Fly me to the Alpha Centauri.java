import java.util.Scanner;
public class Main {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	long n = scan.nextInt();
	for(int i=0;i<n;i++)
	{
		long n1 = scan.nextInt();
		long n2 = scan.nextInt();
		long n3= n2-n1;
		long k=1;
		long num =1;
		while(n3>=k)
		{
			num++;
			k=num*num;
		}
		num--;
		k=num*num;
		long k2 = n3-k;
		long na = (long)Math.ceil((double)k2/(double)num);
		long answer = 1+(num*2)+(int)na-2;
		System.out.print(answer);
		System.out.println();
	}

}
}
