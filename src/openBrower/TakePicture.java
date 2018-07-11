package openBrower;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TakePicture {
	public static WebDriver driver;
	public static void getScreenShot(String imageName) throws IOException{
		if(imageName.equals("")){
			imageName= "blank";
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir")+"\\src\\screenshot\\";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualimagName =imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		System.out.println(actualimagName);
		File destFile = new File(actualimagName);
		FileUtils.copyFile(image, destFile);
	}
	public static void getBrowser(String browser){
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.drive",System.getProperty("user.dir")+"/src/drivers/geckodriver.exe");
				driver= new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
	}
}
