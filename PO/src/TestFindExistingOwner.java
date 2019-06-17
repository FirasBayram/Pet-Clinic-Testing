import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestFindExistingOwner  extends DriverLifeCycleSetting {

	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		String filledText = "Black";
		goToFindOwnerPage.enterLastName(filledText);
		OwnerInfoPO findOwnerButton = goToFindOwnerPage.submit();
		assertTrue(findOwnerButton.nameTxt().endsWith(filledText));
		
		
	}	
}