package org.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactUsPage {
    public static final Target CONTACT_US_MENU =
            Target.the("Contact Us menu")
                    .located(By.xpath("//a[text()=' Contact us']"));

    public static final Target NAME =
            Target.the("Name field")
                    .located(By.name("name"));

    public static final Target EMAIL =
            Target.the("Email field")
                    .located(By.name("email"));

    public static final Target SUBJECT =
            Target.the("Subject field")
                    .located(By.name("subject"));

    public static final Target MESSAGE =
            Target.the("Message field")
                    .located(By.id("message"));

    public static final Target UPLOAD_FILE =
            Target.the("Upload file")
                    .located(By.name("upload_file"));

    public static final Target SUBMIT =
            Target.the("Submit button")
                    .located(By.name("submit"));

    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .located(By.cssSelector(".status.alert-success"));

    public static final Target HOME_BUTTON =
            Target.the("Home button")
                    .located(By.xpath("//a[@class='btn btn-success']"));
}
