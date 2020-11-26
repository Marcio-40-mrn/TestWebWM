package steps.com.br;

import cucumber.api.java.pt.Dado;
import pages.com.br.ContextoPage;

public class ContextoSteps extends ContextoPage{
	
	@Dado("^que acesso o site \"([^\"]*)\"$")
	public void queAcessoOSite(String site) throws Throwable {
		AcessaSistema(site);
		Thread.sleep(3000);
		generic.escreveRelatorio(true, " Acessou o site " + site + " realizado com sucesso", true);
	}

}
