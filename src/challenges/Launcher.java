package challenges;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Launcher{
	
	static int row=0;
	
	 public static int migratoryBirds(List<Integer> arr) {
		 
		 int[] score=new int[arr.size()+1];
		 for( Integer i : arr)
		 {
			 
			 switch(i)
			 {
			 
			 case 1: score[1]++; break;
			 case 2: score[2]++; break;
			 case 3: score[3]++; break;
			 case 4: score[4]++; break;
			 case 5: score[5]++; break;
			 
			 
			 }
			 
		 }
		 int max=0;
		 for (int i=1;i<score.length;i++)
		 {
			 int tmp=score[i];
			 if(tmp>=max)
			 { max=tmp;}
		 }
		 int min=99999;
		 for (int i=1;i<score.length;i++)
		 {
			 if(score[i]==max)
			 {
				 if(i<min)
				 min=i;
			 }
			 
		 }
		 return min;
		    // Write your code here
		      
		    }

	public static void main(String[] args)  {
		 List<List<Integer>> arr = new ArrayList<>();
		
		
		
		/*      test sample from Hack bank
		 7 6 8 2 4 3
7 3 3 0 6 1
3 8 7 7 2 2
0 8 6 8 6 1
7 1 6 0 2 4
2 7 8 1 7 4
		 */
		//Arrays.asList(7, 6, 8, 2, 4, 3)
		
		arr.add(new ArrayList<Integer>(Arrays.asList(7, 6, 8, 2, 4, 3)));
		

arr.add(new ArrayList<Integer>(Arrays.asList(7, 3, 3, 0, 6, 1)));
		

arr.add(new ArrayList<Integer>(Arrays.asList(3, 8, 7, 7, 2,2)));
arr.add(new ArrayList<Integer>(Arrays.asList(0,8, 6, 8,6,1)));
arr.add(new ArrayList<Integer>(Arrays.asList(7, 1, 6, 0, 2, 4)));
arr.add(new ArrayList<Integer>(Arrays.asList(2,7, 8,1,7, 4)));

int loopRow=arr.size()-2;
 //Integer row=0;
 int start=0;
 List<Integer> ltop=new ArrayList<>(); //ltop.add(0);
 List<Integer> lmid=new ArrayList<>(); //lmid.add(0);
 List<Integer> lbot=new ArrayList<>();//lbot.add(0);
 
 while(start<4)
 {
loopRow(arr,ltop,loopRow);	

int mid1=1; 
loopMid(arr, lmid, loopRow,mid1 );


loopRow(arr, lbot, loopRow);

start++;
row=start;
 }

 int max=0; int sum=0;
 for (int i=0;i<ltop.size();i++) {
	sum+=ltop.get(i);
	sum+=lmid.get(i);
	sum+=lbot.get(i);
	if(sum>max)
	{
		max=sum;
		
	}
	sum=0;
}
System.out.println("max "+max);

	  
	  
  
 
  
  

			
	}
	
	private static void loopRow(List<List<Integer>> arr, List<Integer> ltop, int loopRow) {
		for (int i=0;i<loopRow;i++)
		{
			int sum=0;
			for(int j=i;j<3+i;j++)
		   {
		  sum+=((	arr.get(row).get(j))); 
		   }
			ltop.add(sum);
			
		}
		row++;
		
	}

/*	private static void loopBottom(List<List<Integer>> arr,List<Integer> lbot,int loopRow
			) {
		//int start=0;int col=0; 
		
		//int loopRow=arr.size()-2;
		for (int i=0;i<loopRow;i++)
		{
			int sum=0;
			for(int j=i;j<3+i;j++)
		   {
			sum+=(arr.get(row).get(j)); 
		   }
			lbot.add(sum);
			
		}
		row++;
	}*/

	private static void loopMid(List<List<Integer>> arr,List<Integer> lmid,int loopRow,int mid) {
		
		//int loopRow=arr.size()-2;
		for (int i=0;i<loopRow;i++)
		{
			
				lmid.add(arr.get(row).get(mid)); 
				
			mid++;
		
			
		}
		row++;
	}

}
