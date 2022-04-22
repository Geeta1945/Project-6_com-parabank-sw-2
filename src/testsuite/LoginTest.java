package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

public class LoginTest extends BaseTest {

@Before

    public void loadMyUrl(){
    loadUrl();

}
/*
1.userShouldLoginSuccessfullyWithValidCredentials
			* Enter valid username
			* Enter valid password
			* Click on ‘LOGIN’ button
			* Verify the ‘Accounts Overview’ text is display
 */
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
// WebElement username =

    //entering valid credentials and checking for  ‘Accounts Overview’ text is displayed or not
   driver.findElement(By.name("username")).sendKeys("JosephSmith1");
   driver.findElement(By.name("password")).sendKeys("Mypassword123");
   driver.findElement(By.xpath("//input[@value='Log In']")).click();

   String actualMessage =driver.findElement(By.xpath("//h1[text()='Accounts Overview']")).getText();
    Assert.assertEquals("Accounts Overview",actualMessage);

}

/*
2.verifyTheErrorMessage
			* Enter invalid username
			* Enter invalid password
			* Click on Login button
			* Verify the error message ‘The username and password could not be verified.’
 */

    @Test
// Whichever wrong username and password entered for this login , it always ALLOWING TO LOGIN.
// I am not sure why and because of that reason this test fails as system allowing to login wil INVALID ID as well
    public void verifyTheErrorMessage(){
        driver.findElement(By.name("username")).sendKeys("JosephSmith90");
        driver.findElement(By.name("password")).sendKeys("Mypassword123");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String actualMessage =driver.findElement(By.xpath("//h1[text()='The username and password could not be verified.']")).getText();
        Assert.assertEquals("The username and password could not be verified.",actualMessage);

    }
    /*3.userShouldLogOutSuccessfully
     * Enter valid username
     * Enter valid password
     * Click on ‘LOGIN’ button
     * Click on ‘Log Out’ link
     * Verify the text ‘Customer Login’
      */

    @Test
    public void userShouldLogOutSuccessfully(){
        driver.findElement(By.name("username")).sendKeys("JosephSmith1");
        driver.findElement(By.name("password")).sendKeys("Mypassword123");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        driver.findElement(By.xpath("//a[@href='/parabank/logout.htm']")).click();

       String actualMessage= driver.findElement(By.xpath("//h2[text()='Customer Login']")).getText();
       Assert.assertEquals("Customer Login",actualMessage);


    }


@After

    public void closeUrl(){

   quitAllUrl();
}

}
