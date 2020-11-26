package steps.com.br;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.com.br.CenarioPage;

public class CenarioSteps extends CenarioPage{
	
	
	
	@Quando("^navego no site seleciono ver ofertas$")
	public void navegoNoSiteSelecionoVerOfertas() throws Throwable {	
		Pesquisa();	
	}
	
	@E("^na pagina resultado de busca, seleciono minha \"([^\"]*)\" pesquiso \"([^\"]*)\" e \"([^\"]*)\"$")
	public void naPaginaResultadoDeBuscaSelecionoMinhaPesquisoE(String local, String marca, String carro) throws Throwable {
	    LocalizacaoEBusca(local, marca, carro);
	}

	@E("^valido a busca, seleciono \"([^\"]*)\" e valido,$")
	public void validoABuscaSelecionoEValido(String versao) throws Throwable {
	    ValidaPesquisa(versao);
	}
	
	@E("^seleciono \"([^\"]*)\" seleciono um veiculo$")
	public void selecionoSelecionoUmVeiculo(String vendedor) throws Throwable {
	    SelecionaVendedor(vendedor);
	}

	@Então("^verifico e valido o estoque deste vendedor\\.$")
	public void verificoEValidoOEstoqueDesteVendedor() throws Throwable {
		MostraLojaEstoque();
	}

	

}
