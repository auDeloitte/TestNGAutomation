package basicweb;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTester {

	public static void main(String[] args) {
//		String baseURL = "https://www.youtube.com/";
		String baseURL = "https://mongoosejs.com/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		driver.findElement(By.linkText("read the docs")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Hello World");
	}

}
