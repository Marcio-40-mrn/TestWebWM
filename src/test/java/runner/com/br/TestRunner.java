package runner.com.br;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		plugin = {
					"pretty",
					"html:target/cucumber-index",
					"json:target/cucumber-report/cucumber.json"
				},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		glue = {""},
		tags = {"@Teste"}
		)
public class TestRunner {

}
