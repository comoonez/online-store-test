package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MensShoesPage {
	
	@FindBy(xpath=".//a[@class='FilterAnchor']//*[text()='Firetrap']")
	private WebElement brandFiretrap;
	
	@FindBy(xpath=".//a[@class='FilterAnchor']//*[text()='Skechers']")
	public WebElement brandSkechers;
	
	@FindBy(xpath=".//*[@id='PriceFilterTextEntryMin']")
	public WebElement minPriceField;
	
	@FindBy(xpath=".//*[@id='PriceFilterTextEntryMax']")
	public WebElement maxPriceField;
	
	@FindBy(xpath=".//*[@id='PriceFilterTextEntryApply']")
	public WebElement applyFilterButton;
	
	@FindBy(xpath=".//*[@class='productdescriptionbrand']")
	public List<WebElement> productBrandName;
	
	@FindBy(xpath=".//div[@class='s-largered']//*[last()]")
	public List<WebElement> productExactPrice;

}