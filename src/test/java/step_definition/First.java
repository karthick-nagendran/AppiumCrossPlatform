package step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class First {
    @Given("^I am on App landing page$")
    public void iAmOnAppLandingPage() throws Throwable {
        System.out.println("First scenario");
    }
}
