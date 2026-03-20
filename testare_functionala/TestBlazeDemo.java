import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;

//https://opensource-demo.orangehrmlive.com

public class TestBlazeDemo {

    private WebDriver driver;

    @Before
    public void setUp() {
        //pentru Java 11+
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @Test
    public void testAchizitieBilet()
    {
        driver.get("https://blazedemo.com/");
        sleep(1000);
        driver.findElement(By.name("fromPort")).click();
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Boston");
        sleep(1000);
        driver.findElement(By.name("toPort")).click();
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
        sleep(1000);
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//tr[4]/td/input")).click();
        sleep(1000);
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).clear();
        driver.findElement(By.id("inputName")).sendKeys("test");
        sleep(1000);
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("test");
        sleep(1000);
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("test");
        sleep(1000);
        driver.findElement(By.id("state")).clear();
        driver.findElement(By.id("state")).sendKeys("test");
        sleep(1000);
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).clear();
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        sleep(1000);
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).clear();
        driver.findElement(By.id("creditCardNumber")).sendKeys("12345");
        sleep(1000);
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).clear();
        driver.findElement(By.id("nameOnCard")).sendKeys("test");
        sleep(1000);
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        sleep(1000);
        if(driver.getPageSource().contains("Thank you for your purchase today!")) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
        sleep(1000);
    }

    @After
    public void closeWindow()
    {
        driver.close();
    }
}
