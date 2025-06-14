package TestNg;

import org.testng.annotations.Test;

public class FirstTestCases {

	@Test(priority=1)
	void openapp()
	{
		System.out.println("Opening Application");
	}
	@Test(priority=2)
	void login()
	{
		System.out.println("Loging in successfully");
	}
	@Test(priority=3)
	void logout()
	{
		System.out.println("Logout Successfully");
	}
}
