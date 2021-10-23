package co.com.sofka.questions;

import co.com.sofka.model.GetGenerationModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetGenerationQuestion implements Question {


    @Override
    public GetGenerationModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(GetGenerationModel.class);
    }
}
