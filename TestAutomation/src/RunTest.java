import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RunTest {
	
@Test
	
	public static void main (String[] args) throws InterruptedException{
	
		
//set chrome driver location
	System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	
//open the web app
	driver.navigate().to("https://tmsandbox.co.nz");
	driver.manage().window().maximize();
	
//login to the trade site
	
	driver.findElement(By.xpath("//*[@id=\"LoginLink\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"page_email\"]")).sendKeys("lata@joshi.live");
	driver.findElement(By.xpath("//*[@id=\"page_password\"]")).sendKeys("trade123#");
	driver.findElement(By.xpath("//*[@id=\"LoginPageButton\"]")).click();
	Thread.sleep(5000);
	
	
//click on computers
	
	driver.findElement(By.xpath("//*[@id=\"main-box-categories\"]/div/div[1]/ul/li[7]/a")).click();
			
	Thread.sleep(5000);
	
// find sub-category Software in computers
	
	driver.findElement(By.xpath("//*[@id=\"searchString\"]")).sendKeys("Software");
	
	driver.findElement(By.id("searchString")).sendKeys(Keys.ENTER);	
	
//Search for the  number of product listing in software sub-category
	
	driver.findElement(By.id("searchString")).clear();	
	driver.findElement(By.id("searchString")).sendKeys("Product");
	driver.findElement(By.id("searchString")).sendKeys(Keys.ENTER);	
	
//Total number available after product search
	List<WebElement> totalproduct = driver.findElements(By.xpath("//*[@id=\"headerColumnGalleryViewText\"]"));
	System.out.println("Total product Count :  " +totalproduct.size());
	Thread.sleep(5000);   
	
//hover in item to add into watchlist
	
	Actions actions = new Actions(driver);
	WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[8]/div[1]/a[1]/div/div[1]"));
	actions.moveToElement(menuOption).perform();
    System.out.println("Done Mouse hover on 'one item' from Menu");
    
 //Now add one 'Item' from listing which has got displayed on mouse hover of given 'items'
   
    driver.findElement(By.xpath("//*[@id=\"watchlist2149272857\"]")).click(); 
   
  	Thread.sleep(2000);
	
//verify item has been added to watchlist
  	
  	driver.findElement(By.xpath("//*[@id=\"SiteHeader_SiteTabs_myTradeMeDropDownLink\"]/span")).click();
    
	Thread.sleep(1000);
	
// total number of added items in watchlist
	
	int watchlistresult = driver.findElements(By.xpath("//*[@id=\"watchlistCount\"]")).size();
    System.out.println("Total watchlist Count :  " +watchlistresult);  
	   
//Logout from the trade site
    
    driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div[3]/div/form/p/input[2]")).click();

	
	driver.close();

}
	}
