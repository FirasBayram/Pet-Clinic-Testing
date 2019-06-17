import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEditOwnerEmptyField {
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
		
		
		//Click on Edit Owner button
		WebElement EOButton = driver.findElement(By.xpath("/html/body/div/div/a[1]"));
		EOButton.click();
		
		//clear the city value
		WebElement  firstName = driver.findElement(By.id("city"));
		firstName.clear();
		
		//Click on Update Owner button
		WebElement update = driver.findElement(By.className("btn-default"));
		update.click();
		
		//Assert the error message is shown under the city field
		String  ActualString = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[4]/div/span[2]")).getText();
		String ExpectedString = "must not be empty";
		assertTrue(ActualString.contains(ExpectedString));
		//Close the driver
	    driver.close();
	}
}
