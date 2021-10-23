package co.com.sofka.runner.pokeapi;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        glue = "co.com.sofka.stepdefinition",
        features = "src/test/resources/features/Generation.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class GenerationWithCucumberTest {
}
