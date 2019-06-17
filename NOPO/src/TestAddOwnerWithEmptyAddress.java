import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddOwnerWithEmptyAddress {
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
	//fill the text input of city with a valid value 
	WebElement city = driver.findElement(By.id("city"));
	String cString = "Rome";
	city.sendKeys(cString);
	//fill the text input of telephone with a valid value 
	WebElement telephone = driver.findElement(By.id("telephone"));
	String tString = "3308656539";
	telephone.sendKeys(tString);
	//Submit the values by clicking on Add Owner button
	WebElement add = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button"));
	add.click();
	
	//Assert that the message 'must not be empty' is displayed
	String  ActualString = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[3]/div/span[2]")).getText();
	String ExpectedString = "must not be empty";
	assertTrue(ActualString.equals(ExpectedString));
	//Close the driver
    driver.close();

	}
}
