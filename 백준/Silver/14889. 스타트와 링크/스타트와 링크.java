import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Main

        {
		
			public static void main(String[] args)
			{
				
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				try {
					int n=Integer.parseInt(bf.readLine());
					int[][] map = new int[n][n];
					int sum =Integer.MAX_VALUE;
					for(int i=0;i<n;i++)
					{
						String[] s = bf.readLine().split(" ");
						for(int j=0;j<n;j++)
						{
							map[i][j]=Integer.parseInt(s[j]);
						}
					}
					
					for(int i=0;i<(1<<n);i++) {
					    if(Integer.bitCount(i)==(n/2))
					    {
					        int[] list_1 = new int[n/2];
					        int[] list_0 = new int[n/2];
					        int count_1 =0;
					        int count_0 =0;
					        int temp_sum_1=0;
					        int temp_sum_0=0;
					        for(int j=0;j<n;j++)
					        {
					        	if(((1<<j)&i)>0)
					        	{
					        		list_1[count_1]=j+1;
					        		count_1++;
					        	}
					        	else
					        	{
					        		list_0[count_0]=j+1;
					        		count_0++;
					        	}
					        }
					        for(int j=0;j<n/2;j++)
					        {
					        	for(int k=0;k<n/2;k++)
					        	{
					        		temp_sum_1+=map[list_1[j]-1][list_1[k]-1];
					        		temp_sum_0+=map[list_0[j]-1][list_0[k]-1];
					        	}
					        }
					        if(temp_sum_1>=temp_sum_0)
					        {
					        	if((temp_sum_1-temp_sum_0)<sum)
					        	{
					        		sum=temp_sum_1-temp_sum_0;
					        	}
					        }
					        else
					        {
					        	if((temp_sum_0-temp_sum_1)<sum)
					        	{
					        		sum=temp_sum_0-temp_sum_1;
					        	}
					        }
					    }
					}
					System.out.println(sum);
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

        }