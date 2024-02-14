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
				static boolean check =false;
				static int b,c;
				//static int[][] map;
			    public static void main(String[] args) {
			    
			    	BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
			    	try {
						String[] s = bf.readLine().split(" ");
						int a = Integer.parseInt(s[0]);
						b = Integer.parseInt(s[1]);
						c = Integer.parseInt(s[2]);
						int a2=1;
						for(int i=0;i<a;i++)
						{
							a2*=2;
						}
						count=0;
						//map = new int[a2+1][a2+1];
						root(0,0,a2-1,a2-1);
						System.out.println(count);
						/*for(int i=1;i<=a2;i++)
						{
							for(int j=1;j<=a2;j++)
							{
								System.out.print(map[i][j]+" ");
							}
							System.out.println();
						}*/
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    	
			    	
			    }
			    public static void root(int start_y,int start_x,int last_y,int last_x)
			    {
			    	if(check)
			    	{
			    		return;
			    	}
			    	boolean check2 =false;
			    		for(int i=0;i<2;i++)
			    		{
			    			for(int j=0;j<2;j++)
			    			{
			    				if(check2)
			    				{
			    					break;
			    				}
			    				int temp = (last_x-start_x+1)/2;
			    				if(((start_y+(temp*i))<=b&&b<=(start_y+(temp*(i+1))-1))&&((start_x+(temp*j))<=c&&c<=(start_x+(temp*(j+1)-1))))
			    				{
			    				root((start_y+(temp*i)),(start_x+(temp*j)),(start_y+(temp*(i+1))-1),(start_x+(temp*(j+1)-1)));
			    				check2=true;
			    				break;
			    				}
			    				count+=temp*temp;
			    			}
			    		}
			    	if((start_x==c&&last_x==c)&&(start_y==b&&last_y==b))
			    	{
			    		check=true;
			    	}
			    }
			}
	
	
			
			
			
				
			