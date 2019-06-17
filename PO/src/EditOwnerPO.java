import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditOwnerPO extends PageObject{

	public EditOwnerPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="firstName")
	private WebElement firstName;
	@FindBy(id="lastName")
	private WebElement lastName;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(id="city")
	private WebElement city;
	@FindBy(id="telephone")
	private WebElement telephone;
	
	public void updateFirstName( String firstName){
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public void updateLastName( String lastName){
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void updateTelephone( String telephone){
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	public void updateCity( String city){
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void updateAddress( String address){
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	@FindBy(className="btn-default")
	private WebElement updateOwnerButton;
	public OwnerInfoPO updateOwnerClick(){
		updateOwnerButton.click();
		return new OwnerInfoPO(driver);
	}
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[1]/div[1]/div/span[2]")
	private WebElement nameError;
	public String nameErrorMessage(){
		return nameError.getText();
	}
	
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[1]/div[5]/div/span[2]")
	private WebElement phoneError;
	public String phoneErrorMessage(){
		return phoneError.getText();
	}
	
}
