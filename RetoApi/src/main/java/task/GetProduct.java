package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetProduct   implements  Task {

    private final Integer productId;

    public GetProduct(Integer productId) {
        this.productId = productId;
    }

    public static GetProduct byId(Integer productId) {
        return instrumented(GetProduct.class, productId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/products/" + productId)
        );
    }
}