		import java.awt.Point;
		import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
		import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.*;
		import java.lang.Long;
	import java.math.BigInteger;
		
			public class Main 
			{	
				static int count;
				//static boolean check =false;
				static int[][] map;
				static Queue<String> Q = new LinkedList<String>();
			    public static void main(String[] args) {
			    
			    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			    	try {
						int a = Integer.parseInt(bf.readLine());
						map=new int[a][a];
						for(int i=0;i<a;i++)
						{
							String[] s = bf.readLine().split("");
							for(int j=0;j<a;j++)
							{
								map[i][j]=Integer.parseInt(s[j]);
							}
						}
						search(0,0,a);
						//System.out.print(Q);
						for(String al : Q)
						{
						System.out.print(al);
						}
					} catch (NumberFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    }
			    public static void search(int start_y,int start_x,int lengt)
			    {
			    	boolean check =true;
			    	for(int i=0;i<lengt;i++)
			    	{
			    		if(!check)
			    		{
			    			break;
			    		}
			    		for(int j=0;j<lengt;j++)
			    		{
			    			if(map[start_y][start_x]!=map[start_y+i][start_x+j])
			    			{
			    				check =false;
			    				break;
			    			}
			    		}
			    	}
			    	
			    	if(check)
			    	{
			    		Q.offer(String.valueOf(map[start_y][start_x]));
			    		//System.out.println("출력="+start_y+" "+start_x+" "+lengt);
			    		//System.out.println("출력값=> "+" "+map[start_y][start_x]);
			    	}
			    	else if (!check)
			    	{
			    		Q.offer("(");
			    		for(int i=0;i<2;i++)
			    		{
			    			for(int j=0;j<2;j++)
			    			{
			    				
			    				//System.out.println("y=" + (start_y+(i*(lengt/2)))+" x="+(start_x+(j*(lengt/2))+" "+(lengt/2)));
			    				search((start_y+(i*(lengt/2))),(start_x+(j*(lengt/2))),lengt/2);
			    				
			    			}
			    		}
			    		Q.offer(")");
			    	}
			    }
			}
	
	
			
			
			
				
			