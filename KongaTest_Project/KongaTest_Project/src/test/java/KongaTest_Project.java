import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest_Project {
        //import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //Locate where the chromebrowser is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Open the Chrome Browser
        driver = new ChromeDriver();
        //1. Visit the URL Konga (https://www.konga.com/)
        driver.get("https://www.konga.com");
        // Test1.Verify that user input the right URL and it's on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
            //Pass
            System.out.println("Current Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(10000);

        //Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void signin() throws InterruptedException {
        //2. Sign into Konga successfully
        //Click on the Signin button to open the Signin page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

        //Input an Email address in the email field
        driver.findElement(By.id("username")).sendKeys("abimbolasamson0602@gmail.com");
        Thread.sleep(2000);
        //Input a password address in the password field
        driver.findElement(By.id("password")).sendKeys("GodAlmighty0216");
        Thread.sleep(2000);
        //Click on Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void Categories() throws InterruptedException {
        //3. From the Categories, Select the "Computers and Accessories"
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));

        //Create an instance of Actions class
        Actions actions = new Actions(driver);
        //Hover over the element
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void selectMacBook() throws InterruptedException {
        //Select MacBook
        driver.findElement(By.xpath("//*[@id=\"subFixId\"]/div/div/div[1]/a[6]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void additemtocart() throws InterruptedException {
        //Test. Verify that the item selected is successfully added to the cart
        //Select the Apple MacBook option
        //Choose the Item to buy
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[4]/div/div/div[1]/a[1]/picture/img")).click();
        Thread.sleep(10000);
        //Buy item now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(15000);
    }

    @Test (priority = 4)
    public void Checkout() throws InterruptedException {
        //Click on "Continue to checkout" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[4]/div/div[6]/div/a")).click();
        Thread.sleep(15000);
        //Click on "Pay now"
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(10000);

        //Click on "Continue to Payment" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(15000);
        //Switch iFrame
        WebElement paymentMethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(15000);
        //Select card method
        WebElement cardPayment = driver.findElement(By.className("Card"));
        cardPayment.click();
        Thread.sleep(15000);
    }

    @Test (priority = 5)
    public void invalidCardDetails() throws InterruptedException {
        //10. Input invalid card details
        //Test.Verify that invalid card details are inputted in the card number field
        // Input the CardNumberField in the space provided
        driver.findElement(By.id("card-number")).sendKeys("5125 6789 0568 9534");
        // Input the DateField in the Date Field provided
        driver.findElement(By.id("expiry")).sendKeys("0827");
        // Input the cvv field in the cvv field provided
        driver.findElement(By.id("cvv")).sendKeys("845");

    }

    @Test (priority = 6)
    public void errorMessage() throws InterruptedException {
        //Test Verify that the error message for invalid card number is displayed
        //11. Print out the error message: Invalid card number
        WebElement message = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));
        System.out.println(message.getText());
    }

    @Test (priority = 7)
    public void closeiFrame() throws InterruptedException {
        //12. Close the iFrame that displays the input card modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();

    }

    @AfterTest
    public void closeBrowser() {
        //13. Quit the browser
        driver.quit();
    }

}
