package test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.csvreader.CsvReader;

@RunWith(Parameterized.class)
public class WebDriveTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  private String id, pwd,address;
  
  public WebDriveTest(String id, String address)
  {
      this.id = id;
      this.pwd = id.substring(4);
      this.address = address;
  }

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Parameters
  public static Collection<Object[]> getData() throws IOException {
      Object[][] obj = new Object[118][];
      CsvReader r = new CsvReader("C:\\Users\\cr\\Desktop\\inputgit.csv", ',',
              Charset.forName("GBK"));
       int count = 0;
       r.readHeaders();
       while(r.readRecord()){
           obj[count] = new Object[]{r.get(0), r.get(2)};
           count++;
       }
       return Arrays.asList(obj);
   }

  @Test
  public void testUntitled2() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys(this.id);
    driver.findElement(By.id("pwd")).clear();
    driver.findElement(By.id("pwd")).sendKeys(this.pwd);
    driver.findElement(By.id("submit")).click();
    System.out.println(this.id);
    assertEquals(this.address, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  @SuppressWarnings("unused")
private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  
}