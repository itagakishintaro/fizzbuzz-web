package fizzbuzz;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import cucumber.annotation.ja.*;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import cucumber.annotation.Before;
import cucumber.annotation.After;

public class FizzbuzzAcceptanceTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private String call;
	private WebElement we;

	@Before
	public void setUp() throws Exception {
		setWebdriver();
	}

	public void setWebdriver(){
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
		setInput(call);
	}

	@ならば("^answerはfizzであるべき$")
	public void answerはfizzであるべき() throws Throwable {
	    assertThat(we.getText(), is("答え：fizz"));
	}

	@もし("^\"([^\"]*)\"が５の倍数$")
	public void が５の倍数(String call) throws Throwable {
		setInput(call);
	}

	@ならば("^answerはbuzzであるべき$")
	public void answerはbuzzであるべき() throws Throwable {
		assertThat(we.getText(), is("答え：buzz"));
	}

	@もし("^\"([^\"]*)\"が３の倍数かつ５の倍数$")
	public void が３の倍数かつ５の倍数(String call) throws Throwable {
		setInput(call);
	}

	@ならば("^answerはfizzbuzzであるべき$")
	public void answerはfizzbuzzであるべき() throws Throwable {
		assertThat(we.getText(), is("答え：fizzbuzz"));
	}

	@もし("^\"([^\"]*)\"が３の倍数でも５の倍数でもない$")
	public void が３の倍数でも５の倍数でもない(String call) throws Throwable {
		setInput(call);
	}


	@ならば("^answerは\"([^\"]*)\"であるべき$")
	public void answerは_であるべき(String arg1) throws Throwable {
		assertThat(we.getText(), is("答え："+call));
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
