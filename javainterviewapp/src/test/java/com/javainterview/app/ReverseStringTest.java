
import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ArrayInterview.ReverseString;

public class ReverseStringTest {
    
    ReverseString reverseString;
    
	@BeforeSuite
	public void testBeforeSuite() {
		System.out.println("testBeforeSuite() creating reverseString");
		reverseString = new ReverseString();
	}
 
	@AfterSuite
	public void testAfterSuite() {
		System.out.println("testAfterSuite()");
	}
 
	@BeforeTest
	public void testBeforeTest() {
		System.out.println("testBeforeTest()");
	}
 
	@AfterTest
	public void testAfterTest() {
		System.out.println("testAfterTest()");
	}
 
    @Test
    public void printReverseString() {
        String reverse = reverseString.reverseString( "abcdefg" );
        String result = "gfedcba";
        assertEquals(reverse, result);
    }
    
    @Test
    public void printReverseStringInPlace() {
        String reverse = reverseString.reverseStringInPlace( "abcdefg" );
        String result = "gfedcba";
        assertEquals(reverse, result);
    }
}