package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaPatients {

	WebDriver driver;
	By textLinkMrn;
	
	@FindBy(xpath="//div[contains(text(),'Patients')]")
	WebElement labelTitle;
	
	@FindBy(xpath="//div[contains(text(),'Active')]")
	WebElement linkActive;	
	
	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[2]")
	WebElement linkDischarged;	
	
	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement optionCreateNewDocumentation;
	
	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]")
	WebElement optionChooseDocumentationForm;
	
	
	
	@FindBy(xpath="//div[contains(text(),'Physician Order')]")
	WebElement optionPhysicianOrder;

	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]")
	WebElement optionManageCertifications;	

	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]")
	WebElement optionUserAssignments;	
	
	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[4]")
	WebElement optionIDGIDT;	

	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[5]")
	WebElement optionBereavement;
	
	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[6]")
	WebElement optionTasklist;
	

	@FindBy(xpath="//button[contains(text(),'Select')]")
	WebElement btnSelectDocumentation;
	

	
	@FindBy(xpath="//div[contains(text(),'Physician Order')]")
	WebElement newDocumentOptionPhysicianOrder;
	
	
	@FindBy(xpath="//body/div[@id='content-enclosure']/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/i[1]")
	WebElement flechaNewDocumentOptionPhysicianOrder;
	

	@FindBy(xpath="//label[contains(text(),'MEDICATIONS')]")
	WebElement checkMedications;
	
	@FindBy(xpath="//div[contains(text(),'Import from Template')]")
	WebElement btnImportTemplate;	
	
	
	@FindBy(css="div.hospice-modal.animated.fadeIn div.hospice-modal_wrapper div.hospice-modal_content div.ui.form:nth-child(3) div.field.required:nth-child(1) div.Select.is-clearable.is-searchable.Select--single:nth-child(2) div.Select-control > span.Select-arrow-zone")
	WebElement cmbSelectTemplates;		
	
	@FindBy(css="div.hospice-modal.animated.fadeIn div.hospice-modal_wrapper div.hospice-modal_content div.ui.form:nth-child(3) > div.ui.button.positive.right.labeled.icon:nth-child(5)")
	WebElement btnImport;	
	
	@FindBy(css="//body/div[11]/div[1]/div[1]/div[1]")
	WebElement popUpImportMedicationTemplate;		
	
	
	@FindBy(css="div.hospice-modal.animated.fadeIn div.hospice-modal_wrapper div.hospice-modal_content div.ui.form:nth-child(3) div.field.required:nth-child(1) div.Select.is-clearable.is-searchable.Select--single:nth-child(2) div.Select-control > span.Select-arrow-zone")
	WebElement flechacmbTemplate;		
	
	
	@FindBy(xpath="//div[2]/div/div/div/span/div/input")
	WebElement option1Template;
	
	
	
	//body/div[11]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]
	
	//body/div[11]/div[1]/div[1]/div[1]/div[2]/div[5]
	
	public PaginaPatients(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	public void findMRN(String findMrn) {
		textLinkMrn = By.linkText(findMrn);
		driver.findElement(textLinkMrn).click();				
	}
	
	public void cmbCreateNewDocumentaion() {
		optionChooseDocumentationForm.click();
		optionCreateNewDocumentation.click();
		System.out.println("Create New Documentation");
	}
	
	public void cmbManageCertifications() {
		optionManageCertifications.click();
	}
	
	public void cmbUserAssignments() {
		optionUserAssignments.click();
	}
	
	public void cmbIDGIDT() {
		optionIDGIDT.click();
	}
	
	public void cmbBereavement() {
		optionBereavement.click();
	}
	
	public void cmbTasklist() {
		optionTasklist.click();
	}
	
	public void cmbNewDocumentOptionPhysicianOrder() {
		flechaNewDocumentOptionPhysicianOrder.click();
		newDocumentOptionPhysicianOrder.click();
	}
	
	public void btnSelect() {
		btnSelectDocumentation.click();
	}
	
	public void checkendMedications() {
		checkMedications.click();
	}
	
	public void btnImportFromTemplate() {
		btnImportTemplate.click();
		
	}
	
	public void clickImport() {
		//popUpImportMedicationTemplate.click();
//		flechacmbTemplate.click();
		System.out.println("Click flecha");
	//	System.out.println("flechacmbTemplate: " + flechacmbTemplate.getText());
		//System.out.println("btnImport: " + btnImport.getText());
//		System.out.println("option1Template: " + option1Template.getText());
	//	Helpers helpers = new Helpers();
	//	helpers.SleepSeconds(5);
		
		option1Template.click();
		System.out.println(option1Template.getText());
		option1Template.sendKeys("Template");
//		option1Template.click();
//		System.out.println("Exito");
		//Select templates = new Select(flechacmbTemplate);
		//templates.selectByValue("Template 1");
		//System.out.println(templates.selectByIndex(1));
	//	Select estado = new Select(driver.findElement(By.cssSelector("div.hospice-modal.animated.fadeIn div.hospice-modal_wrapper div.hospice-modal_content div.ui.form:nth-child(3) div.field.required:nth-child(1) div.Select.is-clearable.is-searchable.Select--single:nth-child(2) div.Select-control > span.Select-arrow-zone")));
	//	estado.selectByIndex(1);
		
 
		    driver.findElement(By.cssSelector("#react-select-6--value > .Select-placeholder")).click();
		    // 19 | type | css=.Select-input:nth-child(1) > input | Template
		    driver.findElement(By.cssSelector(".Select-input:nth-child(1) > input")).sendKeys("Template");
		    // 20 | sendKeys | css=.Select-input:nth-child(1) > input | ${KEY_ENTER}
		    driver.findElement(By.cssSelector(".Select-input:nth-child(1) > input")).sendKeys(Keys.ENTER);
		    
	}
	
	public void writeTemplates(String templates) {
		
		popUpImportMedicationTemplate.click();
		flechacmbTemplate.click();
		System.out.println("write : " + templates);
		cmbSelectTemplates.sendKeys(templates + Keys.ENTER);
		
	}
	
	public void btnImport() {
		System.out.println("btnImport: " + btnImport.getText());
		System.out.println("option1Template: " + option1Template.getText());
		btnImport.click();
		btnImport.sendKeys("Template");
		//  + Keys.ENTER
		
	}
	
	
}
