package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
		
		@FindBy(xpath=".//*[@id='advertPopup' or @class='CountryRedirectModal modal in']//button[@class='close']")
		public WebElement popUpCloseButton;
		
		@FindBy(xpath=".//*[@id='topMenu']//li[1]/*[@href='/mens']")
		public WebElement mensCategory;
		
		@FindBy(xpath=".//ul[@class='Mens']//a[@href='/mens/mens-shoes']")
		public WebElement mensShoes;
		
}
