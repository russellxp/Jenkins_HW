package paginas;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaLogin {

//WebDriver driver;
RemoteWebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(name="login")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[contains(text(),'Login failed')]")
	WebElement labelErrorDesc;
	
	@FindBy(linkText="Reset password")
	WebElement linkReset;
		
	public PaginaLogin(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	public void escribirUsername(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}
	
	public void escribirPassword(String password) {
		txtPassword.clear();		
		txtPassword.sendKeys(password);
	}
	
	public void loginVerification(String username, String password) {
		txtUsername.clear();
		txtPassword.clear();
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		
	}
	
	public void clickOnLogin() {
		btnLogin.click();
		
	}
	
	public void clickOnReset() {
		linkReset.click();
		
	}
	
	public String getTextError() {
			
		return labelErrorDesc.getText();
		//System.out.println("Cabeza: " + labelErrorDesc.getText());
		
	}
	
}
