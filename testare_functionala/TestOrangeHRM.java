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

public class TestOrangeHRM {

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
    public void testVerificareAngajat()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        sleep(1000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        sleep(1000);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");
        sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(1000);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        sleep(1000);
        driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[5]/a/span")).click();
        sleep(1000);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
        sleep(1000);
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/div/div/div[2]/div/div/input")).click();
        sleep(1000);
        //driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/div/div/div[2]/div/div/input")).sendKeys("Joe ");
        //sleep(4000);
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/div/div/div[2]/div/div/input")).clear();
        sleep(1000);
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/div/div/div[2]/div/div/input")).sendKeys("Joe d Doe");
        sleep(4000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(1000);
        if(driver.getPageSource().contains("(1) Record Found")) {
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
