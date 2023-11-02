package dockerIntegration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class dockerintergration2 {
	
	@Test
	
	void firstTest () throws MalformedURLException, InterruptedException {
		
    ChromeOptions options = new ChromeOptions();
		  
	options.addArguments("--no-sandbox");
		
	DesiredCapabilities cap=new DesiredCapabilities();
	
	cap.setBrowserName("chrome");
	
	cap.setPlatform(Platform.LINUX);
	
	//cap.setVersion(version);
	
	cap.setCapability(ChromeOptions.CAPABILITY, options);
	
	//System.setProperty("webdriver.chrome.silentOutput", "true");

	//System.setProperty("webdriver.http.factory", "jdk-http-client");
	
	WebDriver driver=new RemoteWebDriver(new URL("http://172.17.0.3:4444/wd/hub"), cap);
	
	driver.get("https://www.google.co.uk/");
	
	System.out.println("title :"+driver.getTitle());
	
	System.out.println("docker intro");
	
    Thread.sleep(10000);
    
	driver.quit();
		
}

}
