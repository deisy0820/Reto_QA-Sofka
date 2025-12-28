package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ProductPrice implements Question<Integer> {

    public static ProductPrice value() {
        return new ProductPrice();
    }

    @Override
    public Integer answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getInt("price");
    }
}