package org.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import org.userinterface.ContactUsPage;

import java.nio.file.Paths;

public class FillContactForm implements Task {

    public static FillContactForm withData() {
        return Tasks.instrumented(FillContactForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("Daisy QA").into(ContactUsPage.NAME),
                Enter.theValue("daisy@test.com").into(ContactUsPage.EMAIL),
                Enter.theValue("Automation Test").into(ContactUsPage.SUBJECT),
                Enter.theValue("Mensaje de prueba automatizada").into(ContactUsPage.MESSAGE),
                Upload.theFile(
                        Paths.get("src/test/resources/files/test.txt")
                ).to(ContactUsPage.UPLOAD_FILE)
        );

    }
}
