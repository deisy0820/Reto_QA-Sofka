package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import userinterface.ContactUsPage;

import java.time.Duration;



public class SubmissionResult implements Question<Boolean> {

    public static SubmissionResult value() {
        return new SubmissionResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(ContactUsPage.SUCCESS_MESSAGE.resolveFor(actor)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }


    }
}