package actors;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ApiActor {

    public static Actor usuario() {
        Actor actor = Actor.named("Usuario");
        actor.can(CallAnApi.at("https://automationexercise.com/api"));
        return actor;
    }
}