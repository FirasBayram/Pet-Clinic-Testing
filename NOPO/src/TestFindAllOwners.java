import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFindAllOwners {
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
	WebElement find = driver.findElement(By.xpath("//li[3]"));
	find.click();
	
	//Click on Find Owner button	
	WebElement findOwner = driver.findElement(By.className("btn-default"));
	findOwner.click();
	//Assert that the Owners' table is displayed
	WebElement table =  driver.findElement(By.id("vets"));
	assertTrue(table.isDisplayed());
	//Close the driver
    driver.close();

	}

}
