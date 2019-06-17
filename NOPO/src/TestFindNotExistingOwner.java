import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFindNotExistingOwner {
	//Driver definition
    private static  WebDriver driver;
    @BeforeClass
    public static void createAndStartService() {
    System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    driver = new ChromeDriver();
    }

    
	@Test
	public void testMethod() {
	//Open the home web page
	driver.get("http://localhost:8080/");
	
	//Click on FIND OWNERS link
	WebElement find =   driver.findElement(By.xpath("//li[3]"));
	find.click();
	
	//Fill the text input with the Last Name you are searching for
	WebElement lastname =   driver.findElement(By.id("lastName"));
	lastname.sendKeys("Rossi");
	
	//Click on the Find Owner button
	WebElement FOButton = driver.findElement(By.xpath("//button[@type='submit']"));
	FOButton.click();
	
	//Assert that the 'has not been found' message appeared
	String actualString = driver.findElement(By.xpath("//*[@id=\"lastNameGroup\"]/div/span/div")).getText();
	String expectedString = "has not been found";
	assertTrue(actualString.equals(expectedString));
	
	//Close the driver
    driver.close();
	}

}
