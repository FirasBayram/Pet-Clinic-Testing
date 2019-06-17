import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddOwnerWithEmptyTelephone {
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
	//Click on Add Owner button
	WebElement addOwner = driver.findElement(By.xpath("/html/body/div/div/a"));
	addOwner.click();
	//fill the text input of first name with a valid value 
	WebElement firstName = driver.findElement(By.id("firstName"));
	String fnString = "Francesco";
	firstName.sendKeys(fnString);
	//fill the text input of last name with a valid value  
	WebElement lastName = driver.findElement(By.id("lastName"));
	String lnString = "Totti";
	lastName.sendKeys(lnString);
	//fill the text input of address with a valid value
	WebElement address = driver.findElement(By.id("address"));
	String aString = "Via Arquata del Tronto";
	address.sendKeys(aString);
	//fill the text input of city with a valid value 
	WebElement city = driver.findElement(By.id("city"));
	String cString = "Rome";
	city.sendKeys(cString);
	//Submit the values by clicking on Add Owner button
	WebElement add = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button"));
	add.click();
	
	
	//Assert that the message 'must not be empty' is displayed
	String  ActualString = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[5]/div/span[2]")).getText();
	String ExpectedString = "must not be empty";
	assertTrue(ActualString.contains(ExpectedString));
	
	//Close the driver
    driver.close();
	}
}
