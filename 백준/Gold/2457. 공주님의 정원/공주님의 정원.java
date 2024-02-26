import java.io.*;
import java.util.*;
public class Main {

	static class project implements Comparable<project>{
		int sm;
		int sd;
		int em;
		int ed;
		public project(int sm,int sd,int em, int ed) {
			this.sm=sm;
			this.sd=sd;
			this.em=em;
			this.ed=ed;
		}
		@Override
		public int compareTo(project o) {
			if(this.sm!=o.sm) return Integer.compare(this.sm, o.sm);
			return Integer.compare(this.sd, o.sd);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int N=Integer.parseInt(br.readLine());
		ArrayList<project> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(
					new project(
							Integer.parseInt(st.nextToken())
							,Integer.parseInt(st.nextToken())
							,Integer.parseInt(st.nextToken())
							,Integer.parseInt(st.nextToken())));

		}
		Collections.sort(list);
		
		int start_month=1;
		int start_day=1;
		int end_month=3;
		int end_day=1;
		
		int current_sm=1;
		int current_sd=1;
		int current_em=3;
		int current_ed=1;
		
		int answer =0;
		int count =0;
		
		boolean check = true;
		
		for(int i=0;i<=N;i++) {
			if(i==N) {
				
				if(end_month>=12) {
					check=false;
					break;
				}
				
				if(count==0) {
					break;
				}
				
				else {
					answer++;
					count=0;
					start_month=current_sm;
					start_day=current_sd;
					end_month=current_em;
					end_day=current_ed;
				}
				if(end_month>=12) {
					check=false;
					break;
				}
				break;
			}
			project current =list.get(i);
			// 종료 조건
			if(end_month>=12) {
				check=false;
				break;
			}
			// 프로젝트 시작 날이 범위 내에 존재하는가?
			if((current.sm>start_month||(current.sm==start_month&&current.sd>=start_day))
					&&(current.sm<end_month||(current.sm==end_month&&current.sd<=end_day))) {
				// 범위 내에서  가장 큰 끝나는 날의 경우 저장
				if(current.em>current_em||(current.em==current_em&&current.ed>current_ed)) {
					count++;
					current_sm=current.sm;
					current_sd=current.sd;
					current_em=current.em;
					current_ed=current.ed;
				}
			}
			else {
				if(count==0) {
					check=true;
					break;
				}
				else {
					answer++;
					count=0;
					start_month=current_sm;
					start_day=current_sd;
					end_month=current_em;
					end_day=current_ed;
					i--;
				}
			}	
		}
		// 마지막 처리
		
		if(check) {
			System.out.println(0);
		}else {
			System.out.println(answer);
		}
	}

}
