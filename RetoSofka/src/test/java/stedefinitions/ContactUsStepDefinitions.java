package stedefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.serenitybdd.screenplay.actions.Click;
import org.config.BrowserStackDriver;
import org.openqa.selenium.WebDriver;
import org.questions.SubmissionResult;
import org.task.*;
import org.userinterface.ContactUsPage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ContactUsStepDefinitions {

    private Actor user;
    private BrowserStackDriver driverSetup;
    private WebDriver driver;

    @Before
    public void setup() {
        driverSetup = new BrowserStackDriver();
        driver = driverSetup.createDriver();

        user = Actor.named("User");
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario ingresa a Automation Exercise")
    public void openHome() {
        user.wasAbleTo(OpenHome.page());
    }

    @When("navega al formulario Contact Us")
    public void goToContactUs() {
        user.attemptsTo(
                Click.on(ContactUsPage.CONTACT_US_MENU)
        );
    }

    @And("completa el formulario con archivo adjunto")
    public void fillForm() {
        user.attemptsTo(
                FillContactForm.withData(),
                SubmitForm.now()
        );
    }

    @Then("valida el mensaje de éxito")
    public void validateSuccess() {
        user.should(
                seeThat(
                        SubmissionResult.value(),
                        is(true)
                )
        );
    }

    @And("regresa al Home")
    public void goHome() {
        user.attemptsTo(
                Click.on(ContactUsPage.HOME_BUTTON)
        );
    }
}