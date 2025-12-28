package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import questions.LastResponseStatus;
import questions.LastCreatedProductId;
import questions.ProductName;
import questions.ProductPrice;
import task.CreateProduct;
import task.GetProduct;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ProductApiSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new Cast());
        OnStage.theActorCalled("Usuario API")
                .whoCan(CallAnApi.at("http://localhost:8080"));
    }

    @Given("usuario crea un nuevo producto")
    public void usuarioCreaUnNuevoProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateProduct.withDefaultData()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(LastResponseStatus.value(), anyOf(is(200), is(201)))
        );
    }

    @When("consulta el producto creado por id")
    public void consultaElProductoCreadoPorId() {
        Integer productId = OnStage.theActorInTheSpotlight()
                .asksFor(LastCreatedProductId.value());

        OnStage.theActorInTheSpotlight().attemptsTo(
                GetProduct.byId(productId)
        );
    }

    @Then("la informacion del producto debe ser correcta")
    public void laInformacionDelProductoDebeSerCorrecta() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductName.value(), is("Laptop")),
                seeThat(ProductPrice.value(), is(1200))
        );
    }
}
