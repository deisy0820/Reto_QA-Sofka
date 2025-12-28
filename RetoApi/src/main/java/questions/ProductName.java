package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;


public class ProductName implements Question<String> {

    public static ProductName value() {
        return new ProductName();
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getString("name");
    }
}