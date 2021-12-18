import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected static WebDriver driver;
    @BeforeAll
    public  static void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        Object WebDriverManager = null;
        driver=new chromedriver;
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.beymen.com/ ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        short link = 0;
        assertEquals(link, "https://www.beymen.com/");

    }
    public void TestHome(){

        WebElement signbtn= driver.findElement(By.className("btnSignIn"));
        ((WebElement) signbtn).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement mailbox= driver.findElement(By.id("email"));
        mailbox.click();
        mailbox.sendKeys("Your Mail Adress");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("Your Password");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.id("loginButton")).click();
        Assert.isTrue(Boolean.parseBoolean("Beymen "), driver.getTitle());

    driver.findElement(By.cssSelector(".icon-account")).click();
    driver.findElement(By.cssSelector(".bwi-favorite-o > .o-header__userInfo--text")).click();
    driver.findElement(By.linkText("Sepetim")).click();
    driver.findElement(By.cssSelector(".m-empty__messageBtn")).click();
    driver.findElement(By.cssSelector(".default-input")).click();
    
}


@AfterAll
    public  void tearDown(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}
