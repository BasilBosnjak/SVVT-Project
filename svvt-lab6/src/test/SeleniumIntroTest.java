package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		
		WebElement falseUsername = webDriver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
		falseUsername.sendKeys("JohnDoe");
		Thread.sleep(2000);
		
		WebElement falsePassword = webDriver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
		falsePassword.sendKeys("12345678");
		Thread.sleep(2000);
		
		WebElement falseLogin = webDriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
		falseLogin.click();
		Thread.sleep(2000);
		
		Alert alertLogin = webDriver.switchTo().alert();
		alertLogin.accept();
		Thread.sleep(1500);
		
		falseUsername.clear();
		Thread.sleep(500);
		
		WebElement username = webDriver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
		username.sendKeys("EdinDzeko");
		Thread.sleep(2000);
		
		falsePassword.clear();
		Thread.sleep(500);
		
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
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		WebElement s6 = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a"));
		s6.click();
		Thread.sleep(2000);
		
		WebElement cart1 = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
		cart1.click();
		Thread.sleep(2000);
		
		Alert alertCart = webDriver.switchTo().alert();
		alertCart.accept();
		Thread.sleep(1500);
		
		WebElement goHome = webDriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
		goHome.click();
		Thread.sleep(2000);
		
		WebElement next = webDriver.findElement(By.xpath("//*[@id=\"next2\"]"));
		js.executeScript("arguments[0].scrollIntoView();", next);
		Thread.sleep(2000);
		next.click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
		WebElement dell = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[4]/div/div/h4/a"));
		dell.click();
		Thread.sleep(2000);
		
		WebElement cart2 = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
		cart2.click();
		Thread.sleep(2000);
		
		Alert alertDell = webDriver.switchTo().alert();
		alertDell.accept();
		Thread.sleep(1500);
		
		WebElement home2 = webDriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
		home2.click();
		Thread.sleep(2000);
		
		WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"cartur\"]"));
		cart.click();
		Thread.sleep(2000);
		
		WebElement deleteDell = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[4]/a"));
		deleteDell.click();
		Thread.sleep(2000);
		
		WebElement placeOrder = webDriver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
		placeOrder.click();
		Thread.sleep(2000);
		
		WebElement orderName = webDriver.findElement(By.xpath("//*[@id=\"name\"]"));
		orderName.sendKeys("Edin Dzeko");
		Thread.sleep(1000);
		
		WebElement orderCountry = webDriver.findElement(By.xpath("//*[@id=\"country\"]"));
		orderCountry.sendKeys("Italy");
		Thread.sleep(1000);
		
		WebElement orderCity = webDriver.findElement(By.xpath("//*[@id=\"city\"]"));
		orderCity.sendKeys("Milano");
		Thread.sleep(1000);
		
		WebElement orderCreditCard = webDriver.findElement(By.xpath("//*[@id=\"card\"]"));
		orderCreditCard.sendKeys("87654321");
		Thread.sleep(1000);
		
		WebElement orderMonth = webDriver.findElement(By.xpath("//*[@id=\"month\"]"));
		orderMonth.sendKeys("08");
		Thread.sleep(1000);
		
		WebElement orderYear = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		orderYear.sendKeys("2024");
		Thread.sleep(1000);
		
		WebElement orderPurchase = webDriver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		orderPurchase.click();
		Thread.sleep(1000);
		
		WebElement confirmPurchase = webDriver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
		confirmPurchase.click();
		Thread.sleep(1000);
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

