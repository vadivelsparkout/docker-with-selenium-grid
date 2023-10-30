package dockerIntegration;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class dockerIntro {
		
		@Test(priority = 1)
		void firstTest () throws MalformedURLException {
			
	    ChromeOptions options = new ChromeOptions();
			  
		options.addArguments("--no-sandbox");
			
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setBrowserName("chrome");
		
		cap.setPlatform(Platform.LINUX);
		
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		//System.setProperty("webdriver.chrome.silentOutput", "true");

		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver=new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"), cap);
		
		driver.get("https://www.google.co.uk/");
		
		System.out.println("title :"+driver.getTitle());
		
		System.out.println("docker intro");
		
		driver.quit();
			
	}
		
        @Test(priority = 2)
		void secondTest () throws MalformedURLException {
			
	    FirefoxOptions options = new FirefoxOptions();
			  
		options.addArguments("--no-sandbox");
			
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setBrowserName("firefox");
		
		cap.setPlatform(Platform.LINUX);
		
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		//System.setProperty("webdriver.chrome.silentOutput", "true");

		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver=new RemoteWebDriver(new URL("http://172.17.0.3:4444/wd/hub"), cap);
		
		driver.get("https://www.google.co.uk/");
		
		System.out.println("title :"+driver.getTitle());
		
		System.out.println("docker intro");
		
		driver.quit();
			
	}
		
}
