package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ResponseCode implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return LastResponse.received()
                .answeredBy(actor)
                .jsonPath()
                .getInt("responseCode");
    }

    public static ResponseCode value() {
        return new ResponseCode();
    }
}

