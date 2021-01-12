package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaHome {

	RemoteWebDriver driver;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/a[2]")
	WebElement optionMenuReferral;

	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/a[3]")
	WebElement optionMenuPatients;

	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/a[4]")
	WebElement optionMenuCare;

	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]")
	WebElement optionMenuHospice;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/a[5]")
	WebElement optionMenuBilling;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[2]")
	WebElement optionMenuAdministration;

	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[3]")
	WebElement optionMenuUser;
	
	
	@FindBy(xpath="//h3[contains(text(),'Welcome back')]")
	WebElement labelH3;
	
	@FindBy(xpath="//body/div[3]/div[1]/div[3]")
	WebElement user;
	
	@FindBy(xpath="//body/div[3]/div[1]/div[3]/div[1]/a[2]")
	WebElement logOut;	
	
	public PaginaHome(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	public void clicOnMenuPatients() {
		optionMenuPatients.click();
		//System.out.println("MenuPatients");
		
	}
	
	public String getTitleH3() {
		
		return labelH3.getText();
		//System.out.println("Cabeza: " + labelErrorDesc.getText());
		
	}
	
	public void logOut() {
		user.click();
		logOut.click();
		System.out.println("Se cerró la sesión");
	}
	
}
