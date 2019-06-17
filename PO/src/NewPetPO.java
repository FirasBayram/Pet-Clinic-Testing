import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewPetPO extends  PageObject {

	public NewPetPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="name")
	private WebElement name;
	@FindBy(id="birthDate")
	private WebElement birthDate;
	Select type  = new Select(driver.findElement(By.id("type"))) ;


	public void addName( String name){
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void addBirthDate(String birthDate){
		this.birthDate.clear();
		this.birthDate.sendKeys(birthDate);
	}
	
	public void selectType(String type){
		this.type.selectByVisibleText(type);
	}
	
	@FindBy(className="btn-default")
	private WebElement addPetButton;
	public OwnerInfoPO addPetClick(){
		addPetButton.click();
		return new OwnerInfoPO(driver);
	}
	
	@FindBy(xpath="//div[2]//div[1]//span[2]")
	private WebElement nameError;
	public String nameErrorMessage(){
		return nameError.getText();
	}
	
	@FindBy(xpath="/html/body/div/div/form/div[1]/div[3]/div/span[2]")
	private WebElement dateError;
	public String dateErrorMessage(){
		return nameError.getText();
	}
}
