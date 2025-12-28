package org.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.userinterface.ContactUsPage;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.userinterface.ContactUsPage.SUBMIT;

public class SubmissionResult implements Question<Boolean> {

    public static SubmissionResult value() {
        return new SubmissionResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        try {
            // Espera hasta 5-10 segundos a que el mensaje de éxito sea visible
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(ContactUsPage.SUCCESS_MESSAGE.resolveFor(actor)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }


    }
}