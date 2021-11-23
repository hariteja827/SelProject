/*package stepdefinitions;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import Resource.Base;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartDefinitions extends Base { 
	
	Base b = new Base();      //Base Class Object
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

	@Then("^Click on Cart Icon$")
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
        Tr=driv.findElements(By.xpath("//*[@class='cart-info tb_min_w_500']/table/tbody/tr"));
        TR=Tr.size();
        
        //No. of Columns
        Tc=driv.findElements(By.xpath("//*[@class='cart-info tb_min_w_500']/table/thead/tr/td"));
        TC=Tc.size();
  
        for(int j=1;j<TR;j++)
        {
          for(int i=2;i<TC;i++) 
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
    	Temp=driv.findElement(By.xpath("//*[@name='country_id']"));
    	
    	//Selecting Country,Region in drop-down using Select
    	Sel = new Select(Temp);
    	Sel.selectByVisibleText("India");
    	Temp=driv.findElement(By.xpath("//*[@name='zone_id']"));
    	Sel = new Select(Temp);
    	Sel.selectByVisibleText("Telangana");
    	Tb=driv.findElement(By.xpath("//*[@name='postcode']"));
    	
    	//Clear the text box
    	Tb.clear();
    	Tb.sendKeys("506009");
    	
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
    	Tr=driv.findElements(By.xpath("//*[@id='collapse-checkout-confirm']//table/tbody/tr"));
    	TR=Tr.size();
    	Tc=driv.findElements(By.xpath("//*[@id='collapse-checkout-confirm']//table/thead/tr/td"));
    	TC=Tc.size();
    	for(int i=1;i<TR;i++)
    	{
    		for(int j=1;j<TC;j++)
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
		Ran=ran.nextInt(b.Ub);
		/*b.Webele.get(1).click();
		System.out.println(driv.findElement(By.xpath("/html/body/ul")).getText());*/
	/*	driv.findElement(By.xpath("//*[@id=\"RandomProducts_RoiFQGb2\"]//div["+Ran+"]//h4/a")).click();	
   	
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
    
}*/
