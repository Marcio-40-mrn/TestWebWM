$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("webMotor.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 3,
  "name": "Teste de Busca do Site WebMotors",
  "description": "Como usuario eu acesso o site WebMotors e \r\nbusco veiculo do meu interesse para comprar !",
  "id": "teste-de-busca-do-site-webmotors",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 2,
      "name": "@Teste"
    }
  ]
});
formatter.scenarioOutline({
  "line": 11,
  "name": "Realizar pesquisa pelo carro",
  "description": "",
  "id": "teste-de-busca-do-site-webmotors;realizar-pesquisa-pelo-carro",
  "type": "scenario_outline",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 10,
      "name": "@Esq1"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "navego no site seleciono ver ofertas",
  "keyword": "Quando "
});
formatter.step({
  "line": 13,
  "name": "na pagina resultado de busca, seleciono minha \u003clocalidade\u003e pesquiso \u003cmarca\u003e e \u003ccarro\u003e",
  "keyword": "E "
});
formatter.step({
  "line": 14,
  "name": "valido a busca, seleciono \u003cmodelo\u003e e valido,",
  "keyword": "E "
});
formatter.step({
  "line": 15,
  "name": "seleciono \u003cvendedor\u003e seleciono um veiculo",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "verifico e valido o estoque deste vendedor.",
  "keyword": "Então "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "teste-de-busca-do-site-webmotors;realizar-pesquisa-pelo-carro;",
  "rows": [
    {
      "cells": [
        "marca",
        "carro",
        "localidade",
        "modelo",
        "vendedor"
      ],
      "line": 19,
      "id": "teste-de-busca-do-site-webmotors;realizar-pesquisa-pelo-carro;;1"
    },
    {
      "comments": [
        {
          "line": 20,
          "value": "#| \"honda\"  | \"city\"  | \"São Paulo - SP\"      | \"1.5 LX 16V FLEX 4P AUTOMÁTICO\"         | \"Concessionária\" |"
        }
      ],
      "cells": [
        "\"toyota\"",
        "\"camry\"",
        "\"Rio de Janeiro - RJ\"",
        "\"3.5 XLE V6 24V GASOLINA 4P AUTOMÁTICO\"",
        "\"Loja\""
      ],
      "line": 21,
      "id": "teste-de-busca-do-site-webmotors;realizar-pesquisa-pelo-carro;;2"
    }
  ],
  "keyword": "Exemplos"
});
formatter.before({
  "duration": 9071396500,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "Acesso ao site",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 8,
  "name": "que acesso o site \"https://www.webmotors.com.br\"",
  "keyword": "Dado "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.webmotors.com.br",
      "offset": 19
    }
  ],
  "location": "ContextoSteps.queAcessoOSite(String)"
});
formatter.write(" Acessou o site https://www.webmotors.com.br realizado com sucesso");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 8550249300,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 20,
      "value": "#| \"honda\"  | \"city\"  | \"São Paulo - SP\"      | \"1.5 LX 16V FLEX 4P AUTOMÁTICO\"         | \"Concessionária\" |"
    }
  ],
  "line": 21,
  "name": "Realizar pesquisa pelo carro",
  "description": "",
  "id": "teste-de-busca-do-site-webmotors;realizar-pesquisa-pelo-carro;;2",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 2,
      "name": "@Teste"
    },
    {
      "line": 10,
      "name": "@Esq1"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "navego no site seleciono ver ofertas",
  "keyword": "Quando "
});
formatter.step({
  "line": 13,
  "name": "na pagina resultado de busca, seleciono minha \"Rio de Janeiro - RJ\" pesquiso \"toyota\" e \"camry\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "E "
});
formatter.step({
  "line": 14,
  "name": "valido a busca, seleciono \"3.5 XLE V6 24V GASOLINA 4P AUTOMÁTICO\" e valido,",
  "matchedColumns": [
    3
  ],
  "keyword": "E "
});
formatter.step({
  "line": 15,
  "name": "seleciono \"Loja\" seleciono um veiculo",
  "matchedColumns": [
    4
  ],
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "verifico e valido o estoque deste vendedor.",
  "keyword": "Então "
});
formatter.match({
  "location": "CenarioSteps.navegoNoSiteSelecionoVerOfertas()"
});
formatter.write("Pagina de busca acessado com sucesso");
formatter.embedding("image/png", "embedded1.png");
formatter.result({
  "duration": 5151494000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Rio de Janeiro - RJ",
      "offset": 47
    },
    {
      "val": "toyota",
      "offset": 78
    },
    {
      "val": "camry",
      "offset": 89
    }
  ],
  "location": "CenarioSteps.naPaginaResultadoDeBuscaSelecionoMinhaPesquisoE(String,String,String)"
});
formatter.result({
  "duration": 12462532500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3.5 XLE V6 24V GASOLINA 4P AUTOMÁTICO",
      "offset": 27
    }
  ],
  "location": "CenarioSteps.validoABuscaSelecionoEValido(String)"
});
formatter.write("Validado o item TOYOTA na barra status de pesquisa");
formatter.embedding("image/png", "embedded2.png");
formatter.write("Validado o item CAMRY na barra status de pesquisa");
formatter.embedding("image/png", "embedded3.png");
formatter.write("O Modelo 3.5 XLE V6 24V GASOLINA 4P AUTOMÁTICO foi selecionado");
formatter.embedding("image/png", "embedded4.png");
formatter.write("Validado o item 3.5 XLE V6 24V GASOLINA 4P AUTOMÁTICO na barra status de pesquisa");
formatter.embedding("image/png", "embedded5.png");
formatter.result({
  "duration": 12688154400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Loja",
      "offset": 11
    }
  ],
  "location": "CenarioSteps.selecionoSelecionoUmVeiculo(String)"
});
formatter.write("O box Loja foi selecionado");
formatter.embedding("image/png", "embedded6.png");
formatter.write("Veiculo escolhido com sucesso!");
formatter.embedding("image/png", "embedded7.png");
formatter.result({
  "duration": 19698605500,
  "status": "passed"
});
formatter.match({
  "location": "CenarioSteps.verificoEValidoOEstoqueDesteVendedor()"
});
formatter.write("Estoque da loja LUP CAR é de 16 veiculo(s)");
formatter.embedding("image/png", "embedded8.png");
formatter.result({
  "duration": 12697239300,
  "status": "passed"
});
formatter.after({
  "duration": 1097790500,
  "status": "passed"
});
});