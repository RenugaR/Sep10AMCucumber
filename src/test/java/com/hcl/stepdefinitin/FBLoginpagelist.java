package com.hcl.stepdefinitin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class FBLoginpagelist {
	public static WebDriver driver;
	@Given("The user is in fb page")
	public void the_user_is_in_fb_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\renguadevi\\eclipse-workspace\\Greens\\CucumberSep10AM\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("The user enters username and passwrd and cicks sumbit button")
	public void the_user_enters_username_and_passwrd_and_cicks_sumbit_button(DataTable dataTable) {
			List<String> a=dataTable.asList(String.class);
			 driver.findElement(By.xpath("//label[@for='done']")).click();
			  driver.findElement(By.id("fname")).sendKeys(a.get(0));
			  driver.findElement(By.id("lname")).sendKeys(a.get(1));
			  driver.findElement(By.id("email")).sendKeys(a.get(2));
			  driver.findElement(By.name("addr")).sendKeys(a.get(3));
			  driver.findElement(By.id("telephoneno")).sendKeys(a.get(4));
			  driver.findElement(By.name("submit")).click();
	}

	@Then("user see the home page")
	public void user_see_the_home_page() {
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
