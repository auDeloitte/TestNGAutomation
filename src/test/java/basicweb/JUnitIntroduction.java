package basicweb;

import static org.junit.Assert.*;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JUnitIntroduction {

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		System.out.println("Executing Before Class...");
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		System.out.println("Executing After Class...");
//	}
	
	private WebDriver driver;
	private String baseURL;
	JavascriptExecutor js;
	ExtentReports report;
	ExtentTest test;

	@org.testng.annotations.BeforeClass
	public void setUp() throws Exception {
		report = new ExtentReports("C:\\Users\\audortiz\\Documents\\loginTest.html");
		test = report.startTest("Verify Welcome Test");
		
		driver = new ChromeDriver();
//		js = (JavascriptExecutor)driver;
		baseURL = "https://www.letskodeit.com/practice";
		test.log(LogStatus.INFO, "Browser Started");
//		baseURL = "https://jqueryui.com/slider/";
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		test.log(LogStatus.INFO, "Web Application Opened");
	}

	@org.testng.annotations.AfterMethod
	public void tearDown(ITestResult testResult) throws Exception {
		if(testResult.getStatus() == ITestResult.FAILURE) {
		String filename = testResult.getName() + ".png";
		String directory = "C:\\\\Users\\\\audortiz\\\\Documents\\\\loginTest.html";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));
		String path = directory + filename;
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.FAIL, "Completion Failed!", imagePath);
		Thread.sleep(3000);
	}
		driver.quit();
		report.endTest(test);
		report.flush();
		
	}

	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for(int i = 0; i < length; i++) {
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@org.testng.annotations.Test(description = "Select all text test")
	public void test() throws InterruptedException {

		Thread.sleep(2000);
//		WebElement element = driver.findElement(By.id("Login"));
//		element.click();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		test.log(LogStatus.INFO, "Selected all text");
		test.log(LogStatus.PASS, "Complete!");
		
//		driver.findElement(By.xpath("//*[@id=\"openwindow\"]")).sendKeys(Keys.CONTROL + "a");
		
//		driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//		Thread.sleep(2000);
		
//		Thread.sleep(2000);
//		driver.switchTo().frame(0);
//		
//		WebElement fromElement = driver.findElement(By.id("draggable"));
//		WebElement toElement = driver.findElement(By.id("droppable"));
//		
//		Actions action = new Actions(driver);
		
//		action.dragAndDrop(fromElement, toElement).build().perform();
		
//		action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		
//		js.executeScript("window.scrollBy(0, 600)");
//		Thread.sleep(2000);
//		
//		WebElement mainElement = driver.findElement(By.id("mousehover"));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(mainElement).perform();
//		Thread.sleep(2000);
//		
//		WebElement subElement = driver.findElement(By.xpath("//*[@id=\"mouse-hover-example-div\"]/div[1]/fieldset/div/div/a[1]"));
//		action.moveToElement(subElement).click().perform();
		
//		Thread.sleep(2000);
//		driver.switchTo().frame("courses-iframe");
//		driver.switchTo().frame("iframe-name");
//		WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/form/div/input"));
//		searchBox.sendKeys("python");
//		driver.switchTo().defaultContent();
//		Thread.sleep(5000);
//		driver.findElement(By.id("name")).sendKeys("Test successful");
		
		
		
//		String parentHandle = driver.getWindowHandle();
//		System.out.println("Parent handle: " + parentHandle);
//		
//		WebElement openWindow = driver.findElement(By.id("openwindow"));
//		openWindow.click();
//		
//		Set<String>  handles = driver.getWindowHandles();
//		
//		for(String handle : handles) {
//			System.out.println(handle);
//			if(!handle.equals(parentHandle)) {
//				driver.switchTo().window(handle);
//				Thread.sleep(3000);
//				WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/form/div/input"));
//				searchBox.sendKeys("python");
//				Thread.sleep(2000);
//				driver.close();
//				break;
//			}
//			driver.switchTo().window(parentHandle);
//			driver.findElement(By.id("name")).sendKeys("Test Successful");
//		}
		
//		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/nav/div/div[2]/div/div/a")).click();
		
		
//		WebElement textBox = driver.findElement(By.id("displayed-text"));
//		System.out.println("Text Box Displayed: " + textBox.isDisplayed());
//		
//		Thread.sleep(3000);
//		
//		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
//		hideButton.click();
//		System.out.println("Clicked on hide button");
//		System.out.println("Text Box Displayed: " + textBox.isDisplayed());
//		
//		Thread.sleep(3000);
//		
//		WebElement showButton = driver.findElement(By.id("show-textbox"));
//		showButton.click();
//		System.out.println("Clicked on show button");
//		System.out.println("Text Box Displayed: " + textBox.isDisplayed());
//		
//		Thread.sleep(3000);
		
		
		
//		WebElement e1 = driver.findElement(By.id("multiple-select-example"));
//		Select sel = new Select(e1);
//		
//		Thread.sleep(3000);
//		System.out.println("Select orange by value");
//		sel.selectByValue("orange");
//		Thread.sleep(3000);
//		System.out.println("De-select orange by value");
//		sel.deselectByValue("orange");
//		Thread.sleep(3000);
//		System.out.println("Select peach by index");
//		sel.selectByIndex(2);
//		Thread.sleep(3000);
//		System.out.println("Select Apple by visible text");
//		sel.selectByVisibleText("Apple");
//		Thread.sleep(3000);
//		System.out.println("Print all selected options");
//		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
//		for(WebElement option : selectedOptions) {
//			System.out.println(option.getText());
//		}
//		Thread.sleep(3000);
//		System.out.println("De-select all selected options");
//		sel.deselectAll();
		
		
//		WebElement e1 = driver.findElement(By.id("carselect"));
//		Select sel = new Select(e1);
//		
//		Thread.sleep(3000);
//		sel.selectByValue("benz");
//		System.out.println("Selected Benz by Value");		
//		Thread.sleep(3000);
//		sel.selectByIndex(2);
//		System.out.println("Selected Honda by Index");
//		Thread.sleep(3000);
//		sel.selectByVisibleText("BMW");
//		System.out.println("Selected BMW by visible text");
//		Thread.sleep(3000);
//		System.out.println("Printing list of all options");
//		List<WebElement> options = sel.getOptions();
//		int size = options.size();
//		for(int i = 0; i < size; i++) {
//			String optionName = options.get(i).getText();
//			System.out.println(optionName);
//		}
////		driver.get(baseURL);
//		String title = driver.getTitle();
//		System.out.println("Title of the page is: " + title);
//		String currentURL = driver.getCurrentUrl();
//		System.out.println("Current URL is: " + currentURL);
//		String URLToNavigate = "https://mongoosejs.com/docs/guides.html";
//		driver.navigate().to(URLToNavigate);
//		currentURL = driver.getCurrentUrl();
//		System.out.println("Current URL is: " + currentURL);
//		Thread.sleep(3000);
//		driver.navigate().back();
//		currentURL = driver.getCurrentUrl();
//		System.out.println("Navigate back");
//		System.out.println("Current URL is: " + currentURL);
//		Thread.sleep(3000);
//		driver.navigate().forward();
//		System.out.println("Navigate forward");
//		currentURL = driver.getCurrentUrl();
//		System.out.println("Current URL is: " + currentURL);
//		Thread.sleep(3000);
//		driver.navigate().back();
//		currentURL = driver.getCurrentUrl();
//		System.out.println("Navigate back");
//		System.out.println("Current URL is: " + currentURL);
//		driver.navigate().refresh();
//		System.out.println("Navigate Refresh");
//		driver.get(currentURL);
//		System.out.println("Navigate Refresh");
//		
//		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);
//		driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[1]/a")).click();
//		driver.findElement(By.xpath("/html/body/div/div[2]/nav/ul/li[2]/input")).click();
//		driver.findElement(By.xpath("/html/body/div/div[2]/nav/ul/li[2]/input")).sendKeys("Models");
//		driver.findElement(By.xpath("/html/body/div/div[2]/nav/ul/li[2]/button")).click();
	}

}
