package dockerIntegration;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dockerIntro {
		
		@Test(dataProvider ="getdata")
		
		void firstTest (String browser) throws MalformedURLException {
			
	    ChromeOptions options = new ChromeOptions();
			  
		options.addArguments("--no-sandbox");
			
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setBrowserName(browser);
		
		cap.setPlatform(Platform.LINUX);
		
		//cap.setVersion(version);
		
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		//System.setProperty("webdriver.chrome.silentOutput", "true");

		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
		driver.get("https://www.google.co.uk/");
		
		System.out.println("title :"+driver.getTitle());
		
		System.out.println("docker intro");
		
		driver.quit();
			
	}
		
	@DataProvider(parallel = true)	
	
     public Object[][] getdata(){
		
		return new Object[][]
				
				{{"chrome"},{"firefox"}};
    	 
     }
		
}
