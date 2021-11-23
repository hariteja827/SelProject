/*package stepdefinitions;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Resource.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class WishlistDefinitions extends Base
{
	    Base b=new Base();
        WebElement el;
    
    
    //@functionality
	@Given("Login with user Credentials")
	public void Login() throws Throwable {
		
		//Initialize the driver
		driv=b.initialize();
		
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
		System.out.println(driv.findElement(By.xpath("/html/body/ul")).getText());
		
	}
	
	@Then("User clicks on wishlist icon")
	public void user_clicks_on_wishlist_icon() {
	    
		//Click on wishList button Using Actions 
	    driv.navigate().refresh();
		driv.findElement(By.xpath("//*[@class='ico-linea-basic-heart']")).click();
		//ActionInit().moveToElement(el).click().build().perform();
		
	}
	
	@Then("Content is displayed")
    public void content_is_displayed() {
        
		//Print the Item details
		b.Tr=driv.findElements(By.xpath("//*[@class='table table-hover']/tbody/tr"));
		b.Tc=driv.findElements(By.xpath("//*[@class='table table-hover']/thead/tr/td"));
		TC=b.Tc.size()-2;
		TR=b.Tr.size();
		for(i=0;i<TR;i++)
			for(j=0;j<TC;j++)
			{
				System.out.println(driv.findElement(By.xpath("//*[@class='table table-hover']/tbody/tr["+i+"]/td["+j+"]")));
			}
		System.out.println(TR);
		
    }
	
	@Then("Wishlist content when empty")
	public void wishlist_content_when_empty() {
		
		//Print the Content when WishList is Empty
	    System.out.println(driv.findElement(By.xpath("//*[@class=\"tb_empty\"]")).getText());
	    
	    //Closing the browser
	    driv.close();
	}
	
	@When("Click on Item-remove button")
	public void click_on_remove_button() {
		
		//Click on Remove 
	    b.Webele = driv.findElements(By.xpath("//*[@class='btn btn-danger tb_no_text']"));
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
	    b.Webele = driv.findElements(By.xpath("//*[@class=\"btn btn-primary tb_no_text\"]"));
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

	 
	 
	 
	 
}*/
