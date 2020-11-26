#language: pt
@Teste
Funcionalidade: Teste de Busca do Site WebMotors
  Como usuario eu acesso o site WebMotors e 
  busco veiculo do meu interesse para comprar !

  Contexto: Acesso ao site
    Dado que acesso o site "https://www.webmotors.com.br"

  @Esq1
  Esquema do Cenario: Realizar pesquisa pelo carro
    Quando navego no site seleciono ver ofertas
    E na pagina resultado de busca, seleciono minha <localidade> pesquiso <marca> e <carro>
    E valido a busca, seleciono <modelo> e valido,
    E seleciono <vendedor> seleciono um veiculo
    Então verifico e valido o estoque deste vendedor.

    Exemplos: 
      | marca    | carro   | localidade            | modelo                                  | vendedor         |
      | "honda"  | "city"  | "São Paulo - SP"      | "1.5 LX 16V FLEX 4P AUTOMÁTICO"         | "Concessionária" |
      | "toyota" | "camry" | "Rio de Janeiro - RJ" | "3.5 XLE V6 24V GASOLINA 4P AUTOMÁTICO" | "Loja"           |
