import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;

/**
 * 
 * @author Haolin Guo
 * Deliverable 4 - Property-Based Testing - Testing part of the billifyFunction
 *
 */

public class billifyTest 
{
	// Define the default value of the number of tests (How many times will the test run)
	private final static int Test_Times = 10000;
	// Using the random function in Java to generate arrays
	private Random RD = new Random();

	// Define the function which generates the random array of different sizes to test function
	// Assume that all values passed in the array are positive integers between the values of 1 and 100 (inclusive)
	private int[] generateTestArray() 
	{
		// Define the array length from 1 - 100 (inclusive)
		int length = RD.nextInt(100) + 1;
		int[] Testarray = new int[length];
		
		// Generate random numbers between 1 - 100 (inclusive) and Fill the values in the array 
		for(int i = 0; i < Testarray.length; i++) 
		{
			Testarray[i] = RD.nextInt(100) + 1;
		}
		// Get the array to test 
		return Testarray;
		
	}
	
	// BillifyFunction Property Test 1:
	// As assumed, the result array of billifyFunction should compute and contains only the square-values and
	// the sum of those values, and due to the system assumes that there will be no nulls or zero-length arrays
	// and all original values passed in are positive integers. Hence, the first property that should always hold is  
	// that the result array only has positive integers, there will no negative or zero values in the result array anyway.
	
	@Test
	public void PropertyTest1() 
	{
		for(int i = 0; i < Test_Times; i++) 
		{
			int[] x = billifyFunction.billify(generateTestArray());
			
			for(int j = 0; j < x.length; j++) 
			{
				// Positive Test
				if(x[j] <= 0) 
				{ 
					fail();
				}
			}
		}
	}
	
	// BillifyFunction Property Test 2:
	// The second property that should always hold is that 
	// The size of the returned array should always be one larger than the size of the passed-in array
	// as the assumptions declared in the requirements. 
	
	@Test
	public void PropertyTest2() 
	{
		for(int i = 0; i < Test_Times; i++) 
		{
			int[] x = generateTestArray();
			int[] y = billifyFunction.billify(x);
			// Size Test
			if(y.length != (x.length + 1)) 
			{
				fail();
			}
		}
	}
	
	// BillifyFunction Property Test 3:  
	// The third property that should always hold is that 
	// As assumptions defined in the system requirements, the maximum number of elements in the passed-in array is 100.
	// Hence, the largest number in the output array should never be larger than 100 * 10000 = 1000000. 
	// i.e. each number generated in the passed-in array is the largest (100) and squared to 10000, also the size of array should be 100
	// to get this maximum number. The sum cannot be larger than 1000000 anyway.
	
	@Test
	public void PropertyTest3() 
	{
		for(int i = 0; i < Test_Times; i++) 
		{
			int[] x = billifyFunction.billify(generateTestArray());
			// Largest Number Test (sum)
			if(x[x.length - 1] > 1000000) 
			{
				fail();
			}
			// Largest Number Test (other elements)
			for(int j = 0; j < x.length - 1; j++) 
			{
				if(x[j] > 10000) 
				{
					fail();
				}
			}
		}
	}

}
