package stepdefinitions;

import Resource.Base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import io.cucumber.java.en.And;


public class Definitions extends Base {
	
	    //Initiate Base class Object
	    Base b=new Base();
		WebDriver driv;
		
		@Given("^goto \"([^\"]*)\"$")
	    public void goto_something(String strArg1) throws IOException  {
	        
			
			//Initialize the driver
			  driv=b.initialize();
			
			//Timeout for 10 Seconds
			  driv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			//get the Website
			driv.get(strArg1);
			
	    }
		
		
		@Given("^Login with \"([^\"]*)\" & \"([^\"]*)\"$")
	    public void login_with_something_something(String strArg1, String strArg2) throws IOException  {
	      			
		    
		    //maximize the window
		      driv.manage().window().maximize();
		    
		    //Click on User Icon
		      driv.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();
		    
		    //Login
		      driv.findElement(By.xpath("//*[@name='email']")).sendKeys(strArg1);
		      driv.findElement(By.xpath("//*[@name='password']")).sendKeys(strArg2);
		      driv.findElement(By.xpath("//*[@value='Login']")).click();
			
	    }
		
	    //@functionality
		/*@Given("Login with user Credentials")
		public void Login() throws IOException  {
			
		    

			//Initialize the driver
			  driv=b.initialize();
			
			//Timeout for 10 Seconds
			  driv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Go to the URL given
		      driv.get(b.geturl());
		    
		    //maximize the window
		      driv.manage().window().maximize();
		    
		    //Click on User Icon
		      driv.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();
		    
		    //Login
		      driv.findElement(By.xpath("//*[@name='email']")).sendKeys("rahulpadma999@gmail.com");
		      driv.findElement(By.xpath("//*[@name='password']")).sendKeys("Reddy@108");
		      driv.findElement(By.xpath("//*[@value='Login']")).click();	
				
		}*/
		
		@Then("User clicks on wishlist icon")
		public void user_clicks_on_wishlist_icon() {
		    
			  //Click on wishList button Using Actions 
		      driv.navigate().refresh();
			  driv.findElement(By.xpath("//*[@class='ico-linea-basic-heart']")).click();
			
			
		}
		
		
		@Then("Wishlist content when empty")
		public void wishlist_content_when_empty() {
			
			  //Print the Content when WishList is Empty
		      b.PW=driv.findElement(By.xpath("//*[@class=\"tb_empty\"]")).getText();
		      System.out.println(b.PW);
		      
		      //Asserting the Message
		      Assert.assertEquals(b.PW,"Your wish list is empty.");
		      
		      //Closing the browser
		      driv.close();
		}

		
		@When("user adds item to the wish-list")
		public void items_to_wish_list() throws Throwable {
		    
			   //Back to Home page
			   driv.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a")).click();    
			
			   //JavaScript to Scroll the Web-page by 1600 pixels along Y-axis
			   JavascriptExecutor jg=(JavascriptExecutor) driv;
			   jg.executeScript("window.scrollBy(0,1600)");
			
			   //Storing WebElements of Featured-products WishList Buttons
			   b.Webele= driv.findElements(By.xpath("//*[@class='tb_button_wishlist tb_pos_b btn-sm tb_no_text']"));
			   System.out.println(b.Webele.size());
			
			   //Click on first Product
		       b.Webele.get(1).click();
			
		}

		@When("Message when items added")
		public void message_for_wishlist() throws Throwable {
			
		       //Printing Message When Items added
		   	   b.PW=driv.findElement(By.xpath("/html/body/ul")).getText();
		   	   System.out.println(b.PW);
			
		}
		
		
		
		@Then("Content is displayed")
	    public void content_is_displayed() {
	        
			   //Print the Item details
			   b.Tr=driv.findElements(By.xpath("//*[@class='table table-hover']/tbody/tr"));
			   b.Tc=driv.findElements(By.xpath("//*[@class='table table-hover']/thead/tr/td"));
			   
			   //No.of Rows & columns of Items
			   b.TC=b.Tc.size()-2;
			   b.TR=b.Tr.size();
			   for(i=1;i<b.TC;i++)
			   {
				  for(j=2;j<b.TR;j++)
				  {
				     	System.out.println(driv.findElement(By.xpath("//*[@class='table table-hover']/tbody/tr["+i+"]/td["+j+"]")).getText());
				  }
			   }
			
	    }
		
		
		
		@When("Click on Item-remove button")
		public void click_on_remove_button() {
			
			    //Click on Remove 
		        b.Webele = driv.findElements(By.xpath("//*[@id='System_s3bhXNDb']//tbody//td[6]/a/i"));
		        System.out.println(b.Webele.size());
		        b.Webele.get(1).click();
		}

		@Then("Item is Removed")
		public void item_is_removed() {
			
			    //Message When Removed
		        System.out.println(driv.findElement(By.xpath("//div[@class='alert alert-success']")).getText()); 
		    
		        //Close the Browser
		        driv.close();
		}
		
		@When("user clicks on Cart Icon")
		public void user_clicks_on_cart_icon() {
			 
			    //Click on cart icon 
		        b.Webele = driv.findElements(By.xpath("//*[@id='System_s3bhXNDb']//tbody/tr//button"));
		        System.out.println(b.Webele.size());
		        b.Webele.get(1).click();
		}

  		@Then("Items Must be added to cart")
		public void items_must_be_added_to_cart() {
			 
			    //Message when Added to cart 
			    System.out.println(driv.findElement(By.xpath("//*[@class='noty_text']")).getText());
			
			    //Close the Browser
			    driv.close();
		}

  		/////////////////////////  Cart  ////////////////////////////
  		
  		
		@Given("^Login with user credentials$")      //function for Login
		public void login_with_user_credentials() throws Throwable  {
		 		 
		 		//Initialize the driver with ChromeDriver
		 		driv=b.initialize();
		 		
		 		//Implicit wait by 10 Seconds
		 		driv.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 		
		 	    
		 	    //Get URL using Driver
		 	    driv.get(b.geturl());
		 	    
		 	    //maximize the window  
		 	    driv.manage().window().maximize();
		 	    
		 	    //Click on user Icon
		 	    driv.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();
		 	      
		 	    //Login
		 	    driv.findElement(By.xpath("//*[@name='email']")).sendKeys("rahulpadma999@gmail.com");
		 	    driv.findElement(By.xpath("//*[@name='password']")).sendKeys("Reddy@108");
		 		driv.findElement(By.xpath("//*[@value='Login']")).click();	
		 			
		}

		@Given("^Click on Cart Icon$")
		public void click_on_cart_icon()  {
		 				
		 		String carturl = "http://retailm1.upskills.in/checkout/cart";
		 		
		 		//Click on Cart Icon
		 		driv.findElement(By.xpath("//*[@class='tb_icon ico-linea-ecommerce-bag']")).click();
		 		Assert.assertEquals(carturl,driv.getCurrentUrl());
		}
		 	
        @Given("^Items are in the Cart$")
		public void items_in_the_cart()   {
		     	
		     	//Print the Item Details in the cart
		     	
		     	//No. of Rows
		         b.Tr=driv.findElements(By.xpath("//*[@class='cart-info tb_min_w_500']/table/tbody/tr"));
		         b.TR=b.Tr.size();
		         
		         //No. of Columns
		         b.Tc=driv.findElements(By.xpath("//*[@class='cart-info tb_min_w_500']/table/thead/tr/td"));
		         b.TC=b.Tc.size();
		   
		         for(int j=1;j<b.TR;j++)
		         {
		           for(int i=2;i<b.TC;i++) 
		           {   
		     	    if(i!=5)
		     	    {
		     		   System.out.println(driv.findElement(By.xpath("//*[@class='cart-info tb_min_w_500']/table/tbody/tr["+j+"]/td["+i+"]")).getText());
		     	    }
		           }
		         }      
		        
		}
		@And("^Enter Coupon Code$")
		public void enter_coupon_code()  {
		     	
		     	//Click on Enter Coupon
		     	driv.findElement(By.xpath("//*[@id='accordion']/div[1]/div[1]//i")).click();
		     	
		     	//Given Coupon Code in the Box & Click on Apply
		     	driv.findElement(By.xpath("//*[@id='input-coupon']")).sendKeys("RETAIL50");
		     	driv.findElement(By.xpath("//*[@id='button-coupon']")).click();
		     	
		     	//Print the Message when Coupon Code is Added 
		     	System.out.println(driv.findElement(By.xpath("//*[@id='System_V2Exp1o9']/div[1]")).getText());
		     	
		     	//Print the Total After Applying Coupon Code
		     	System.out.println(driv.findElement(By.xpath("//*[@class='cart-total']")).getText()+"\n");
		}

        @And("^Enter Country Pincode State$")
		public void enter_country_pincode_state() {
		     	
        	    
        	    
		     	//Refresh the Page to load
		     	driv.navigate().refresh();
		     	
		     	//Given Country,Region,PinCode
		     	driv.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]/h4/a/i")).click();
		     	b.Temp=driv.findElement(By.xpath("//*[@name='country_id']"));
		     	
		     	//Selecting Country,Region in drop-down using Select
		     	Select Sel = new Select(b.Temp);
		     	Sel.selectByVisibleText("India");
		     	b.Temp=driv.findElement(By.xpath("//*[@name='zone_id']"));
		     	Sel = new Select(b.Temp);
		     	Sel.selectByVisibleText("Telangana");
		     	b.Tb=driv.findElement(By.xpath("//*[@name='postcode']"));
		     	
		     	//Clear the text box
		     	b.Tb.clear();
		     	b.Tb.sendKeys("506009");
		     	
		     	//Click on Get-Quotes
		     	driv.findElement(By.xpath("//*[@id='button-quote']")).click();
		     	
		     	//Click on free-Shipping & apply
		     	driv.findElement(By.xpath("//*[@id='shipping_quote']/div/label")).click();
		     	driv.navigate().refresh();
		}

		@And("^Enter GiftCertificate$")
		public void enter_giftcertificate() {
		     	
		     	//Refresh the page
		     	driv.navigate().refresh();

		     	//Click on Apply Gift certificate & enter the Code
		     	driv.findElement(By.xpath("//*[@id=\"accordion\"]/div[3]/div[1]/h4/a/i")).click();
		     	driv.findElement(By.xpath("//*[@id='input-voucher']")).sendKeys("RETAIL50");
		     	driv.findElement(By.xpath("//*[@id='button-voucher']")).click();
		     	
		     	//Message after the gift certificate
		     	System.out.println(driv.findElement(By.xpath("//*[@id='System_V2Exp1o9']/div[1]")).getText());
		     	
		     	//Cart Total After Applying Gift-certificate 
		     	System.out.println(driv.findElement(By.xpath("//*[@class='cart-total']")).getText());
		}

		@When("^Click on CheckOut$")
		public void click_on_checkout()   {
		     	
		     	//Click on Check-out
		     	driv.findElement(By.xpath("//*[@id='System_V2Exp1o9']/div[4]/div[2]/a")).click();
		}

		     
		@And("^Enter Billing & Delivery Address$")
		public void enter_billing_delivery_address()  {

		     	//Click on Apply billing,delivery,Payment Addresses
		     	driv.findElement(By.xpath("//*[@id='collapse-payment-address']/div/div[1]/label/input")).click();
		     	driv.findElement(By.xpath("//*[@id='button-payment-address']")).click();
		     	driv.findElement(By.xpath("//*[@id='button-shipping-address']")).click();
		}

		@And("^Select Delivery Method$")
		public void select_delivery_method()  {
		     	
		     	//Select the Delivery Method & Give Comments
		     	driv.findElement(By.xpath("//*[@name='comment']")).sendKeys("Please deliver in time period from 9:00A.M - 18:00P.M");
		     	driv.findElement(By.xpath("//*[@id='button-shipping-method']")).click();
		}

		@And("^Select Payment Method$")
		public void select_payment_method()  {
		     	
		     	//Select Payment method
		     	driv.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[1]//label/input")).click();
		     	
		}

        @And("^Accept Terms & Conditions$")
		public void accept_terms_conditions()  {
		     	
		     	//Accept Terms & Conditions 
		     	driv.findElement(By.xpath("//*[@class='checkbox']/input")).click();
		     	driv.findElement(By.xpath("//*[@id='button-payment-method']")).click();
		}
		     
		@Then("^Display the details$")
		public void display_the_details() throws Throwable {
		     	
		     	//Print the Items Details
		     	b.Tr=driv.findElements(By.xpath("//*[@id='collapse-checkout-confirm']//table/tbody/tr"));
		     	b.TR=b.Tr.size();
		     	b.Tc=driv.findElements(By.xpath("//*[@id='collapse-checkout-confirm']//table/thead/tr/td"));
		     	b.TC=b.Tc.size();
		     	for(int i=1;i<b.TR;i++)
		     	{
		     		for(int j=1;j<b.TC;j++)
		     		{
		     			System.out.println(driv.findElement(By.xpath("//*[@id='collapse-checkout-confirm']//table/tbody/tr["+i+"]/td["+j+"]")).getText());
		     		}
		     	}
		 		System.out.println(driv.findElement(By.xpath("//*[@class='table']//tfoot/tr[4]/td[2]")).getText());
		 		System.out.println(driv.findElement(By.xpath("//*[@class='table']//tfoot/tr[4]/td[3]")).getText());


		} 

		@And("^Click on confirm$")
		public void click_on_confirm() {
		     	
		     	//Click on Confirm
		     	driv.findElement(By.xpath("//*[@value='Confirm Order']")).click();
		     	
		     	//Message After Confirming the order
		 		System.out.println(driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]")).getText());
		 		
		 		//Click on Continue Shopping
		 		driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[2]/div/a")).click();

		}

		@Given("^Click on Home page$")
		public void home_page() throws Throwable  {
		     	
		     	//Click on Home Page
		        driv.navigate().refresh();	
		     	driv.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a/span")).click();	
		     			    	
		}
		     
		@And("^Click on a product$")
		public void a_product()  {
		     
		     	
		         driv.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a")).click();    
		 		
		         //Scroll down the WebPage By 1600pixels in y-axis
		 		JavascriptExecutor jg=(JavascriptExecutor) driv;
		 		jg.executeScript("window.scrollBy(0,1600)");
		 		
		 		//Click on random Item
		 		
		 		//Elements of the Items Present
		 		b.Webele= driv.findElements(By.xpath("//*[@id='RandomProducts_RoiFQGb2']//h4/a"));
		 		
		 		//Size of the Elements
		 		System.out.println(b.Webele.size());
		 		Random ran = new Random();
		 	    b.Ub=b.Webele.size();
		 	    
		 	    //Generate a Random Number
		 		b.Ran=ran.nextInt(b.Ub);
		 		if(b.Ran==0)
		 			b.Ran+=1;
		 		//Click on Random product
		 		driv.findElement(By.xpath("//*[@id=\"RandomProducts_RoiFQGb2\"]//div["+b.Ran+"]//h4/a")).click();	
		    	
		}

        @And("^check the Availability$")
		public void check_the_availability()  {
		     	 
		     	//Print the Availability   	
		 	    System.out.println(driv.findElement(By.xpath("//*[@id='ProductInfoSystem_IcyE9WlD']//dd[1]")).getText());
		             
		}

        @And("^Increase the quantity$")
		public void increase_the_quantity()  {
		         
		     	//Increase the Quantity By 1
		     	driv.findElement(By.xpath("//*[@id='ProductAddToCartSystem_C8WkgNNi']/div[2]//button[1]/i")).click();
		     	
		}

		     
        @When("^Click on add to cart$")
		public void click_on_add_to_cart()  {
		     	
		     	//Refresh the Page by & add the Item to the cart
		        driv.navigate().refresh();
		     	driv.findElement(By.xpath("//*[@id='button-cart']")).click();
		  	
		}

        @Then("^Items added$")
		public void items_added()  {
		         
		     	//Message When Item Added
		 	    System.out.println(driv.findElement(By.xpath("//*[@id='noty_alert_1637379459525']/div/div[1]/div/p")).getText());
		     	
		}  
		     
        @Given("^Login with credentials$")      //function for Login
 	    public void login_Return() throws Throwable  {
 		 
 		        //Initialize the driver with ChromeDriver
 		        driv=b.initialize();
 		
 		        driv.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 		
 		        String mainurl="http://retailm1.upskills.in/";
 	    
 		        //Get the URL
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
 	    public void display_the_orders()  {
 	        
 	    	    //Get the order information
 	    	    System.out.println(driv.findElement(By.tagName("table")).getText());

 	    	
 	    }

 	    @And("^Click on Continue$")
 	    public void click_on_continue()  {
 	        
 	    	    //Get Back to My account
 	    	    driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div/div[2]/div/a")).click();
 	    	    driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[3]/div/a")).click();
 	    	
 	    	    //Close the driver
 	    	    driv.close();
 	    }
 		     			     	    
}

		 
		 
	



