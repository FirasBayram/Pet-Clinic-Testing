import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestAddOwnerWithEmptyCity extends DriverLifeCycleSetting{
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
		String tString = "33056539";
		goToAddOwnerPage.enterTelephone(tString);
		goToAddOwnerPage.addOwnerButton();
		String errorMessage = goToAddOwnerPage.cityErrorMessage();
		assertEquals("must not be empty", errorMessage);
		
		
	
		
}
}
