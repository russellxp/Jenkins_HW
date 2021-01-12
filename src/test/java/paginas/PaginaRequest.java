package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class PaginaRequest {
	RemoteWebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txtUsername;
		
	@FindBy(xpath="//button[contains(text(),'Request Password Reset')]")
	WebElement btnRequestPass;
	
	@FindBy(linkText="Back to Login")
	WebElement textLinkBack;
		
	@FindBy(xpath="//li[contains(text(),'This username or email is invalid.')]")
	WebElement msjError;
	
	@FindBy(xpath="//body/div[3]")
	WebElement formReq;
	
	public PaginaRequest(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	public void escribirUsername(String username) {
		txtUsername.sendKeys(username);
		
	}
	
	
	public void clickOnbtnRequestPass() {
		btnRequestPass.click();
		
	}
	
	public void clickOntextLinkBack() {
		textLinkBack.click();
		
	}
	
	public String getMsjError() {
		
		String msjRespuesta = msjError.getText();


		return msjRespuesta;
		
	}
	

	
	public void clinOnForm() {
		formReq.click();
		
	}

}
