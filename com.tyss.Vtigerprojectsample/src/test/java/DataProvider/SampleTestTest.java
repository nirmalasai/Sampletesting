package DataProvider;

import org.testng.annotations.Test;

public class SampleTestTest {
  @Test
  public void cat(){
	  
	 System.out.println("first method");
  }
  
  @Test(invocationCount = 1)
  public void dog(){
	  
		 System.out.println("second method");
	  }
  @Test(dependsOnMethods = "cow",alwaysRun = true)
  public void fish(){
	  
		 System.out.println("third method");
	  }
  @Test(enabled=false)
  public void cow(){
	  	//System.out.println(5/0);
		 System.out.println("fourth method");
	  }
}
