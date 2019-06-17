import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOwnerPO  extends PageObject{

	public AddOwnerPO(WebDriver driver) {
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
	
	public void enterFirstName( String firstName){
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public void enterLastName( String lastName){
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void enterTelephone( String telephone){
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	public void enterCity( String city){
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void enterAddress( String address){
		this.address.clear();
		this.address.sendKeys(address);
	}

	
	@FindBy(className="btn-default")
	private WebElement addOwner;
	public OwnerInfoPO addOwnerButton(){
		addOwner.click();
		return new OwnerInfoPO(driver);
	}
	
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[1]/div[1]/div/span[2]")
	private WebElement fnerror;
	public String firstNameErrorMessage(){
		return fnerror.getText();
		
		
	}
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[1]/div[2]/div/span[2]")
	private WebElement lnerror;
	public String lastNameErrorMessage(){
		return lnerror.getText();
		
		
	}
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[1]/div[3]/div/span[2]")
	private WebElement aerror;
	public String adressNameErrorMessage(){
		return aerror.getText();
		
		
	}
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[1]/div[4]/div/span[2]")
	private WebElement cerror;
	public String cityErrorMessage(){
		return cerror.getText();
		
		
	}
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[1]/div[5]/div/span[2]")
	private WebElement terror;
	public String telephoneErrorMessage(){
		return terror.getText();
		
		
	}
	
}
