import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestAddOwnerWithNotNumericTelephone extends DriverLifeCycleSetting{
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
		String tString = "abcdef";
		goToAddOwnerPage.enterTelephone(tString);
		goToAddOwnerPage.addOwnerButton();
		String errorMessage = goToAddOwnerPage.telephoneErrorMessage();
		String ExpectedString = "numeric value out of bounds (<10 digits>.<0 digits> expected)";
		assertEquals(errorMessage, ExpectedString);
		
	
		
}
}
