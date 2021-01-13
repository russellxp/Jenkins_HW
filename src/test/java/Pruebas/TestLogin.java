package Pruebas;

import org.testng.Assert;
import org.testng.annotations.*;

import paginas.PaginaHome;
import paginas.PaginaLogin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.lang.Object;

//import java.io.File;
//import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLogin {

	static RemoteWebDriver driver;
//	String driverPath = "google-chrome";
//	String driverPath = "./Drivers/chromedriver.exe";
//	String driverPath = "/var/jenkins_home/workspace/Java_App_Maven/Drivers/chromedriver";
//	String urlTest ="https://test.hospiceworks.com/login";
	

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		
		System.out.println("Chrome");
	//	DesiredCapabilities cap = DesiredCapabilities.chrome();
		//					cap.setPlatform(Platform.LINUX);
			//				cap.setVersion("");
		ChromeOptions chromeOptions = new ChromeOptions();
	/*	chromeOptions.setCapability("browserVersion", "87");
		chromeOptions.setCapability("platformName", Platform.LINUX);
		chromeOptions.setCapability("browserName", "chrome");
		*/
		
		//: , : , : 1, : , : , : , :, : 
		
	       chromeOptions.setCapability("applicationName", ""); //To specify the browser
	       chromeOptions.setCapability("browserName", "chrome"); //To specify the browser version
	       chromeOptions.setCapability("maxInstances", "1"); // To specify the OS
	       chromeOptions.setCapability("platform", "LINUX"); //To identify the test
	       chromeOptions.setCapability("platformName", "LINUX");
	       chromeOptions.setCapability("seleniumProtocol", "WebDriver"); // To enable network logs
	       chromeOptions.setCapability("server", "CONFIG_UUID: 5e1187dd-1e42-4c8a-a589-0fe..."); // To enable step by step screenshot
	       chromeOptions.setCapability("version", "87.0.4280.88"); // To enable video recording
	      // chromeOptions.setCapability("console", true); // To capture console logs

		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		//nodeUrl = "http://192.168.100.4:4444/wd/hub";
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setPlatform(Platform.SIERRA);
		//ChromeOptions options = new ChromeOptions();
		//options.merge(capabilities);
		//driver = new RemoteWebDriver(new URL(nodeUrl), options);
		//driver.get("http://www.amazon.com");
		
		
		driver = new RemoteWebDriver(new URL("http://192.168.16.108:4446/wd/hub"), chromeOptions);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.setFileDetector(new LocalFileDetector());
		
		driver.get("https://test.hospiceworks.com/login");
		//driver.close();
		
	//	System.setProperty("webdriver.chrome.driver", driverPath);
		
	//	driver = new ChromeDriver();
	//	driver.get(urlTest);
		
	}
	
	@Test
	public void errorLogin() {
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirUsername("guido.robles2");
		login.escribirPassword("Guido$01");
		
		login.clickOnLogin();
		
		
		String msjError = login.getTextError();
		System.out.println(msjError);
		
		//System.out.println("Paso error Login");
		Assert.assertEquals(msjError, "Login failed");		
		System.out.println("Paso error Login");
		
		//PaginaHome home = new PaginaHome(driver);
		//home.logOut();
		//Assert.assertEquals(login.getTextError(), "AUTHENTICATION");
				
	}
	

	//private String sUsername="Guido";
	//private String sPassword="Robles";

//	private String sUsername;
//	private String sPassword;

	
	
//	@BeforeClass
	//@Parameter("suiteParam")

	//@Parameters({"sUsername","sPassword"})
	//public void init(String sUsername, String sPassword) {
	//this.sUsername = sUsername;
	//this.sPassword = sPassword;
	//}

//	@Parameters({"sUsername","sPassword"})
//	public void init(String sUsername, String sPassword) {
//	this.sUsername = sUsername;
//	this.sPassword = sPassword;
//	}

	
	
	@Test
	public void correctLogin() {
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirUsername("guido.robles");
		login.escribirPassword("Guido$01");
		
				
		

		login.loginVerification("guido.robles", "Guido$01");
	//	System.out.println("sUsername" + sUsername);
	//	login.loginVerification(sUsername, sPassword);
		//System.out.println("sUsername" + sUsername);>>>>>> 447b4e3f30749b04e3e958145a37f4961fc99c6f
		//System.out.println("sPassword" + sPassword);
		
		login.clickOnLogin();
		PaginaHome home = new PaginaHome(driver);
		
				
		String msjH3 = home.getTitleH3();
		System.out.println("msjH3 :" + msjH3);
		
		Assert.assertEquals(msjH3, "Welcome back");	
		System.out.println("Paso Correct Login");
		
		home.logOut();
		
		//Assert.assertEquals(login.getTextError(), "AUTHENTICATION");
				
	}
	

	
	@AfterTest
	public void cerrar() {
		driver.quit();
		
	}
	

	
}
