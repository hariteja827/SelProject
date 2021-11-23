/*package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import Resource.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ReturnDefinitions extends Base{
	
	Base b = new Base();      //Base Class Object
	
	    @Given("^Login with credentials$")      //function for Login
	    public void login_Return() throws Throwable  {
		 
		   //Initialize the driver with ChromeDriver
		   driv=b.initialize();
		
		   driv.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	       String mainurl="http://retailm1.upskills.in/";
	    
	       driv.get(b.geturl());
	       
	       //Assertion of MainURL with CurrentURl
	       Assert.assertEquals(mainurl,driv.getCurrentUrl());
	       
	       //Maximize the window
	       driv.manage().window().maximize();  //Maximize the window
	       
	       //Click on User Icon
	       driv.findElement(By.xpath("//*[@class='fa fa-user-o']")).click(); //click on User Icon
	      
	       //Login with Credentials
	       driv.findElement(By.xpath("//*[@name='email']")).sendKeys("rahulpadma999@gmail.com");
	       driv.findElement(By.xpath("//*[@name='password']")).sendKeys("Reddy@108");
	       driv.findElement(By.xpath("//*[@value='Login']")).click();	
			
	    }
	    
	    
	    @Given("^Click on My order history$")
	    public void click_on_my_order_history()  {
	    	
	    	//Click on My oreder history
	    	driv.findElement(By.xpath("//*[@id='System_nyHsmShk']/ul/li[1]/a")).click();
	      
	    }
	    
	    @And("^Click on Order Information$")
	    public void click_on_order_information()  {
	        
	    	//click on Order info.
	    	driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]/table/tbody/tr/td[7]/a/i")).click();
	    	
	    }

	    @And("^CLick on return button$")
	    public void click_on_return_button() {
	       
	    	//Click on Return 
	    	driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']//tbody/tr[1]/td[6]/a[2]")).click();
	    	
	    }

	    @And("^Enter the Details for Return$")
	    public void enter_the_details_for_return() {
	      
	    	//option of Fault	    	
	    	driv.findElement(By.xpath("//*[@id='return_request_form']//div[4]/div/div[2]//input")).click();
	    	
	    	//package is open or not
	    	driv.findElement(By.xpath("//*[@id='return_request_form']//div[5]/div/label[1]")).click();
	    	
	    	//Give Comments
	    	driv.findElement(By.xpath("//*[@id='input-comment']")).sendKeys("The Item was broken");	    	
	    	
	    }

	    @Then("^Click on Submit$")
	    public void click_on_submit()  {
	        
	    	//Submit
	    	driv.findElement(By.xpath("//*[@id='return_request_form']/div//input")).click();
	    	
	    	//Text after Submit 
	    	System.out.println(driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]/p[1]")).getText());
	    	System.out.println(driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]/p[2]")).getText());
	    	
	    	//Close the window
	    	driv.close();
	    }
	    

	    @Then("^display the Orders$")
	    public void display_the_orders() throws Throwable {
	        
	    	//Get the order information
	    	System.out.println(driv.findElement(By.tagName("table")).getText());

	    	
	    }

	    @And("^Click on Continue$")
	    public void click_on_continue() throws Throwable {
	        
	    	//Get Back to My account
	    	driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div/div[2]/div/a")).click();
	    	driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[3]/div/a")).click();
	    	driv.close();
	    }

	   

}*/
