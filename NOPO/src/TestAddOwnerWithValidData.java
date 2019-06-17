import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddOwnerWithValidData {
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
	//fill the text input of telephone with a valid value 
	WebElement telephone = driver.findElement(By.id("telephone"));
	String tString = "3308656539";
	telephone.sendKeys(tString);
	//Submit the values by clicking on Add Owner button
	WebElement add = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button"));
	add.click();
	
	//Assert the value of the name field 
	String fnActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText();
	String fnExpectedString = fnString;
	assertTrue(fnActualString.startsWith(fnExpectedString));
	String lnActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText();
	String lnExpectedString = lnString;
	assertTrue(lnActualString.endsWith(lnExpectedString));
	
	//Assert the value of the address field 
	String aActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText();
	String aExpectedString = aString;
	assertTrue(aActualString.equals(aExpectedString));
	
	//Assert the value of the city field 
	String cActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td")).getText();
	String cExpectedString = cString;
	assertTrue(cActualString.equals(cExpectedString));
	
	//Assert the value of the telephone field 
	String tActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td")).getText();
	String tExpectedString = tString;
	assertTrue(tActualString.equals(tExpectedString));
	
	//Close the driver
    driver.close();

	}
}
