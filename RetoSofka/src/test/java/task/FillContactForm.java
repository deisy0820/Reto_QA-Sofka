package task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import org.openqa.selenium.remote.RemoteWebDriver;
import userinterface.ContactUsPage;


import java.nio.file.Paths;

import static userinterface.ContactUsPage.MESSAGE;

public class FillContactForm implements Task {

    public static FillContactForm withData() {
        return Tasks.instrumented(FillContactForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (actor.abilityTo(net.serenitybdd.screenplay.abilities.BrowseTheWeb.class) != null) {
            if (BrowseTheWeb.as(actor).getDriver() instanceof RemoteWebDriver) {
                RemoteWebDriver remote = (RemoteWebDriver) BrowseTheWeb.as(actor).getDriver();
                ((RemoteWebDriver) remote).setFileDetector(new org.openqa.selenium.remote.LocalFileDetector());
            }
        }

        actor.attemptsTo(
                Enter.theValue("Daisy QA").into(ContactUsPage.NAME),
                Enter.theValue("daisy@test.com").into(ContactUsPage.EMAIL),
                Enter.theValue("Automation Test").into(ContactUsPage.SUBJECT),
                Enter.theValue("Mensaje de prueba automatizada").into(MESSAGE),
                Upload.theFile(
                        Paths.get("src/test/resources/files/test.txt").toFile().toPath()
                ).to(ContactUsPage.UPLOAD_FILE)
        );
    }
}
