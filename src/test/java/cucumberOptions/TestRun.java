package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\Features",
glue= "stepdefinitions",tags=" @content-when-empty")
public class TestRun  
{
	   
	
}   

   //  <---WISH-LIST--->
//@content-when-empty        -  display the content when Wish-List is Empty
//@functionality             -  Add items to wish-list
//@remove-items              -  Remove the item from Wish-List
//@Items-WishList-To-Cart    -  Add items to cart Min. 2 items in Wishlist

   //  <---CART-TO-CONFIRM-ORDER--->
//@Add-items                 -  Add Items to the Cart
//@Checkout-To-Confirm-Order -  Order from Cart

   //  <---RETURN-ITEMS--->
//@Return-Items              -  Return the Item

   //  <---ORDER-HISTORY--->
//@Order-History             -  Read the order History


