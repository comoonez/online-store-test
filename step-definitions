package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Test_Steps {
	public static WebDriver driver;
	
	@Given("^I have navigated to sportsdirect homepage$")
	public void i_have_navigated_to_sportsdirect_homepage() {
		System.setProperty("webdriver.gecko.driver", "C:\\\\drivers\\geckodriver.exe");  // setting a property as selenium 3 or above is used
		driver = new FirefoxDriver(); //initializing browser
	    driver.manage().window().maximize();
	    driver.get("http://www.sportsdirect.com");
	    WebDriverWait wait = new WebDriverWait(driver, 5); //waiting for a pop-up window to be appeared
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='advertPopup' or @class='CountryRedirectModal modal in']"))); 
	    //checking if one out of 2 pop-ups appeared and closing it	    
	    driver.findElement(By.xpath(".//*[@id='advertPopup' or @class='CountryRedirectModal modal in']//button[@class='close']")).click();
	}

	@Given("^selected mens category$")
	public void selected_mens_category() {
		driver.findElement(By.xpath(".//*[@id='topMenu']//li[1]/*[@href='/mens']")).click();	
	}

	@Given("^choose mens shoes$")
	public void choose_mens_shoes() {
		driver.findElement(By.xpath(".//ul[@class='Mens']//a[.='Shoes']")).click();	
		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='advertPopup' or @class='CountryRedirectModal modal in']")));
	    driver.findElement(By.xpath(".//*[@id='advertPopup' or @class='CountryRedirectModal modal in']//button[@class='close']")).click();
	}
	
	@Given("^select specific brands$")
	public void select_specific_brands() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[@class='FilterAnchor']//*[text()='Firetrap']")).click();
		driver.findElement(By.xpath(".//a[@class='FilterAnchor']//*[text()='Skechers']")).click();
	}
	
	@Given("^set a min price (\\d+) euro$")
	public void set_a_min_price_euro(int lowestPrice) {
		driver.findElement(By.xpath(".//*[@id='PriceFilterTextEntryMin']")).sendKeys("" + lowestPrice);	
	}

	@Given("^set a max price (\\d+) euro$")
	public void set_a_max_price_euro(int highestPrice) {
		driver.findElement(By.xpath(".//*[@id='PriceFilterTextEntryMax']")).sendKeys("" + highestPrice);	
	}

	@When("^I filter the list of items$")
	public void i_filter_the_list_of_items() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='PriceFilterTextEntryApply']")).click();
	}

	@Then("^I see only specific brand shoes$")
	public void i_see_only_specific_brand_shoes() {
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //set a timer because of unexpected errors during the flow
		  
		  /*Idea is to collect all elements in one list and compare each element with predefined values - Firetrap and Skechers*/
		  
		  List<WebElement> names = driver.findElements(By.xpath(".//*[@class='productdescriptionbrand']")); //collecting shoe brand names for all filtered elements
		    for (WebElement element : names) {
		            String name = element.getText(); //extracting a text from element
		            
		            List<String> collection = new ArrayList<>(); //storing desired brands to compare with
		            collection.add("Firetrap");
		            collection.add("Skechers");
		            
		            boolean elementExist = false;	            
		            for (String firetrap : collection) {    //goes through all the elements in list
		            	if (firetrap.equals(name)) {        //checks that current element matches with one of the stored brands
		            		elementExist = true;
		            		break;
		            	}
		            }
		            Assert.assertTrue(elementExist);   //final condition to pass the step so items are filtered correctly, if not equal - test failed
		        }
		    System.out.println("There are only Firetrap and Skechers brand shoes");
	}
	
	@Then("^dont see shoes with the price less than (\\d+) euro and more than (\\d+) euro$")
	public void don_t_see_shoes_with_the_price_less_than_euro_and_more_than_euro(float minPrice, float maxPrice) {
		
		  List<WebElement> prices = driver.findElements(By.xpath(".//div[@class='s-largered']//*[last()]")); 
		  //collecting shoe price values for all filtered items. using last as some elements have word 'from' in front of the price
		    for (WebElement element : prices) {			 
		            String currency = element.getText().replaceAll("£", ""); //extracting the price string and deleting currency symbol to make possible to parse the value
		            float f = Float.parseFloat(currency); //parsed to float as few price values has decimal format
		            Assert.assertTrue("price is lower", f >= minPrice); //will throw a message if found less than 30
		            Assert.assertTrue("price is higher", f <= maxPrice); //if more than 60
		        }
		    System.out.println("No shoes with price less than 30 euro and more than 60 euro");
		    driver.quit();
	}
}
