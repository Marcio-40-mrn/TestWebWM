package generics.com.br;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class Generics {

	private WebDriver driver;
	private Scenario scenario;

	public Generics(WebDriver driver, Scenario scenario) {
		this.scenario = scenario;
		this.driver = driver;
	}

	public void jsClickNoLink(WebElement elemento) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].click();", elemento);
		} catch (Exception e) {
			escreveRelatorio(false, "Erro inesperado elemento " + elemento + " não encontrado", true);
		}

	}
	
	public void jsFechaScript() {
		driver.switchTo().alert().dismiss();
	}
	
	public void jsClick(WebElement elemento) throws InterruptedException {
		jsScrollElemento(elemento);
		aguardaElemento(elemento, 10);
		Thread.sleep(1000);
		try {			
			elemento.click();
		} catch (Exception e) {
			escreveRelatorio(false, "Erro inesperado ao efetuar o click", true);
		}

	}

	public void jsScrollElemento(WebElement elemento) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			js.executeScript("arguments[0].scrollIntoView(true);", elemento);
		} catch (Exception e) {
			escreveRelatorio(false, "Erro inesperado elemento " + elemento + " não encontrado", true);
		}

	}

	public void mudarAba(int indice) {
		List<String> abas = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(indice));

	}

	public void aguardaElemento(WebElement elemento, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);

			if (wait.until(ExpectedConditions.visibilityOfAllElements(elemento)) == null) {
				escreveRelatorio(false, "Elemento " + elemento + " nÃo carregou", true);
			}
		} catch (Exception e) {
			escreveRelatorio(false, "Erro inesperado elemento " + elemento + " nÃo carregou", true);
		}

	}

	public void escreveRelatorio(boolean status, String msg, boolean printScreen) {
		scenario.write(msg);

		if (printScreen) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}

		if (status == false) {
			Assert.fail();
		}
	}

	public void click(WebElement elemento) {
		aguardaElemento(elemento, 20);

		try {			
			elemento.click();
		} catch (Exception e) {
			escreveRelatorio(false, "Erro inesperado ao efetuar o click", true);
		}

	}

	public boolean aguardaElementoVisivel(WebElement elemento, int timeOut) {

		boolean flag = true;

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);

			if (wait.until(ExpectedConditions.visibilityOfAllElements(elemento)) == null) {
				flag = false;
			}

			return flag;

		} catch (Exception e) {
			escreveRelatorio(false, "Erro inesperado elemento " + elemento + " nÃo carregou", true);
			return false;
		}

	}

	public void preecheCampo(WebElement campo, String texto) {
		try {
			campo.sendKeys(texto);

		} catch (Exception e) {
			escreveRelatorio(false, "Erro inexperado nÃo foi possivel preencher " + campo + " com o valor " + texto,
					true);
		}

	}

	public void selecionaComboBox(WebElement comboBox, String texto) throws InterruptedException {

		try {

			comboBox.click();
			Thread.sleep(1000);
			new Select(comboBox).selectByVisibleText(texto);

		} catch (Exception e) {
			escreveRelatorio(false, "Erro inexperado nÃo foi possivel preencher " + comboBox + " com o valor ", true);
		}
	}

	public void validacaoMsg(WebElement elemento, String msg) {
		aguardaElemento(elemento, 20);
		try {
			String texto = elemento.getText();
			if (texto.equals(msg)) {
				escreveRelatorio(true, "Mensagem Enviada com Sucesso", true);
			} else {
				escreveRelatorio(false, "Texto atual diferente do Esperado", true);
			}

		} catch (Exception e) {
			escreveRelatorio(false, "Não Foi possivel obter o texto", true);
		}
	}

	public void selecionaVeiculo(WebElement elemento1, WebElement elemento2) {
		
		aguardaElementoVisivel(elemento1, 10);

		int numeroVeiculos = Integer.parseInt(elemento1.getAttribute("innerText"));

		if (numeroVeiculos > 0) {
			click(elemento2);
		} else {
			escreveRelatorio(false, "A busca não retornou resultados", true);
		}

		escreveRelatorio(true, "Veiculo escolhido com sucesso!", true);
	}

	public void localizaValorTabela(WebElement lista, String item) {

		boolean flag = false;
		int linhas = lista.findElements(By.tagName("div")).size();

		for (int i = 0; i < linhas; i++) {
			WebElement objLinha = lista.findElements(By.tagName("div")).get(i);
			if (objLinha.getText().equals(item)) {
				flag = true;
				break;
			}
		}

		if (flag == false) {
			Assert.fail();
		}
	}

	public void validaItem(WebElement elemento, String texto) throws InterruptedException {
		aguardaElementoVisivel(elemento, 5);
		boolean flag = false;
		texto = texto.toUpperCase();
		List<WebElement> itens = elemento.findElements(By.xpath("//*[@class='FilterResult__container__list__item']"));
		for (WebElement item : itens) {
			String descricao = item.getText();
			if (descricao.contains(texto)) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			escreveRelatorio(true, "Validado o item " + texto + " na barra status de pesquisa", true);
		} else {
			escreveRelatorio(false,
					"Validação falhou o item " + texto + " não foi localizado na barra status de pesquisa  ", true);
		}
	}

	public void localizaModelo(WebElement elemento, String produto) throws InterruptedException {
		boolean flag = false;
		List<WebElement> itens = elemento.findElements(By.xpath("//a[@class='Filters__line Filters__line__result']"));
		for (WebElement item : itens) {
			String descricao = item.getText();
			if (descricao.contains(produto)) {
				click(item);
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			escreveRelatorio(true, "O Modelo " + produto + " foi selecionado", true);
		} else {
			escreveRelatorio(false, "O Modelo " + produto + " não foi selecionado", true);
		}
	}

	public void localizaVendedor(WebElement elemento, String produto) throws InterruptedException {
		boolean flag = false;
		List<WebElement> itens = elemento.findElements(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/div[5]/div"));
		for (WebElement item : itens) {
			String descricao = item.getText();
			if (descricao.contains(produto)) {
				click(item);
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			escreveRelatorio(true, "O box " + produto + " foi selecionado", true);
		} else {
			escreveRelatorio(false, "O box" + produto + " não foi localizado", true);
		}
	}

	public void carroDaBusca(WebElement elemento, String produto) throws InterruptedException {
		boolean flag = false;
		List<WebElement> itens = elemento.findElements(
				By.xpath("//div[@class='ContainerCardVehicle ads_align ']//a[@rel='noreferrer nofollow'][1]"));
		for (WebElement item : itens) {
			String descricao = item.getAttribute("href");
			if (descricao.contains(produto)) {
				click(item);
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			escreveRelatorio(true, "O Carro " + produto + " foi selecionado", true);
		} else {
			escreveRelatorio(false, "O Carro" + produto + " não foi localizado", true);
		}
	}

	public void buscaEstoque(WebElement elemento, String loja) {
		String msg = elemento.getText();
		if (msg == null) {
			escreveRelatorio(false, "Quantidade de Veiculos não Localizado", true);
		} else {
			escreveRelatorio(true, "Estoque da loja "+ loja + " é de " + msg + " veiculo(s)", true);
		}
	}
	
	public String buscaLoja(WebElement elemento) {
		aguardaElemento(elemento, 5);
		String loja = null;
		try {
			loja = elemento.getText();
		}
		catch (Exception e){
			escreveRelatorio(false, "Não foi possivel localizar o nome da loja na barra status da pesquisa", true);		
		}
		return loja;
	}
}
