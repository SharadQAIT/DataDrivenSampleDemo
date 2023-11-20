package com.datadrivendemo;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.manager.SeleniumManagerOutput.Result;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenLogin

{
	public static Capabilities driver;

	@Parameters("browser")
	@Test
	public void Launchsite(String browser) {

		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--remote-allow-origins=*"); //
		 * options.addArguments("--disable notifications"); DesiredCapabilities cp = new
		 * DesiredCapabilities(); cp.setCapability(ChromeOptions.CAPABILITY, options);
		 * options.merge(cp); // System.setProperty("Webdriver.chrome.driver",
		 * "chromedriver.exe"); driver = new ChromeDriver(options);
		 */

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cp);
			Result chpath = SeleniumManager.getInstance().getDriverPath(options, false);
			System.out.println(chpath);
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome Browser Successfully launch..");
			// logger.info("Starting your Selenium test...");
			driver.get("https://omnistage.solutionanalysts.us/");
			System.out.println("Omni site Successfully launched..");
		} // else if (browser.equalsIgnoreCase("Mozilla")) {
			// Result chpath = SeleniumManager.getInstance().getDriverPath(options, false);
			// WebDriver driver = new FirefoxDriver();
			// driver.get("https://omnistage.solutionanalysts.us/");

		// }// else if (browser.equalsIgnoreCase("Edge"))
		// {
		// WebDriver driver = new EdgeDriver();
		// driver.get("https://omnistage.solutionanalysts.us/");
		// }

	}
}
