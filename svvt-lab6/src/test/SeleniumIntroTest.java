package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
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
	void testTitle() {
		webDriver.get(baseUrl);
		String title = webDriver.getTitle();
		System.out.println("Title: " + title);
		
		assertEquals("University Home - International Burch University", title);
	}

}
