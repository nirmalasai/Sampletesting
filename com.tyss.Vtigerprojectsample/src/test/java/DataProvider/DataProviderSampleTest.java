package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSampleTest {

  @Test(dataProvider="cart")
  public void amazon(String name,String price)
	{
		System.out.println("product name="+name+"Product Price="+price);
	}

  @DataProvider(name="cart")
	public Object[][] addToCart()
	{
		Object[][] objArr=new Object[2][2];
		objArr[0][0]="vivo";
		objArr[0][1]="3000";
		
		objArr[1][0]="realme";
		objArr[1][1]="4000";
		
		return objArr;
		
}
}