package registerTestcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepageclass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String br) {
		rb = ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(this.getClass());

		if (br.equals("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
//			options.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
			driver = new ChromeDriver(options);
		} 
		else if (br.equals("edge"))
		{
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			driver = new EdgeDriver(options);
		} 
		else
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless", "--window-size=1920,1080");
			driver = new FirefoxDriver(options);
		}
		
//		WebDriverManager.chromedriver().setup();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(rb.getString("appurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
//	public void navigate() {
//		if(driver.getCurrentUrl() != rb.getString("appurl")) {
//			driver.get(rb.getString("appurl"));
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//	}

}
