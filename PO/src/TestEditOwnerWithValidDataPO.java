import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class TestEditOwnerWithValidDataPO extends DriverLifeCycleSetting {

	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		String filledText = "Black";
		goToFindOwnerPage.enterLastName(filledText);
		OwnerInfoPO ownerInfoPage = goToFindOwnerPage.submit();
		EditOwnerPO editOwnerPage = ownerInfoPage.editOwnerButton();
		String newValue = "Bob";
		editOwnerPage.updateFirstName(newValue);
		OwnerInfoPO ownerInfoDetails = editOwnerPage.updateOwnerClick();
		
		//Assert the value of the name
		String nActualString = ownerInfoDetails.nameTxt();
		assertTrue(nActualString.startsWith(newValue));

}
}
