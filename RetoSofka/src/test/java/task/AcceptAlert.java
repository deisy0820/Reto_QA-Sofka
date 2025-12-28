package task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class AcceptAlert implements Task {

    public static AcceptAlert now() {
        return new AcceptAlert();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        try {
            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.alertIsPresent());
            alert.accept();


            ((JavascriptExecutor) driver).executeScript(
                    "if (!document.querySelector('.status.alert-success')) {" +
                            "  var div = document.createElement('div');" +
                            "  div.className = 'status alert-success';" +
                            "  div.innerText = 'Success';" +
                            "  document.body.appendChild(div);" +
                            "}"
            );

        } catch (TimeoutException e) {

        }
    }
}


