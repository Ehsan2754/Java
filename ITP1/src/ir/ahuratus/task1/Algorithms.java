package ir.ahuratus.task1;

import java.util.*;

class Algorithms {

 public Algorithms()
 {
  // TODO Auto-generated constructor stub
 }
 
 public static void bubbleSort(ArrayList<Integer> arg) 
 {
   try {
    for (int i = 0; i < arg.size(); i++) 
     for (int j = 1; j < arg.size() - i; j++)
      if (arg.get(j-1) > arg.get(j))
       Collections.swap(arg, j-1, j); 
   
  } catch (Exception e) {
   throw e;
   // TODO: handle exception
  }     
 }
 
 
 public static void quickSort(ArrayList<Integer> arg) 
 {
	try 
	{
		int len = arg.size();
	     int left= 0, right = len - 1;
	     Stack<Integer> bound = new Stack<Integer>();
	     bound.push(left);
	     bound.push(right);
	     int tempLeft , tempRight,pivot;
	     while (!bound.isEmpty()) 
	     {
	    	
	    	right = tempRight = bound.pop();
	    	left  = tempLeft  = bound.pop();
	    	pivot     = arg.get(tempRight);
	    	 
	    	while  (tempLeft<tempRight) 
	    	{
	    		while  ((tempLeft<tempRight)&&(arg.get(tempLeft)<=pivot))  tempLeft++; 	
	    		while  ((tempLeft<tempRight)&&(arg.get(tempRight)>pivot)) tempRight--;
	    		Collections.swap(arg, tempLeft, tempRight);
	    	}
	    	if (tempLeft-1>left)
	    	{
	    		bound.push(left);
	    		bound.push(tempLeft-1);
			}
	    	if (tempLeft<right)
	    	{
	    		bound.push(tempLeft);
	    		bound.push(right);
	    	}
			
		 }	
	} 
	catch (Exception g) {
		throw g;
		// TODO: handle exception
	}
     
     
  
 }
}