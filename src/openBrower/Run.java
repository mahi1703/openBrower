package openBrower;

import java.io.IOException;

public class Run {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		 TakePicture.getBrowser("firefox");
		 TakePicture.driver.get("https://www.fb.com/");
		 TakePicture.getScreenShot("facebook_welcome_page");
		 	
	}
}

 