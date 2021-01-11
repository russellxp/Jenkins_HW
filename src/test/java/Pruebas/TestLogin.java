package Pruebas;

import org.testng.Assert;
import org.testng.annotations.*;

import paginas.PaginaHome;
import paginas.PaginaLogin;

import java.net.MalformedURLException;
import java.net.URL;

//import java.io.File;
//import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLogin {

//	WebDriver driver;
//	String driverPath = "google-chrome";
//	String driverPath = "./Drivers/chromedriver.exe";
//	String driverPath = "/var/jenkins_home/workspace/Java_App_Maven/Drivers/chromedriver";
//	String urlTest ="https://test.hospiceworks.com/login";
	

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", "67");
		chromeOptions.setCapability("platformName", "Windows XP");
		WebDriver driver = new RemoteWebDriver(new URL("192.168.14:4442"), chromeOptions);
		
		
		driver.get("https://test.hospiceworks.com/login");
		driver.quit();
		
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
		driver.close();
		
	}
	

	
}
