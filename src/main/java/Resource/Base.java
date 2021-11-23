package Resource;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Base 
{
	public WebDriver driv;
	public String url,PW,CW;
	public List<WebElement> Webele,Tr,Tc;
	public int TR,TC,i,j,Ub,Ran;
	public WebElement Tb,Temp;
	
	//initialize URL for Retail website
	public Base()
	{
		url="http://retailm1.upskills.in/";
	}
	
	//Initialize the WebDriver with ChromeDriver & return 
	public WebDriver initialize() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\G-Driver\\chromedriver.exe");
		driv=new ChromeDriver();
		return driv;
	}
	
	//to get the URL
	public String geturl()
	{
		return url;
	}
	
	//Using Actions
	public Actions ActionInit() {
		
		Actions act=new Actions(driv);
		return act;
	}
	
}
