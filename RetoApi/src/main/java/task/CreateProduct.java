package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateProduct implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String requestBody = "{\n" +
                "  \"name\": \"Laptop\",\n" +
                "  \"price\": 1200\n" +
                "}";

        // Forma correcta de usar Post con lambda en Serenity Screenplay REST
        actor.attemptsTo(
                new net.serenitybdd.screenplay.Performable[]{Post.to("/products")
                        .with(request -> request
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                )});
    }

    // Método factory para usar en Steps
    public static CreateProduct withDefaultData() {
        return instrumented(CreateProduct.class);
    }
}
