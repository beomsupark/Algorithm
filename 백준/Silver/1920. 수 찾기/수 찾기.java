import java.util.*;
import java.awt.Point;
import java.io.*;
 
// https://www.acmicpc.net/problem/2473
 
class Main {
    
	static int size;
	static int[] sorted;
	static Point[] point_sorted;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
		try {
			s = br.readLine().split(" ");
			int data_size = Integer.parseInt(s[0]);
			int[] data = new int[data_size];
			sorted = new int[data_size];
			s = br.readLine().split(" ");
			for(int i=0;i<data_size;i++)
			{
				data[i]=Integer.parseInt(s[i]);			}
			merge_sort(data,0,data_size-1);
			
			s = br.readLine().split(" ");
			int find_size = Integer.parseInt(s[0]);
			Point[] find = new Point[find_size];
			int[] answer = new int[find_size];
			point_sorted = new Point[find_size];
			s = br.readLine().split(" ");
			for(int i=0;i<find_size;i++)
			{
				find[i]=new Point(Integer.parseInt(s[i]),i);
				answer[i]=0;
			}
			point_merge_sort(find,0,find_size-1);
			int check_data=0;
			int check_find=0;
			while(check_data<data_size&&check_find<find_size)
			{
				if(data[check_data]>find[check_find].x)
				{
					check_find++;
				}
				else if(data[check_data]<find[check_find].x)
				{
					check_data++;
				}
				else
				{	
					answer[find[check_find].y]=1;
					check_find++;
				}
			}
			for(int i=0;i<find_size;i++)
			{
				System.out.println(answer[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    public static void merge_sort(int[] list,int start,int last)
    {
    	int mid = (start+last)/2;
    	if(start<last)
    	{
    		merge_sort(list,start,mid);
    		merge_sort(list,mid+1,last);
    		merge(list,start,mid,last);
    	}
    }
    public static void merge(int[] list,int start,int mid,int last)
    {
    	int temp_rule=start;
    	int temp_start=start;
    	int temp_mid=mid+1;
    	while(temp_start<=mid&&temp_mid<=last)
    	{
    		if(list[temp_start]<=list[temp_mid])
    		{
    			sorted[temp_rule++]=list[temp_start++];
    		}
    		else
    		{
    			sorted[temp_rule++]=list[temp_mid++];
    		}
    	}
    	
    	if(temp_start>mid)
    	{
    		for(int i=temp_mid;i<=last;i++)
    		{
    			sorted[temp_rule++]=list[i];
    		}
    	}
    	else
    	{
    		for(int i=temp_start;i<=mid;i++)
    		{
    			sorted[temp_rule++]=list[i];
    		}
    	}
    	for(int i=start;i<=last;i++)
    	{
    		list[i]=sorted[i];
    	}
    }
    public static void point_merge_sort(Point[] list,int start,int last)
    {
    	int mid = (start+last)/2;
    	if(start<last)
    	{
    		point_merge_sort(list,start,mid);
    		point_merge_sort(list,mid+1,last);
    		point_merge(list,start,mid,last);
    	}
    }
    public static void point_merge(Point[] list,int start,int mid,int last)
    {
    	int temp_rule=start;
    	int temp_start=start;
    	int temp_mid=mid+1;
    	while(temp_start<=mid&&temp_mid<=last)
    	{
    		if(list[temp_start].x<=list[temp_mid].x)
    		{
    			point_sorted[temp_rule++]=new Point(list[temp_start].x,list[temp_start].y);
    			temp_start++;
    		}
    		else
    		{
    			point_sorted[temp_rule++]=new Point(list[temp_mid].x,list[temp_mid].y);
    			temp_mid++;
    		}
    	}
    	if(temp_start>mid)
    	{
    		for(int i=temp_mid;i<=last;i++)
    		{
    			point_sorted[temp_rule++]=new Point(list[i].x,list[i].y);
    		}
    	}
    	else
    	{
    		for(int i=temp_start;i<=mid;i++)
    		{
    			point_sorted[temp_rule++]=new Point(list[i].x,list[i].y);
    		}
    	}
    	for(int i=start;i<=last;i++)
    	{
    		list[i]=new Point(point_sorted[i].x,point_sorted[i].y);
    	}
    }
}
