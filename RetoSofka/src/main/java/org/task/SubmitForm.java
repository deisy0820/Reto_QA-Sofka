package org.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.actions.Click;

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




