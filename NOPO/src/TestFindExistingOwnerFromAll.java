import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFindExistingOwnerFromAll {
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
	
	//Click on Find Owner button	
	WebElement findOwner = driver.findElement(By.className("btn-default"));
	findOwner.click();

	//Get the information of the owner
	String name = driver.findElement(By.xpath("//*[@id=\"vets\"]/tbody/tr[1]/td[1]")).getText();
	String address = driver.findElement(By.xpath("//*[@id=\"vets\"]/tbody/tr[1]/td[2]")).getText();
	String city = driver.findElement(By.xpath("//*[@id=\"vets\"]/tbody/tr[1]/td[3]")).getText();
	String telephone = driver.findElement(By.xpath("//*[@id=\"vets\"]/tbody/tr[1]/td[4]")).getText();
	
	//Click on an owner Name
	WebElement link = driver.findElement(By.xpath("//*[@id=\"vets\"]/tbody/tr[1]/td[1]"));
	link.click();
	//Assert that the Owner's table is displayed
	WebElement table =  driver.findElement(By.className("table-striped"));
	assertTrue(table.isDisplayed());
	
	//Assert that the returning owner information is the same of the expected one
	//Assert the name
	String nActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td")).getText();
	assertTrue(nActualString.equals(name));
	//Assert the address
	String aActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText();
	assertTrue(aActualString.equals(address));
	//Assert the city
	String cActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td")).getText();
	assertTrue(cActualString.equals(city));
	//Assert the telephone
	String tActualString = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td")).getText();
	assertTrue(tActualString.equals(telephone));
	//Close the driver
    driver.close();
	}
}