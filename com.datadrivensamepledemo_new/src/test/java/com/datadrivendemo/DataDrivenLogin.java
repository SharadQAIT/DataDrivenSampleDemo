package com.datadrivendemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.manager.SeleniumManagerOutput.Result;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DataDrivenLogin

{
	public static Logger logger = LogManager.getLogger(DataDrivenLogin.class);

	@Test
	public void Launchsite() throws IOException {

		// How to read properties file
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/java/com/commonproperty/config.properties");
		prop.load(fi);

		System.out.println(prop.getProperty("browser"));
		String Browsername = prop.getProperty("browser");
		System.out.println(Browsername);

		if (Browsername.equals("chrome")) {
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
			logger.info("This is logger info");
			// System.out.println("Chrome Browser Successfully launch..");
			// logger.info("Starting your Selenium test...");
			driver.get(prop.getProperty("url"));
			System.out.println("Omni site Successfully launched..");
		} else if (Browsername.equals("firefox")) {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		} else if (Browsername.equals("edge")) {
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		}

	}
}
