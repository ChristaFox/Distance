/*******************************************************
* Name: Christa Fox
* Project 1
* This Assignment Explores the usefulness of JUnit for testing 
* purposes.
*******************************************************/

package testing;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

import classes.Distance;

public class DistanceJUnitTests 
{
	//feilds
	int expectedFeet;
	int actualFeet;
	int expectedInches;
	int actualInches;

	/**
	 * Create a new distance object of 0 feet and 0 inches.
	 */
	@Test
	public void testConstructor1()
	{
		Distance d1 = new Distance(0,0);
		assertEquals(d1.getFeet(), 0);
		assertEquals(d1.getInches(), 0);
	}
	
	/**
	 * Create a distance object with the default 
	 * values.
	 */
	@Test
	public void testConstructor2()
	{
		Distance d2 = new Distance(); 
		assertEquals(d2.getFeet(), 1);
		assertEquals(d2.getInches(), 1);
	}
	
	/**
	 * Create a new distance object of 3 feet, 2
	 * inches.
	 */
	@Test
	public void testConstructor3()
	{
		Distance d3 = new Distance(3, 2);
		assertEquals(d3.getFeet(), 3);
		assertEquals(d3.getInches(), 2);
	}
			
	/**
	 * Create a distance object with invalid values input.
	 * This should throw an exception.
	 */
	@Test
	public void testConstructor4() throws InputMismatchException
	{
		try
		{
			Distance d4 = new Distance(-1, 1);
		}
		catch (InputMismatchException e)
		{
			assertEquals(e.getMessage(), "That is not a valid amount of feet.");
		}
	}
		
	/**
	 * Create a distance object of many feet and 1 inch.
	 */
	@Test	
	public void testConstructor5()
	{
		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
		assertEquals(d5.getFeet(), Integer.MAX_VALUE);
		assertEquals(d5.getInches(), 1);
	}
		
	/**
	 * An exception should be thrown when trying to set a min 
	 * value (very large negative number) as a distance value.
	 */
	@Test
	public void testConstructor6() throws InputMismatchException
	{
		try
		{
			Distance d6 = new Distance(Integer.MIN_VALUE, 1);
		}
		catch (InputMismatchException e)
		{
			assertEquals(e.getMessage(), "That is not a valid amount of feet.");
		}
	}
		
	/**
	 * Set the amount of feet in d1 to 3.
	 */
	@Test
	public void testSet1()
	{
		Distance d1 = new Distance(0,0);
		d1.setFeet(3);
		assertEquals(d1.getFeet(), 3);
	}
	
	/**
	 * Attempt to set an amount of feet that is 
	 * invalid; an exception should be thrown.
	 */
	@Test
	public void testSet2() throws InputMismatchException
	{
		try
		{
			Distance d2 = new Distance(3, 4);
			d2.setFeet(-3);
			assertEquals(d2.getFeet(), 3);
		}
		catch (InputMismatchException e)
		{
			assertEquals(e.getMessage(), "That is not a valid amount of feet.");
		}
	}
	
	/**
	 * An invalid number of inches should throw an
	 * InvalidInputException.
	 */
	@Test
	public void testSet3() throws InputMismatchException
	{
		try
		{
			Distance d2 = new Distance(3, 4);
			d2.setInches(-10);
		}
		catch (InputMismatchException e)
		{
			assertEquals(e.getMessage(), "That is not a valid amount of inches.");
		}
	}
	/**
	 * Returns the amount of feet in the distance
	 * object.
	 */
	@Test
	public void testGetFeet()
	{
		Distance d3 = new Distance(3, 2);
		assertEquals(d3.getFeet(), 3);
	}
	
	/**
	 * Returns the amount of inches in the distance
	 * object.
	 */
	{
		Distance d3 = new Distance(3, 2);
		assertEquals(d3.getInches(), 2);
	}

	/**Add 2 distance methods.  It converts them to 
	 * inches, and then back to inches and feet in 
	 * the getDistance method.
	 */
	@Test
	public void testAddDistance1() 
	{
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		expectedFeet = 1;
		expectedInches = 1;
		Distance d = d1.addDistance(d1, d2);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());
	}
	
	/**Add 2 distance methods. It converts them to 
	 * inches, and then back to inches and feet in 
	 * the getDistance method.
	 */
	@Test 
	public void testAddDistance2() throws InputMismatchException
	{
		try
		{
			Distance d3 = new Distance(3, 2);
			Distance d4 = new Distance(-1, 1);
			expectedFeet = 4;
			expectedInches = 3; 
			Distance d = d3.addDistance(d3, d4);
			assertEquals(expectedFeet, d.getFeet());
			assertEquals(expectedInches, d.getInches());
		}
		catch (InputMismatchException e)
		{
			assertEquals(e.getMessage(), "That is not a valid amount of feet.");
		}
	}
	
	/**Add 2 distance methods it converts them to 
	 * inches, and then back to inches and feet in 
	 * the getDistance method.
	 */
	@Test (expected = InputMismatchException.class)
	public void testAddDistance3() 
	{
		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
		Distance d6 = new Distance(Integer.MIN_VALUE, 1);
		expectedFeet = 0;
		expectedInches = 2;
		Distance d = d5.addDistance(d5, d6);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());
	}
	
	/**Subtract 2 distance methods.  It converts them to 
	 * inches, and then back to inches and feet in the 
	 * getDistance method.
	 */
	@Test
	public void testSubDistance1() 
	{
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		expectedFeet = 1;
		expectedInches = 1;
		Distance d = d1.addDistance(d1, d2);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());		
	}
	
	/**Subtract 2 distance methods it converts them to 
	 * inches, and then back to inches and feet in the 
	 * getDistance method.
	 */
	@Test
	public void testSubDistance2() throws InputMismatchException 
	{
		try 
		{
			Distance d3 = new Distance(3, 2);
			Distance d4 = new Distance(-1, 1);
			expectedFeet = 2;
			expectedInches = 1;
			Distance d = d3.addDistance(d3, d4);
		}
		
		catch (InputMismatchException e)
		{
			assertEquals(e.getMessage(), "That is not a valid amount of feet.");
		}
		
    }
	
	/**Subtract 2 distance methods it converts them 
	 * to inches, and then back to inches and feet 
	 * in the getDistance method.
	 */
	@Test (expected = InputMismatchException.class)
	public void testSubDistance3() 
	{
		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
		Distance d6 = new Distance(Integer.MIN_VALUE, 1);
		expectedFeet = 0;
		expectedInches = 0;
		Distance d = d5.addDistance(d5, d6);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());
	}
	
	/**
	 * test less than zero
	 */
	@Test (expected = InputMismatchException.class)
	public void testLessThanZero()
	{
		Distance d = new Distance(-1, 1);	
	}
	
	/**Check that 2 methods that are not equal are 
	 * defined as such.
	 */
	@Test
	public void testEquals1() 
	{
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		assertEquals(false, d1.equals(d2));
	}
	
	/**Check that 2 methods that are equal are defined 
	 * as such.
	 */
	@Test (expected = InputMismatchException.class)
	public void testEquals2() 
	{
		Distance d2 = new Distance();
		Distance d4 = new Distance(-1, 1);
		assertEquals(true, d2.equals(d4));
	}

}
