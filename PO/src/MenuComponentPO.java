import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuComponentPO extends PageObject {
	public MenuComponentPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"main-navbar\"]/ul/li[2]/a")
	private WebElement home;
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"main-navbar\"]/ul/li[3]/a")
	private WebElement findowners;
	
	public HomePO goToHome() {
	home.click();
	return new HomePO(driver);
	}
	
	public FindOwnersPO goToFindOwner() {
	findowners.click();
	return new FindOwnersPO(driver);
	}

}
