package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\\\Users\\\\hd\\\\Documents\\\\selenium dependencies\\\\drivers\\\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		//Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		//Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		//Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.linkText("Order")).click();
		//Thread.sleep(1000);
		WebElement toClear=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		Random rd=new Random();
		String q=String.valueOf(rd.nextInt(101));
		toClear.sendKeys(q);
		
		char midName=(char)(rd.nextInt(26)+65);
		//Thread.sleep(1000);
		String klm="John "+midName+" Smith";
		WebElement h=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
		h.sendKeys(klm);
		//Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Lillian St");
		//Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Arlington HTS");
		//Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("IL");
		//Thread.sleep(1000);
		String zip="";
		for (int i = 0; i <5; i++) {
			zip+=rd.nextInt(10);
			
		}
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
		String d=String.valueOf(rd.nextInt(3));
		WebElement k=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+d));
		k.click();
		String visa="4";
		String mastercard="5";
		String american="3";
		switch (d) {
		case "0":
			for (int i = 0; i < 15; i++) {
				
				visa+=rd.nextInt(10);
			}
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(visa);

			break;
		case "1":
			for (int i = 0; i < 15; i++) {
				
				mastercard+=rd.nextInt(10);
				
			}
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(mastercard);
			break;
		case "2":
			for (int i = 0; i < 15; i++) {
				
				american+=rd.nextInt(10);
				
			}
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(american);
			break;

		}
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("06/21");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		Thread.sleep(2000);
		WebElement verify=driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"));
		if(verify.getText().contains("New order has been successfully added.")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
		
		
		

	}

}
