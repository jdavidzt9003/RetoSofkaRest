package co.com.sofka.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;



public class GetGenerationTask implements Task {

    private  String resource;

    public GetGenerationTask usingThe(String resource) {
        this.resource = resource;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(resource)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .header("header1","value1")
                        )
        );

    }
}
