import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {
        public static WebDriver driver;

        @BeforeMethod
        public void initialize() {
            Reporter.log("Initializing browser");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Reporter.log("Navigating to home page");
            driver.get("file:///D:/OOPS/index.html");
        }

        @AfterMethod
        public void TeardownTest()
        {
            TestBase.driver.quit();
        }

}
