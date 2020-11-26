package pages.com.br;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.Scenario;
import generics.com.br.Generics;
import hooks.com.br.Hooks;

public class ContextoPage {

	protected WebDriver driver;
	protected Generics generic;
	protected Scenario scenario;

	public ContextoPage() {
		driver = Hooks.getDriver();
		scenario = Hooks.getScenario();
		PageFactory.initElements(driver, this);
		generic = new Generics(driver, scenario);

	}

	public void AcessaSistema(String url) {
		driver.get(url);

	}
}
