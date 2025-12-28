package org.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.questions.SubmissionResult;
import org.userinterface.ContactUsPage;

import java.time.Duration;

import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.userinterface.ContactUsPage.SUBMIT;


public class SubmitForm implements Task {

    public static SubmitForm now() {
        return Tasks.instrumented(SubmitForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(SUBMIT),
                AcceptAlert.now()
        );
    }
    }




