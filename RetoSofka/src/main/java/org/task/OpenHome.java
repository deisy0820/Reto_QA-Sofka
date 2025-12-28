package org.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Tasks;

public class OpenHome implements Task {

    public static OpenHome page() {
        return Tasks.instrumented(OpenHome.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://automationexercise.com")
        );
    }
}