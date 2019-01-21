package Listener_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listener_Demo.ListenerTest.class)
public class TestCases {
	public WebDriver driver;

	// Test to pass as to verify listeners .
	

	@BeforeMethod
	void createBrowserObject() {
		String operatingSystem = System.getProperty("os.name");
		String projectPath = System.getProperty("user.dir");
		// System.out.println(CaptureScreenshot.class.getClassLoader());
		if (operatingSystem.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/exe/ChromeDriver.exe");
		} else if (operatingSystem.contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/exe/MacOS/chromedriver");

		}
		driver = new ChromeDriver();
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
	}

	@Test
	public void Login() {

		driver.get("http://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("mngr34926");
		driver.findElement(By.name("password")).sendKeys("amUpenu");
		driver.findElement(By.name("btnLogin")).click();
	}

	// Forcefully failed this test as to verify listener.
	@Test
	public void TestToFail() {
		System.out.println("This method to test fail");
		Assert.assertTrue(false);
	}
}