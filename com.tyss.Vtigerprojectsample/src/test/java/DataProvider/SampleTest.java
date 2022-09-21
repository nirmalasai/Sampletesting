package DataProvider;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SampleTest{
	@Ignore
	@Test
  public void cat(){
	 System.out.println(5/0);
	 System.out.println("first method");
  }
  
  @Test(dependsOnMethods = {"cat"},ignoreMissingDependencies = true)
  public void dog(){
	  
		 System.out.println("second method");
	  }
  @Test
  public void fish(){
	  
		 System.out.println("third method");
	  }
  @Test(dependsOnMethods = "fish")
  public void cow(){
	  
		 System.out.println("fourth method");
	  }
}
