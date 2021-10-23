package co.com.sofka.stepdefinition;

import co.com.sofka.model.Result;
import co.com.sofka.questions.GetGenerationQuestion;
import co.com.sofka.questions.ResponseCodeQuestion;
import co.com.sofka.task.GetGenerationTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;


public class GenerationStepDefinition {

    private static final String REST_URL = "https://pokeapi.co/api/v2";
    private static final String REST_RESOURCE = "/generation";
    private static String NAME = "generation-i";
    private static String URL_NAME = "https://pokeapi.co/api/v2/generation/1/";
    private static Integer INDEX = 0;

    Actor actor = Actor.named("Tester");

    @Given("que el automatizador hace un peticion get")
    public void queElAutomatizadorHaceUnPeticionGet() {

        actor.whoCan(CallAnApi.at(REST_URL));
    }

    @When("la api hace el llamado del servicio")
    public void laApiHaceElLlamadoDelServicio() {
        actor.attemptsTo(
                new GetGenerationTask()
                        .usingThe(REST_RESOURCE)
        );
    }

    @Then("ela respuesta es exitosa ok")
    public void elaRespuestaEsExitosaOk() {
        actor.should(
                seeThat("El codigo de respuesta", ResponseCodeQuestion.was(), equalTo(SC_OK))
        );
    }

    @When("se hace la petición get")
    public void seHaceLaPeticiónGet() {
        actor.attemptsTo(
                new GetGenerationTask()
                        .usingThe(REST_RESOURCE)
        );
    }

    @Then("arroja el nombre y url de resultado")
    public void arrojaElNombreYUrlDeResultado() {
        Result res = new GetGenerationQuestion().answeredBy(actor).getResults().get(INDEX);
                //.stream().filter(x -> x.getName() == NAME).findFirst().orElse(null);
        System.out.println(res);

        actor.should(
                seeThat("Name no es nulo", a -> res, notNullValue())
        );

        actor.should(
                seeThat("El nombre es", act -> res.getName(), equalTo(NAME)),
                seeThat("La URL es", act -> res.getUrl(), equalTo(URL_NAME))
        );
    }

}
