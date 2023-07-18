package practicesessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosearch {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("Bha");
	List<WebElement> list	= driver.findElements(By.xpath("//ul/li[@class='ui-menu-item']"));
		
		System.out.println("total numbers of suggestions" + list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("Bhadrachalam")){
				list.get(i).click();
				break;
			}
		}
		driver.quit();

	}

}
