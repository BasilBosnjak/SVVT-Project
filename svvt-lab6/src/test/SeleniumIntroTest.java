package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumIntroTest {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Basil\\Desktop\\chromedriver.exe");
		webDriver = new ChromeDriver();
		baseUrl = "https://ibu.edu.ba";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}


	@Test
	// Testing whether the login will fail after inputing invalid credentials
	void falseLogin() throws InterruptedException {
		webDriver.get("https://admin.staging.wowflow.org/login");
		Thread.sleep(2000);
		
		WebElement username = webDriver.findElement(By.name("email"));
		username.sendKeys("john.doe@gmail.com");
		Thread.sleep(1000);
		
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys("12345678");
		Thread.sleep(1000);
		
		WebElement signIn = webDriver.findElement(By.name("sign in"));
		signIn.click();
		Thread.sleep(2000);
		
		String Dashboard = webDriver.getCurrentUrl();
		assertNotEquals("https://admin.staging.wowflow.org/dashboard/issues", Dashboard);
		Thread.sleep(2000);
	}
	
	@Test
	// Testing whether the login will fail after inputing invalid credentials
	void siteLogin() throws InterruptedException {
		webDriver.get("https://admin.staging.wowflow.org/login");
		Thread.sleep(2000);
		
		WebElement username = webDriver.findElement(By.name("email"));
		username.sendKeys("adokce+admin2@gmail.com");
		Thread.sleep(1000);
		
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys("testtest");
		Thread.sleep(1000);
		
		WebElement signIn = webDriver.findElement(By.name("sign in"));
		signIn.click();
		Thread.sleep(2000);
		
		String Dashboard = webDriver.getCurrentUrl();
		assertEquals("https://admin.staging.wowflow.org/dashboard/issues", Dashboard);
		Thread.sleep(2000);
	}


}

