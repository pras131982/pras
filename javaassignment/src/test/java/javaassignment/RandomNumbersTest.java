package javaassignment;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomNumbersTest {
	
    @Before
    public void setUp() {
        //System.out.println("@Before - runBeforeTestMethod");
    }

    @After
    public void tearDown() {
        //System.out.println("@After - runAfterTestMethod");
    }
	

	   @Test
	   public void testValidateRandomNumbers() {
		   int[] intarray = new RandomNumbers().getIntArray();
		   assertTrue(intarray.length == 1000);   
		   assertTrue(new RandomNumbers().findLargest(intarray) < 1000); 
	   }
	   
	   @Test
	   public void testRandomNumberforIntercept() {
		   List<Integer> alResponse = new RandomNumbers().processRandomNumbers();
		   assertTrue(alResponse != null && !alResponse.isEmpty());   
	   }
	   
	   

}
