import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerInfoPO  extends PageObject{

	public OwnerInfoPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="/html/body/div/div/table[1]/tbody/tr[1]/td")
	private WebElement name;
	
	public String nameTxt(){
		return name.getText();
		}
	@FindBy(xpath="/html/body/div/div/table[1]/tbody/tr[2]/td")
	private WebElement address;
	
	public String addressTxt(){
		return address.getText();
		}
	
	@FindBy(xpath="/html/body/div/div/table[1]/tbody/tr[3]/td")
	private WebElement city;
	
	public String cityTxt(){
		return city.getText();
		}
	@FindBy(xpath="/html/body/div/div/table[1]/tbody/tr[4]/td")
	private WebElement phone;
	
	public String phoneTxt(){
		return phone.getText();
		}
	
	@FindBy(xpath="/html/body/div/div/a[1]")
	private WebElement editOwnerButton;
	public EditOwnerPO editOwnerButton(){
		editOwnerButton.click();
		return new EditOwnerPO(driver);
	}
	
	@FindBy(xpath="/html/body/div/div/a[2]")
	private WebElement addPet;
	public NewPetPO addPetButton(){
		addPet.click();
		return new NewPetPO(driver);
	}
	
	
	@FindBy(xpath="/html/body/div/div/table[2]/tbody")
	private WebElement petsInfo;
	
	public String petsInfoTxt(){
		return petsInfo.getText();
		}	

	

}
