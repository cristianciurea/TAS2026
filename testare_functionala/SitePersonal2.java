import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SitePersonal2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://cristianciurea.ase.ro/Resume.aspx");
        driver.manage().window().maximize();
    }

    // metoda generica pentru cautare text in pagina
    public void verificaCompetenta(String competenta) {
        if(driver.getPageSource().contains(competenta)) {
            System.out.println("Test passed! Exista: " + competenta);
        } else {
            System.out.println("Test failed! Nu exista: " + competenta);
        }
    }

    @Test
    public void testCautareCompetente() {

        String[] competente = {
                "FRANCEZĂ",
                "ENGLEZĂ",
                "Certificari",
                "Experienta",
                "Educatie",
                "Competente",
                "Proiecte"
        };

        for(String c : competente) {
            verificaCompetenta(c);
        }
    }

    @After
    public void closeWindow() {
        driver.quit();
    }
}
