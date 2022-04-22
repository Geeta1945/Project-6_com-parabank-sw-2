package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    @Before

    public void parasoftUrl(){
        loadUrl();
    }

    /*
    1.verifyThatSigningUpPageDisplay
		* click on the ‘Register’ link
		* Verify the text ‘Signing up is easy!’
     */
    @Test

    public void verifyThatSigningUpPageDisplay(){

        driver.findElement(By.linkText("Register")).click(); // finding register tab and clicking on it
        System.out.println(driver.findElement(By.xpath("//h1[text()='Signing up is easy!']")));
        Assert.assertEquals("Signing up is easy!",driver.findElement(By.xpath("//h1[text()='Signing up is easy!']")).getText());
        // Text() function is selenium webdriver's build in function which is used to locate elements based on text of a web element.

    }

    /*
    2.userSholdRegisterAccountSuccessfully
			* click on the ‘Register’ link
			* Enter First name
			* Enter Last name
			* Enter Address
			* Enter City
			* Enter State
			* Enter Zip Code
			* Enter Phone
			* Enter SSN
			* Enter Username
			* Enter Password
			* Enter Confirm
			* Click on REGISTER button
			* Verify the text 'Your account was created successfully. You are now logged in.’
     */
    @Test

    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.linkText("Register")).click(); // finding register tab and clicking on it

        // Finding all the elements and entering details to register
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("MyFirstname");
        driver.findElement(By.xpath("//input[@name='customer.lastName']")).sendKeys("lastname");
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("14,my street");
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("my city");
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("state");
        driver.findElement(By.xpath("//input[@name='customer.address.zipCode']")).sendKeys("ha2 0py");
        driver.findElement(By.xpath("//input[@name='customer.phoneNumber']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='customer.ssn']")).sendKeys("m734k00");
        driver.findElement(By.xpath("//input[@name='customer.username']")).sendKeys("JosephSmith3");
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("MyPassword123");
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("MyPassword123");
        driver.findElement(By.xpath("//input[@value='Register']")).click();


        // verifying text "Verify the text 'Your account was created successfully. You are now logged in."

       Assert.assertEquals("Your account was created successfully. You are now logged in.",driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText());
    }
    @After

    public void closeUrl(){

       quitAllUrl();
    }




}
