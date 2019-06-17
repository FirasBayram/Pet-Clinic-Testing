import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAddPetToOwnerPO extends DriverLifeCycleSetting{

	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		String filledText = "Black";
		goToFindOwnerPage.enterLastName(filledText);
		OwnerInfoPO findOwnerPage = goToFindOwnerPage.submit();
		NewPetPO addPetPage = findOwnerPage.addPetButton();
		String petName = "Arnold";
		String petBirthDate = "2015-01-10";
		String petType = "cat";
		addPetPage.addName(petName);
		addPetPage.addBirthDate(petBirthDate);
		addPetPage.selectType(petType);
		OwnerInfoPO ownerInfoPage = addPetPage.addPetClick();
		String fields = ownerInfoPage.petsInfoTxt();
		assertTrue(fields.contains(petName));
		assertTrue(fields.contains(petBirthDate));
		assertTrue(fields.contains(petType));
		
	}	
}
