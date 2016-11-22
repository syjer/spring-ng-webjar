import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jscover.Main;

public class Test {

	private static Thread server;
	private static Main main = new Main();
	private static String reportDir = "target/reports/jscover-localstorage-general";
	private final static String[] args = new String[] { "-ws", "--port=3129", "--proxy", "--local-storage",
			"--no-instrument=webjars/",
			"--no-instrument=classpath/",
			"--no-instrument=spec/",
		 "--report-dir=" + reportDir };

	private final WebDriver webClient = getWebClient();

	private WebDriver getWebClient() {
		Proxy proxy = new Proxy().setHttpProxy("localhost:3129");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, proxy);
		return new FirefoxDriver(cap);
	}

	@BeforeClass
	public static void setUpOnce() {
		server = new Thread(new Runnable() {
			public void run() {
				main.runMain(args);
			}
		});
		server.start();
	}

	@AfterClass
	public static void tearDownOnce() {
		main.stop();
	}

	@After
	public void tearDown() {
		try {
			webClient.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		try {
			webClient.quit();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	@org.junit.Test
	public void shouldRunExampleAndStoreResultProgrammatically() {
		webClient.get("http://localhost:8234");
		new WebDriverWait(webClient, 20).until(ExpectedConditions.textToBePresentInElementLocated(By.className("jasmine-duration"), "finished"));
		((JavascriptExecutor) webClient).executeScript("jscoverage_report('yooo');");
	}
}
