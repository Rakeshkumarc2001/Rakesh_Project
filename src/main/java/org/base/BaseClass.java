package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class  BaseClass {
	
	   public static WebDriver driver;
	
	public static WebDriver chromeBrowser() {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		return driver;
		 
	}
	
	public static  void urlLaunch(String url) {
		
		driver.get(url);
		
		driver.manage().window().maximize();
        
	}
	
	public static void ImplicitlyWait(int a) {
		
		driver.manage().timeouts().implicitlyWait(a,TimeUnit.SECONDS);	

	}
	
	public static void sendKeys(WebElement e,String value) {
		
		e.sendKeys(value);

	}
	
	public static  void click(WebElement e) {
		e.click();
		
	}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;	
	}
	public static void quit() {
		driver.quit();

	}
	public static String getText(WebElement e) {
		 String text = e.getText();
		return text;
		
	}
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	
	public static void clear(WebElement e) {
		e.clear();

	}
	
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
        a.moveToElement(target);
		
	}
	public static void dragAndDrop(WebElement src,WebElement tar) {
		Actions a=new Actions(driver);
        a.dragAndDrop(src,tar);
	}
	
	public static void contextClick(WebElement target) {
		Actions a=new Actions(driver);
		a.contextClick(target);
		
	}
	public static void doubleClick(WebElement tar) {
		Actions a=new Actions(driver);
		a.doubleClick(tar);
		
	}
	
	private void simpleAlert() {
		Alert sa = driver.switchTo().alert();
		sa.accept();
		
	}
	
	public static void confirmAlert() {
	    Alert ca = driver.switchTo().alert();
        ca.dismiss();
	
	}
	
	public static void promptAlert() {
	    Alert pa =driver.switchTo().alert();	
        pa.accept();
	}

	public static void selectByIndex(WebElement e,int a) {
		Select s=new Select(e);
        s.selectByIndex(a);
	}
	
    public static void selectByValue(WebElement e,String a) {
		Select s=new Select(e);
        s.selectByValue(a);
	}    
	public static void selectByVisibleText(WebElement e,String a) {
		Select s=new Select(e);
		s.selectByVisibleText(a);
		
	}
	public static void getOption(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		for(int i=0;i<options.size();i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);		
		}                                                           
	}
	public static void getAllSelectedOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement x : allSelectedOptions) {
			String text = x.getText();
			System.out.println(text);
		}
	}


}

