package com.hcl.stepdefinitin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBpage {
	public static WebDriver driver;
	@Given("The customer is in fb page")
	public void the_customer_is_in_fb_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\renguadevi\\eclipse-workspace\\Greens\\CucumberSep10AM\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("The Custmer enters username and passwrd")
	public void the_Custmer_enters_username_and_passwrd() {
	  driver.findElement(By.xpath("//label[@for='done']")).click();
	  driver.findElement(By.id("fname")).sendKeys("Renu");
	  driver.findElement(By.id("lname")).sendKeys("Pavi");
	  driver.findElement(By.id("email")).sendKeys("renu123@gmail.com");
	  driver.findElement(By.name("addr")).sendKeys("chennai");
	  driver.findElement(By.id("telephoneno")).sendKeys("9876788778");
	}

	@When("Clicks ogin button")
	public void clicks_ogin_button() {
	   driver.findElement(By.name("submit")).click();
	}

	@Then("Customer see the home page")
	public void customer_see_the_home_page() {
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("uid"))
		{
		System.out.println("Success");
		}
		else
		{
			System.out.println("Failure");
		}
		driver.close();
	}


}
