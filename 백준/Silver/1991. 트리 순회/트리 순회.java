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
				static String[][] map;
			    public static void main(String[] args) {
			    		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			    		HashMap<String,Node> hs = new HashMap<String,Node>();
			    		try {
			    			int a = Integer.parseInt(bf.readLine());
							Node[] k = new Node[a];
							char sumb='A';
							String check=".";
							Node k2 = new Node("A");
							for(int i=0;i<a;i++)
							{
						
								String temp = String.valueOf(sumb);
								k[i]= new Node(temp);
								hs.put(temp,k[i]);
								sumb=(char)(sumb+1);
							}
							
							for(int i=0;i<a;i++)
							{
								
								String[] s= bf.readLine().split(" ");
								if(!s[1].equals(check))
								{
								hs.get(s[0]).setleft(hs.get(s[1]));
								}
								if(!s[2].equals(check))
								{
								hs.get(s[0]).setright(hs.get(s[2]));
								}
							}
							jeon(hs.get("A"));
							System.out.println();
							j(hs.get("A"));
							System.out.println();
							who(hs.get("A"));
							System.out.println();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		
			    		}
			    public static void j(Node a)
			    {
			    	if(a!=null)
			    	{
			    		j(a.getleft());
			    		System.out.print(a.getvalue());
				    	j(a.getright());
			    	}
			    }
			    public static void who(Node a)
			    {
			    	if(a!=null)
			    	{
			    		who(a.getleft());
				    	who(a.getright());
				    	System.out.print(a.getvalue());
			    	}
			    }
			    public static void jeon(Node a)
			    {
			    	if(a!=null)
			    	{
			    		System.out.print(a.getvalue());
			    		jeon(a.getleft());
				    	jeon(a.getright());
			    	}
			    }
			    
			}
			class Node
			{
				String value="A";
				Node left=null;
				Node right=null;
				public Node(String Value)
				{
					this.value =Value;
				}
				public void setvalue(String Value)
				{
					this.value =Value;
				}
				public String getvalue()
				{
					return value;
				}
				public void setleft(Node left)
				{
					this.left = left;
				}
				public Node getleft()
				{
					return left;
				}
				public void setright(Node right)
				{
					this.right = right;
				}
				public Node getright()
				{
					return right;
				}
			}
	
			
			
			
				
			