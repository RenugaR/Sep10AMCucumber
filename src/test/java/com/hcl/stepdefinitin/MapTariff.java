package com.hcl.stepdefinitin;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MapTariff {
	public static WebDriver driver;
	@Given("The customers is in fb page")
	public void the_customers_is_in_fb_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\renguadevi\\eclipse-workspace\\Greens\\CucumberSep10AM\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("The Custmers enters username and passwrd and login button")
	public void the_Custmers_enters_username_and_passwrd_and_login_button(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String> a=dataTable.asMap(String.class,String.class);
		 driver.findElement(By.xpath("//label[@for='done']")).click();
		  driver.findElement(By.id("fname")).sendKeys(a.get("fanme"));
		  driver.findElement(By.id("lname")).sendKeys(a.get("lname"));
		  driver.findElement(By.id("email")).sendKeys(a.get("mail"));
		  driver.findElement(By.name("addr")).sendKeys(a.get("add"));
		  driver.findElement(By.id("telephoneno")).sendKeys(a.get("mobile"));
		  driver.findElement(By.name("submit")).click();

	}

	@Then("Customer see the home pages")
	public void customer_see_the_home_pages() {
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
