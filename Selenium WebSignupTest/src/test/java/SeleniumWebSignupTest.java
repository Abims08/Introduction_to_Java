import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    // Import the Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        // locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome Browser
        driver = new ChromeDriver();
        //2.Input your selenium Demo page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        // Test1.Verify that user input the right URL and it's on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3.maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test7.Verify that user is successfully signed up when valid details are inputted
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("annah467");
        //6. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("annah456@malinator.com");
        //7.Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("werent34");
        //8. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickUser1Item() throws InterruptedException {
        //9.Click on User1 Item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test8.Verify that User1 item is present on the item list page
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users.3282";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct User1 page");
        else
            //Fail
            System.out.println("Wrong User1 page");
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //10.Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test9. Verify that the item searched for on the User1 page is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct User1 Page");
        else
            //Fail
            System.out.println("Wrong User1 Page");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void  logoutSuccessfully() {
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10. Verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
    }

    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test3.Verify that user cannot Signup with username less than 3 characters
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ba");
        //6. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("annah458@malinator.com");
        //7.Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("werent34");
        //8. Click on Signup button
        Thread.sleep(5000);
        driver.findElement(By.id("submit")).click();
    }
/**@Test (priority = 5)
    public void negativeSignup1() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test4.Verify that user cannot Signup with invalid email address
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("annah457");
        //6. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("an45mailinator.com");
        //7.Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("werent34");
        //8. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void negativeSignup2() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test5.Verify that user cannot login with password less than or equal to one character
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("hannah457");
        //6. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("hannah45678@malinator.com");
        //7.Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("<w");
        //8. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void negativeSignup3() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test6.Verify that user cannot Signup with either/all of the fields blank
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys(" ");
        //6. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys(" ");
        //7.Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys(" ");
        //8. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
 */

    @AfterTest
    public void closeBrowser() {
        //9. Quit the browser
        driver.quit();
    }






    }





