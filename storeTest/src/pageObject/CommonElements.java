package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements {
		
	@FindBy(xpath=".//*[@id='advertPopup' or @class='CountryRedirectModal modal in']//button[@class='close']")
	public WebElement popUpCloseButton;
	
	public void ifPopupExistClose() {		//waiting for a pop-up window to be appeared and closing it
		try {
			if(popUpCloseButton.isDisplayed());
			popUpCloseButton.click();
		} catch (Exception e) {		// will throw exception if pop-up not found
			System.out.println("Popup didn't appear.");
		}
	}	
}