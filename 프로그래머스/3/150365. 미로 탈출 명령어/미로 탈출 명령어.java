import java.io.*;
import java.util.*;

class node implements Comparable<node>{
	int y;
	int x;
	String value;
	public node(int y, int x, String s) {
		this.y=y;
		this.x=x;
		this.value=s;
	}
	@Override
	public int compareTo(node o) {
		// TODO Auto-generated method stub
		return this.value.compareTo(o.value);
	}
}
class Solution {
	
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
    	int[] dy = {0,-1,1,0};
        int[] dx = {1,0,0,-1};
        String[] dvalue = {"d","l","r","u"};
    	PriorityQueue<node> pq = new PriorityQueue<>();
    	pq.add(new node(y,x,""));
        String answer = "";
        boolean isPossible = false;
        for(int i=0;i<=k;i++){
            boolean[][] visited = new boolean[m+1][n+1];
            
            PriorityQueue<node> nextpq = new PriorityQueue<>();
            
            while(!pq.isEmpty()){
                node current = pq.poll();
                int cy = current.y;
                int cx = current.x;
                String value = current.value;
                if(i==k&&cy==c&&cx==r){
                    answer+=value;
                    isPossible=true;
                    break;
                }
                for(int j=0;j<4;j++){
                    int nx=cx+dx[j];
                    int ny=cy+dy[j];
                    if(nx>0&&nx<=n&&ny>0&&ny<=m&&!visited[ny][nx]){
                        visited[ny][nx]=true;
                        nextpq.add(new node(ny,nx,value+dvalue[j]));
                    }
                }
            }
            pq=nextpq;
        }
        if(!isPossible){
            answer="impossible";
        }
        return answer;
    }
}