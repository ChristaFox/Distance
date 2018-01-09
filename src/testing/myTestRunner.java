/*******************************************************
* Name: Christa Fox
* Project 1
* This Assignment Explores the usefulness of JUnit for testing 
* purposes.
*******************************************************/

package testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class myTestRunner {
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(DistanceJUnitTests.class);
		for(Failure failure : result.getFailures()){
			System.out.println(failure.toString());
			
		}
		System.out.println("Test run:" + result.getRunCount());
		System.out.println("Test failed:" + result.getFailureCount());
		System.out.println("Test passed:" + (result.getRunCount() - result.getFailureCount()));

	}

}
