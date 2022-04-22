package browserfactory;

import javafx.beans.property.SetProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;// public static webdriver variable created so it can be accessed globaly
    public String parabankUrl ="https://parabank.parasoft.com/parabank/index.htm";

    public void loadUrl() {
      System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
      driver = new ChromeDriver();// creating chrome driver object
      driver.get(parabankUrl);
      driver.manage().window().maximize();


    }

    public void quitAllUrl(){

        driver.quit();

    }
}
