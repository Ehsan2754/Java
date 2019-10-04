package ir.ahuratus.task1;
import java.util.ArrayList;
import java.util.Scanner;






public class Innopolis {
	public static void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b; 
        
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		try {
			  
			  Scanner input = new Scanner(System.in);
			  ArrayList<Integer> data = new ArrayList<Integer>();
			  System.out.println(">>>>>>>     AHURATUS SORTER   <<<<<<<");
			  System.out.println("> How many numbers you want to Sort?<");
			  int a = input.nextInt();
			  System.out.println(">> Enter your data and press Enter <<");
			  for (int i = 0; i < a ; i++)
				  data.add(input.nextInt());
			  System.out.println(">>>>>>> Choose your algorithm <<<<<<<");
			  System.out.println(">>>>>>>      0 : Bubble       <<<<<<<");
			  System.out.println(">>>>>>>      1 : Quick        <<<<<<<");
			  
			  switch (input.nextInt()) {
			case 0://Bubble Sort implementation
				  System.out.println(">>>>>>>>Your raw data is : <<<<<<<<<<");
				  for (Integer element : data) System.out.println(element);
				  Algorithms.bubbleSort(data);
				  System.out.println(">>>>>>Your sorted data is : <<<<<<<<<");
				  for (Integer element : data) System.out.println(element);
				break ;
			case 1://Quick Sort implementation
				  System.out.println(">>>>>>>>Your raw data is : <<<<<<<<<<");
				  for (Integer element : data) System.out.println(element);
				  Algorithms.quickSort(data);
				  System.out.println(">>>>>>Your sorted data is : <<<<<<<<<");
				  for (Integer element : data) System.out.println(element);
				break;

			default:
				input.close();
				throw new IllegalArgumentException("Unexpected value For Algorithm"  );
			}
			  input.close();
			  
			  
				
			
			 
				
			
		} catch (Exception e) {
		
			System.out.print("ERROR -> "+e.toString());
		}
		
//		al.add(e)
		
		
		/*********************************************/
		
	}
	
  
	

	 
}
