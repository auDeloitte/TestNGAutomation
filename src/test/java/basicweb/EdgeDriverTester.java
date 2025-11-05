package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverTester {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String baseURL = "https://my.dnet.deloitte.com/";
		driver.get(baseURL);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}
}
