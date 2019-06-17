import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAddPetToOwnerWithEmptyFieldsPO extends DriverLifeCycleSetting {
	@Test
	public void test(){
		driver.get("http://localhost:8080/");
		MenuComponentPO findOwnersButton = new MenuComponentPO(driver);
		FindOwnersPO goToFindOwnerPage = findOwnersButton.goToFindOwner();
		String filledText = "Black";
		goToFindOwnerPage.enterLastName(filledText);
		OwnerInfoPO findOwnerPage = goToFindOwnerPage.submit();
		NewPetPO addPetPage = findOwnerPage.addPetButton();
		String petName = "";
		String petBirthDate = "";
		addPetPage.addName(petName);
		addPetPage.addBirthDate(petBirthDate);
		addPetPage.addPetClick();
		String  ActualString1 = addPetPage.nameErrorMessage();
		String ExpectedString1 = "is required";
		assertTrue(ActualString1.contains(ExpectedString1));

		String  ActualString2 = addPetPage.dateErrorMessage();
		String ExpectedString2 = "is required";
		assertTrue(ActualString2.contains(ExpectedString2));
		
		
	}	
}
