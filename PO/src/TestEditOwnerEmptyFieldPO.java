import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEditOwnerEmptyFieldPO extends DriverLifeCycleSetting {
	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		String filledText = "Black";
		goToFindOwnerPage.enterLastName(filledText);
		OwnerInfoPO ownerInfoPage = goToFindOwnerPage.submit();
		EditOwnerPO editOwnerPage = ownerInfoPage.editOwnerButton();
		String newValue = "";
		editOwnerPage.updateFirstName(newValue);
		editOwnerPage.updateOwnerClick();
		String  ActualString = editOwnerPage.nameErrorMessage();
		String ExpectedString = "must not be empty";
		assertTrue(ActualString.equals(ExpectedString));
		

}
}
