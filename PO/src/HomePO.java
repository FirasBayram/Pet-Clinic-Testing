import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePO extends PageObject{

	public HomePO(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(how=How.XPATH, xpath ="/html/body/div/div/h2")
	private WebElement txt;
	
	public String confirmationText(){
		return txt.getText();
		}

}