package pages;
import java.util.Random;

import org.openqa.selenium.By;


public class LandingPage {

	
	
	public int generateFibandReturnRandomNumber()
	{
		int[] fib_array=fibonacci();  
		for(int i=0; i<fib_array.length;i++) {
			
			System.out.println(" "+fib_array[i]);
		}
		 int num=RandomNumber_fibArray(fib_array);
		 System.out.println(" random number is "+num);  
		 
		 return num;
	}
		
		public static int RandomNumber_fibArray(int[] array) {
		     int rand = new Random().nextInt(array.length);
		     return array[rand];
		    }
		
		public static int[] fibonacci() {
			int n1=0,n2=1,n3,i; 
			int[] fibarray= new int[10];
			     fibarray[0]= n1;
			     fibarray[1]=n2;
			   for(i=2;i<10;i++)    
		 {    
		  n3=n1+n2;
		  if(n3>40){
		      break;
		  }
		  else{
		  fibarray[i]=n3;		      
		  n1=n2;    
		  n2=n3;}    
		 }
		 return fibarray;  	
			
		}

	
}
