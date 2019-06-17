import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllOwnersPO extends PageObject {

	public AllOwnersPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="vets")
	private WebElement table;
	
	public WebElement tableReturned(){
		return table;
		}
	@FindBy(xpath="//*[@id=\"vets\"]/tbody/tr[1]/td[1]")
	private WebElement name;
	
	public String nameTxt(){
		return name.getText();
		}
	
	@FindBy(xpath="//*[@id=\"vets\"]/tbody/tr[1]/td[2]")
	private WebElement address;
	
	public String addressTxt(){
		return address.getText();
		}
	
	@FindBy(xpath="//*[@id=\"vets\"]/tbody/tr[1]/td[3]")
	private WebElement city;
	
	public String cityTxt(){
		return city.getText();
		}
	@FindBy(xpath="//*[@id=\"vets\"]/tbody/tr[1]/td[4]")
	private WebElement phone;
	
	public String phoneTxt(){
		return phone.getText();
		}
	
	@FindBy(xpath="//*[@id=\"vets\"]/tbody/tr[1]/td[1]/a")
	private WebElement link;
	public OwnerInfoPO submit(){
		link.click();
		return new OwnerInfoPO(driver);
	}
	
}
