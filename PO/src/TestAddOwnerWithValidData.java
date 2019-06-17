import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAddOwnerWithValidData extends  DriverLifeCycleSetting {

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
		String tString = "33056539";
		goToAddOwnerPage.enterTelephone(tString);
		OwnerInfoPO goToOwnerInfoPage = goToAddOwnerPage.addOwnerButton();
		
		//Assert the value of the name
		String nActualString = goToOwnerInfoPage.nameTxt();
		assertTrue(nActualString.startsWith(fnString));
		assertTrue(nActualString.endsWith(lnString));
		
		//Assert the value of the address field 
		String aActualString = goToOwnerInfoPage.addressTxt();
		String aExpectedString = aString;
		assertTrue(aActualString.equals(aExpectedString));
		
		//Assert the value of the city field 
		String cActualString = goToOwnerInfoPage.cityTxt();
		String cExpectedString = cString;
		assertTrue(cActualString.equals(cExpectedString));
		
		//Assert the value of the telephone field 
		String tActualString = goToOwnerInfoPage.phoneTxt();
		String tExpectedString = tString;
		assertTrue(tActualString.equals(tExpectedString));
		
}
}
