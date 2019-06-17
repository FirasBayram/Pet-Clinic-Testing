import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAddOwnerWithEmptyTelephone extends DriverLifeCycleSetting{
	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		AddOwnerPO goToAddOwnerPage =  goToFindOwnerPage.addOwnerClickButton();
		
		String fnString ="Franco";
		goToAddOwnerPage.enterFirstName(fnString);	
		String lnString ="Zola";
		goToAddOwnerPage.enterLastName(lnString);
		String aString = "Via Arquata del Tronto";
		goToAddOwnerPage.enterAddress(aString);		
		String cString = "Rome";
		goToAddOwnerPage.enterCity(cString);
		goToAddOwnerPage.addOwnerButton();
		String errorMessage = goToAddOwnerPage.telephoneErrorMessage();
		String ExpectedString = "must not be empty";
		assertTrue(errorMessage.contains(ExpectedString));
		
		
	
		
}
}
