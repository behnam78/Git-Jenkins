
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
  public WebDriver driver; 
  
  @Test
  public void openMyBlog() throws InterruptedException {
  driver.get("https://sacauth.csus.edu/csus.cas/login?service=https://my.csus.edu/uPortal/Login%3FrefUrl%3D%2FuPortal%2Ff%2Fhome-tab%2Fnormal%2Frender.uP");
  WebElement w1 = driver.findElement(By.id("username"));
  w1.sendKeys("behnamsalamatishari");
  WebElement w2 = driver.findElement(By.id("password"));
  w2.sendKeys("dd");
  driver.findElement(By.xpath("//*[@id=\"fm1\"]/section[4]/div/input")).click();
  WebElement w3 = driver.findElement(By.xpath("//*[@id=\"fm1\"]/div/span"));
  assertEquals(w3.getText(), "Incorrect SacLink username or password.");
  }
  
  @BeforeClass
  public void beforeClass(){
    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\behna\\OneDrive\\Desktop\\chromedriver.exe");
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
 
  @AfterClass
  public void afterClass() {
   driver.quit();
  }
}
