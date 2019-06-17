import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebElement;

public class TestFindExistingOwnerFromAll  extends  DriverLifeCycleSetting {

	
	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		AllOwnersPO allOwnersPage =  goToFindOwnerPage.submitAllOwners();
		WebElement table = allOwnersPage.tableReturned();
		assertTrue(table.isDisplayed());
		String nameTable  = allOwnersPage.nameTxt();
		String cityTable = allOwnersPage.cityTxt();
		String addressTable = allOwnersPage.addressTxt();
		String phoneTable  = allOwnersPage.phoneTxt();
		OwnerInfoPO details = allOwnersPage.submit();
		String nameDetails  = details.nameTxt();
		String cityDetails = details.cityTxt();
		String addressDetails = details.addressTxt();
		String phoneDetails  = details.phoneTxt();
		assertEquals(nameDetails, nameTable);
		assertEquals(cityDetails, cityTable);
		assertEquals(addressDetails, addressTable);
		assertEquals(phoneDetails, phoneTable);


}
}
