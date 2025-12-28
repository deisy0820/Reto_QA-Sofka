package stedefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.GivenWhenThen;

import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.questions.SubmissionResult;
import org.task.*;
import org.userinterface.ContactUsPage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.userinterface.ContactUsPage.SUBMIT;

public class ContactUsStepDefinitions {

    Actor user = Actor.named("User");

    @Managed
    WebDriver driver;

    @Before
    public void setup() {
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
//        user.attemptsTo(
//                Click.on(ContactUsPage.HOME_BUTTON)
//        );
//    }
    }
}