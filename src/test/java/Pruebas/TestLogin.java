package Pruebas;

import org.testng.Assert;
import org.testng.annotations.*;

import paginas.PaginaHome;
import paginas.PaginaLogin;


//import java.io.File;
//import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

	WebDriver driver;
	String driverPath = "Drivers/chromedriver.exe";
	String urlTest ="https://test.hospiceworks.com/login";
	
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(urlTest);
		
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
