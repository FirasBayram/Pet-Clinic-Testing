import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindOwnersPO extends PageObject {

	public FindOwnersPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="lastName")
	private WebElement lastName;
	@FindBy(className="btn-default")
	private WebElement findOwner;
	@FindBy(xpath="/html/body/div/div/a")
	private WebElement addOwnerButton;
	
	public void enterLastName( String lastName){
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	public OwnerInfoPO submit(){
		findOwner.click();
		return new OwnerInfoPO(driver);
	}
	
	public AddOwnerPO addOwnerClickButton(){
		addOwnerButton.click();
		return new AddOwnerPO(driver);
	}
	
	public AllOwnersPO submitAllOwners(){
		findOwner.click();
		return new AllOwnersPO(driver);
	}
	
	@FindBy(xpath="//*[@id=\"lastNameGroup\"]/div/span/div/p")
	private WebElement error;
	
	public String errorText(){
		return error.getText();
		}
	
}
