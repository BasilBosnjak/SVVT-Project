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
		baseUrl = "https://admin.staging.wowflow.org/dashboard/issues";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}


	@Test
	// Testing whether the login will fail after inputing invalid credentials
	void falseLogin() throws InterruptedException {
		webDriver.get("https://admin.staging.wowflow.org/login");
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement username = webDriver.findElement(By.name("email"));
		username.sendKeys("john.doe@gmail.com");
		Thread.sleep(1000);
		
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys("12345678");
		Thread.sleep(1000);
		
		WebElement signIn = webDriver.findElement(By.name("sign in"));
		signIn.click();
		Thread.sleep(1000);
		
		String Dashboard = webDriver.getCurrentUrl();
		assertNotEquals("https://admin.staging.wowflow.org/dashboard/issues", Dashboard);
		Thread.sleep(1000);
	}
	
	@Test
	// Testing the login after inputing valid credentials
	void siteLogin() throws InterruptedException {
		webDriver.get("https://admin.staging.wowflow.org/login");
		Thread.sleep(1000);
		
		WebElement username = webDriver.findElement(By.name("email"));
		username.sendKeys("adokce+admin2@gmail.com");
		Thread.sleep(1000);
		
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys("testtest");
		Thread.sleep(1000);
		
		WebElement signIn = webDriver.findElement(By.name("sign in"));
		signIn.click();
		Thread.sleep(1000);
		
		String Dashboard = webDriver.getCurrentUrl();
		assertEquals("https://admin.staging.wowflow.org/dashboard/issues", Dashboard);
		Thread.sleep(1000);
	}
	
	@Test
	//Testing the issues priority filter
	void issues() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(5000);
		
		WebElement allIssues = webDriver.findElement(By.cssSelector("#root > div > div > div.main-wrapper > div.content-areacomponent__ContentAreaWrapper-sc-14l10n2-0.duOsfj.content-area > div > div > div > div.StickyHeader__Wrapper-sc-sr7d0h-0.hInqaX > div:nth-child(2) > div.Sort__SortWrapper-sc-1lteiyd-0.igQbBx > div > button > i"));
		allIssues.click();
		Thread.sleep(5000);
	}


}

