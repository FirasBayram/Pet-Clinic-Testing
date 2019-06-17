import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebElement;

public class TestFindAllOwners extends DriverLifeCycleSetting {
	
	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		AllOwnersPO allOwnersPage =  goToFindOwnerPage.submitAllOwners();
		WebElement table = allOwnersPage.tableReturned();
		assertTrue(table.isDisplayed());


}
}