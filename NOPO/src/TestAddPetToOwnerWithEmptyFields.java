import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddPetToOwnerWithEmptyFields {
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
	
	//Click on Add Pet button
	WebElement addPetButton = driver.findElement(By.className("btn-default"));
	addPetButton.click();
	
	//Assert the first error message is shown
	String  ActualString1 = driver.findElement(By.xpath("//div[2]//div[1]//span[2]")).getText();
	String ExpectedString1 = "is required";
	assertTrue(ActualString1.contains(ExpectedString1));
	
	//Assert the second error message is shown
	String  ActualString2 = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div/span[2]")).getText();
	String ExpectedString2 = "is required";
	assertTrue(ActualString2.contains(ExpectedString2));
	
	//Close the driver
    driver.close();
	
	}
}
