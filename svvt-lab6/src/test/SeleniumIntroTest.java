package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

class SeleniumIntroTest {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Basil\\Desktop\\chromedriver.exe");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.demoblaze.com/index.html";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

		
	@Test
	//Testing the login
	void login() throws InterruptedException {
		webDriver.manage().window().maximize();
		webDriver.get(baseUrl);
		Thread.sleep(2000);
		
		WebElement loginButton = webDriver.findElement(By.id("login2"));
		loginButton.click();
		Thread.sleep(2000);
		
		WebElement username = webDriver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
		username.sendKeys("EdinDzeko");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
		password.sendKeys("12345678");
		Thread.sleep(2000);
		
		WebElement logIn = webDriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
		logIn.click();
		Thread.sleep(2000);
		
		assertEquals("Welcome EdinDzeko", webDriver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[7]/a")).getText());
		Thread.sleep(2000);
	}
		
	@Test
	//Testing the process of buying products
	void purchase() throws InterruptedException {
		
		WebElement s6 = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a"));
		s6.click();
		Thread.sleep(2000);
		
		WebElement cart1 = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
		cart1.click();
		Thread.sleep(2000);
		
		Alert alertCart = webDriver.switchTo().alert();
		alertCart.accept();
		Thread.sleep(1500);
		
		
	}
		
		
		
		
		
//		password.sendKeys("12345678");
//		Thread.sleep(1000);
//		
//		WebElement signIn = webDriver.findElement(By.name("sign in"));
//		signIn.click();
//		Thread.sleep(1000);
//		
//		String Dashboard = webDriver.getCurrentUrl();
//		assertNotEquals("https://admin.staging.wowflow.org/dashboard/issues", Dashboard);
//		Thread.sleep(1000);
//	}
//	
//	@Test
//	// Testing the login after inputing valid credentials
//	void siteLogin() throws InterruptedException {
//		webDriver.get("https://admin.staging.wowflow.org/login");
//		Thread.sleep(1000);
//		
//		WebElement username = webDriver.findElement(By.name("email"));
//		username.sendKeys("adokce+admin2@gmail.com");
//		Thread.sleep(1000);
//		
//		WebElement password = webDriver.findElement(By.name("password"));
//		password.sendKeys("testtest");
//		Thread.sleep(1000);
//		
//		WebElement signIn = webDriver.findElement(By.name("sign in"));
//		signIn.click();
//		Thread.sleep(5000);
//		
//		String Dashboard = webDriver.getCurrentUrl();
//		assertEquals("https://admin.staging.wowflow.org/dashboard/issues", Dashboard);
//		Thread.sleep(5000);
//	}
//	
//	@Test
//	//Testing the issues priority filter
//	void issues() throws InterruptedException {
//		webDriver.get("https://admin.staging.wowflow.org/dashboard/issues");
//		Thread.sleep(5000);
//		
//		WebElement allIssues = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div[1]/div[1]/div[4]/div/button"));
//		allIssues.click();
//		Thread.sleep(5000);
//	}


}

