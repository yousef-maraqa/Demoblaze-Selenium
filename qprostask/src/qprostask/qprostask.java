package qprostask;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import java.io.*;
import java.lang.Thread;


public class qprostask {
	WebDriver driver = new ChromeDriver();
	Assertion Assertion = new Assertion();

	@BeforeTest
	public void MyBeforeTest() {
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		
	}

	@Test(priority = 1)
	public void Register() throws InterruptedException {
		driver.findElement(By.id("signin2")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("sign-username")).sendKeys("Yousef maraqa2");
		driver.findElement(By.id("sign-password")).sendKeys("123");
		driver.findElement(By.cssSelector("button[onclick='register()']")).click();
		Thread.sleep(2000);		
//		Assertion.assertNotEquals(driver.switchTo().alert().getText(), "This user already exist.");
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")).click();
	}
	
	@Test(priority = 2)
	public void Login() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("Yousef maraqa2");
		driver.findElement(By.cssSelector("#loginpassword")).sendKeys("123");
		driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();
	}

}
