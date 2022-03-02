
/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;*/
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GitDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://github.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.tagName("input")).sendKeys("react"+ Keys.ENTER);
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.linkText("Advanced search")).click();
		//System.out.println(driver.getTitle());
		driver.findElement(By.id("search_stars")).sendKeys(">45");
		Select drplanguage = new Select(driver.findElement(By.id("search_language")));
		drplanguage.selectByVisibleText("JavaScript");
		Select drplicense = new Select(driver.findElement(By.id("search_license")));
		drplicense.selectByVisibleText("Boost Software License 1.0");
		driver.findElement(By.id("search_followers")).sendKeys(">50");
		js.executeScript("window.scrollBy(0,-1000)", "");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='search-title']//following::input[1]")).getText();		
		driver.findElement(By.xpath("//*[@id='search-title']//following::button")).click();
		System.out.println(driver.getTitle());
		List<WebElement> text = driver.findElements(By.xpath("//*[contains(text(),'1 repository result')]"));
		System.out.println(text.size());
		driver.findElement(By.xpath("//*[contains(text(),'mvoloskov/decider')]")).click();
		System.out.println(driver.getTitle());
		Boolean display = driver.findElement(By.linkText("README.md")).isDisplayed();
		System.out.print(display);
		/*FileReader f = new FileReader((File) driver.findElement(By.linkText("README.md")));
		BufferedReader b = new BufferedReader(f);
		System.out.println(b.readLine());*/
	}

}