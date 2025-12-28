package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LastCreatedProductId implements Question<Integer> {

    public static LastCreatedProductId value() {
        return new LastCreatedProductId();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getInt("id");
    }
}