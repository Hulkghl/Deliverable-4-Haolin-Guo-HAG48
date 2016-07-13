/**
 * 
 * @author Haolin Guo
 * Deliverable 4 - Property-Based Testing - Function of "billify" method
 *
 */


public class billifyFunction 
{
	
	//returns an result array that contains the square-values of all the elements in the argument array
	//and one element be added to the array with the sum of all those squares in the array
	public static int[] billify(int[] x) 
	{
		//Set up a new array, which has one more place than the original to store the new element
		int[] y = new int[x.length + 1];
		
		//fill in the array with the square-values and the sum of those squares
		int sum = 0;
		for(int i = 0; i < x.length; i++) 
		{
			y[i] = square(x[i]);
			sum += y[i];
		}
		y[x.length] = sum;		
		
		return y;
	}
	
	//add the square function which computes the square-value of any integers given to it
	//returns squared number results 
	private static int square(int a) 
	{
		return a * a;
	}
	// The "Billify" Function to test is complete
}
