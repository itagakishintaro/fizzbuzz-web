package fizzbuzz;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import cucumber.annotation.ja.*;
import fizzbuzz.model.Fizzbuzz;
import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class FizzbuzzAcceptanceTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String call, answer;
	private WebElement we;

	@Before
	public void setUp() throws Exception {
		FirefoxBinary binary = new FirefoxBinary(new File("D:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(binary, profile);

		baseUrl = "http://localhost:8880/fizzbuzz-web/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(baseUrl);
	}

	public void setInput(String call){
		this.call = call;
	    driver.findElement(By.name("call")).clear();
		driver.findElement(By.name("call")).sendKeys(call);
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		we = driver.findElement(By.tagName("div"));
	}

	@もし("^\"([^\"]*)\"が３の倍数$")
	public void が３の倍数(String call) throws Throwable {
		setUp();
		setInput(call);
	}

	@ならば("^answerはfizzであるべき$")
	public void answerはfizzであるべき() throws Throwable {
	    assertThat(we.getText(), is("答え：fizz"));
	    tearDown();
	}

	@もし("^\"([^\"]*)\"が５の倍数$")
	public void が５の倍数(String call) throws Throwable {
		setUp();
		setInput(call);
	}

	@ならば("^answerはbuzzであるべき$")
	public void answerはbuzzであるべき() throws Throwable {
		assertThat(we.getText(), is("答え：buzz"));
	    tearDown();
	}

	@もし("^\"([^\"]*)\"が３の倍数かつ５の倍数$")
	public void が３の倍数かつ５の倍数(String call) throws Throwable {
		setUp();
		setInput(call);
	}

	@ならば("^answerはfizzbuzzであるべき$")
	public void answerはfizzbuzzであるべき() throws Throwable {
		assertThat(we.getText(), is("答え：fizzbuzz"));
	    tearDown();
	}

	@もし("^\"([^\"]*)\"が整数以外$")
	public void が整数以外(String call) throws Throwable {
		setUp();
		setInput(call);
	}

	@ならば("^answerは\"([^\"]*)\"であるべき$")
	public void answerは_であるべき(String arg1) throws Throwable {
		assertThat(we.getText(), is("答え："+call));
	    tearDown();
	}


	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
