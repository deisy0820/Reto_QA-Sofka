package org.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Subject("Remove advertising iframes")
public class RemoveAds implements Task {

    public static RemoveAds fromPage() {
        return instrumented(RemoveAds.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        JavascriptExecutor js = (JavascriptExecutor)
                BrowseTheWeb.as(actor).getDriver();

        js.executeScript(
                "document.querySelectorAll('iframe').forEach(i => i.remove());"
        );
    }
}
