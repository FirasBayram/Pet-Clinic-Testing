import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAddPetToOwner {

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
	String expectedString = "Black";
	lastname.sendKeys(expectedString);
	
	//Click on the Find Owner button
	WebElement FOButton = driver.findElement(By.xpath("//button[@type='submit']"));
	FOButton.click();
	
	//click Add New Pet button
	WebElement addPet = driver.findElement(By.xpath("/html/body/div/div/a[2]"));
	addPet.click();
	
	//Insert the name text 
	WebElement name  = driver.findElement(By.id("name"));
	name.clear();
	String petName = "Arnold";
	name.sendKeys(petName);
	
	//Insert the Birth Date text 
	WebElement date  = driver.findElement(By.id("birthDate"));
	date.clear();
	String petBirthDate ="2015-01-10";
	date.sendKeys(petBirthDate);
	
	//Choose the type
	Select type  = new Select(driver.findElement(By.id("type"))) ;
	String petType = "bird";
	type.selectByVisibleText(petType);
	
	//Click on Add Pet button
	WebElement addPetButton = driver.findElement(By.className("btn-default"));
	addPetButton.click();
	
	//Get the fields of the table
	String fields = driver.findElement(By.className("dl-horizontal")).getText();
	assertTrue(fields.contains(petName));
	assertTrue(fields.contains(petBirthDate));
	assertTrue(fields.contains(petType));
	
	//Close the driver
    driver.close();
		
	}
}
