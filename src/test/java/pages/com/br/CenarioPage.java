package pages.com.br;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import generics.com.br.Generics;
import hooks.com.br.Hooks;

public class CenarioPage {

	protected WebDriver driver;
	protected Generics generic;
	protected Scenario scenario;

	public CenarioPage() {
		driver = Hooks.getDriver();
		scenario = Hooks.getScenario();
		PageFactory.initElements(driver, this);
		generic = new Generics(driver, scenario);

	}
		
	@FindBy(xpath="//a[@class='Button Button--red-home']")
	public WebElement botaoBusca;
	
	@FindBy(id="locationAutoComplete")
	public WebElement localidade;
	
	@FindBy(className="AutoComplete-result-name")
	public WebElement autoComplet;
		
	@FindBy(xpath="//div[@class='Filters__line Filters__line--gray Filters__line--icon Filters__line--icon--right']")
	public WebElement carroLocalizado;
			
	@FindBy(xpath="//div[@class='Filters__line Filters__line--icon Filters__line--icon Filters__line--icon--right Filters__line--gray']")
	public WebElement tipos;
	
	@FindBy(xpath="//div[@class='Filters__container__group Filters__container__group--no-border'][2]")
	public WebElement listaTipos;
	
	@FindBy(xpath="/html/body/div[1]/main/div[1]/div[3]/div[1]/p/strong")
	public WebElement estoque;
	
	@FindBy(xpath="//*[@id='root']/main/div[1]/div[2]/div/div[5]")
	public WebElement vendedores;
	
	@FindBy(xpath="//a[@id='VehicleSellerInformationStock']")
	public WebElement veiculosVendedor;	
	
	@FindBy(className="ContainerCardVehicle ads_align ")
	public WebElement conteudoBusca;
	
	@FindBy(xpath="//img[@class='--close-modal']")
	public WebElement fechaPopup;
	
	@FindBy(xpath="//div[@class='VehicleDetails__header']")
	public WebElement detalheCarro;
	
	@FindBy(xpath="//div[@class='VehicleDetails__container']")
	public WebElement detalhesCarro;
	
	@FindBy(id="searchBar")
	public WebElement campoBusca;
	
	@FindBy(className="SearchBar__results__result__name")
	public WebElement busca;
	
	@FindBy(id="FilterResultContainer")
	public WebElement resultadoBusca;
	
	@FindBy(xpath="//strong[@class='sc-hzDkRC gcWVAm']")
	public WebElement veicPesquisa;
	
	@FindBy(xpath="//div[@class='ContainerCardVehicle ads_align ']//a[@rel='noreferrer nofollow'][1]")
	public WebElement primeiroDaBusca;
	
	@FindBy(xpath="//li[@class='FilterResult__container__list'][1]")
	public WebElement retornaLoja;
	
	String marca;
	String carro;
				
	public void SelecionaVendedor(String vendedor) throws InterruptedException {
		generic.localizaVendedor(vendedores, vendedor);
		Thread.sleep(5000);		
		generic.selecionaVeiculo(veicPesquisa, primeiroDaBusca);
		Thread.sleep(7000);
	}
	
	public void MostraLojaEstoque() throws InterruptedException {
		generic.mudarAba(1);			
		generic.aguardaElementoVisivel(fechaPopup, 10);
		Thread.sleep(5000);
		generic.click(fechaPopup);
		generic.jsClickNoLink(veiculosVendedor);
		Thread.sleep(4000);
		generic.aguardaElementoVisivel(estoque, 10);
		generic.buscaEstoque(estoque, generic.buscaLoja(retornaLoja));
	}

	
		
	public void Pesquisa() throws InterruptedException {
		generic.aguardaElemento(botaoBusca, 15);
		generic.click(botaoBusca);
		Thread.sleep(3000);
		generic.escreveRelatorio(true, "Pagina de busca acessado com sucesso", true);
		
	}
	
	public void LocalizacaoEBusca(String local, String marca, String carro) throws InterruptedException {
		this.marca = marca;
		this.carro = carro;
		String pesquisa = marca + " " + carro;
		generic.aguardaElemento(localidade, 10);
		generic.preecheCampo(localidade, local);
		Thread.sleep(2000);
		generic.aguardaElementoVisivel(autoComplet, 10);
		generic.click(autoComplet);
		Thread.sleep(2000);
		generic.aguardaElementoVisivel(campoBusca, 10);
		generic.click(campoBusca);
		generic.preecheCampo(campoBusca, pesquisa);
		Thread.sleep(2000);
		generic.aguardaElementoVisivel(busca, 10);
		generic.click(busca);
		
	}
	
	public void ValidaPesquisa(String modelo) throws InterruptedException {
		Thread.sleep(2000);
		generic.validaItem(resultadoBusca, marca.toUpperCase());
		generic.validaItem(resultadoBusca, carro.toUpperCase());
		generic.jsClick(tipos);
		generic.localizaModelo(listaTipos, modelo);
		generic.validaItem(resultadoBusca, modelo.toUpperCase());		
	}
	
}
