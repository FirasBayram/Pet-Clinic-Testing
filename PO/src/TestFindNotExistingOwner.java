import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestFindNotExistingOwner extends DriverLifeCycleSetting{
	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		String filledText = "Rossi";
		goToFindOwnerPage.enterLastName(filledText);
		goToFindOwnerPage.submit();
		String expectedString = "has not been found";
		assertTrue(goToFindOwnerPage.errorText().equals(expectedString));
		
		
}
}	
