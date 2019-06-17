import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEditOwnerWithNotNumericTelephonePO extends DriverLifeCycleSetting{
	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		String filledText = "Black";
		goToFindOwnerPage.enterLastName(filledText);
		OwnerInfoPO ownerInfoPage = goToFindOwnerPage.submit();
		EditOwnerPO editOwnerPage = ownerInfoPage.editOwnerButton();
		String newValue = "abcdef";
		editOwnerPage.updateTelephone(newValue);
		editOwnerPage.updateOwnerClick();
		String  ActualString = editOwnerPage.phoneErrorMessage();
		String ExpectedString = "numeric value out of bounds (<10 digits>.<0 digits> expected)";
		assertTrue(ActualString.equals(ExpectedString));
		

}
}
