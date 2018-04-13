import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.ConfigDriver;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty:target/pr.txt", "html:target/ht", "json:target/js.json"}
        //features = {"src/test/resources/sanity.feature"},
        //glue = "com.test.steps"
)

public class RunTest {
    @BeforeClass
    public static void startServer() {
        /* To start Appium server, method implemented in ConfigDriver Class */
        ConfigDriver.startServer();
    }

    @AfterClass
    public static void beforeAll() {
    /* To stop Appium server */
        ConfigDriver.stopServer();
    }
}
