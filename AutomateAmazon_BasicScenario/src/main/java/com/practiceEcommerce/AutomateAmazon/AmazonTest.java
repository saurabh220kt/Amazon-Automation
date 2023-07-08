package com.practiceEcommerce.AutomateAmazon;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurabh\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement searchbox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		searchbox.sendKeys("Iphone xr");
		searchbox.submit();	
		driver.findElement(By.linkText("Apple iPhone 12 (64GB) - Purple")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();
				if(!parent.equals(child_window))
				{
					driver.switchTo().window(child_window);
					System.out.println(driver.switchTo().window(child_window).getTitle());
				}
		}
		driver.findElement(By.xpath("//img[@alt=\"Blue\"]")).click();
		try {
		driver.findElement(By.xpath("//input[@id=\"buy-now-button\"]")).click();
		}catch(Exception e) {
			System.out.println("Exception got handled");
		}
	}
}









