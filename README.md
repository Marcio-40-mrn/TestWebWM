# CONFIGURAÇÃO TestWebWM
#
## FERRAMENTAS NECESSÁRIAS

•	JAVA

•	ECLIPSE




#
## CONFIGURAÇÕES

### Variáveis de Ambiente do Sistema

•	JAVA_HOME: C:\Program Files\Java\jdk1.8.0_201

•	path: C:\Program Files\Java\jdk1.8.0_201\bin

### No Eclipse criar um projeto Maven com as dependências:

•	selenium-java 3.141.59,

•	cucumber-java 1.2.4,

•	cucumber-core 1.2.4,

•	cucumber-junit 1.2.4,

•	junit 4.12



#
## ESTRUTURA E ESPECIFICAÇÕES

### Steps criados apartir de Cucumber feature no pacote

• src/test/java/steps.com.br

### Pagina inspecionada e page objects instanciados no pacote

• src/test/java/pages.com.br

### Metodos implementados para busca de objetos e execução do teste no pacote

• src/test/java/generics.com.br



#
## TESTE

### Especificar dados do produto a pesquisar na Cucumber.feature:

•	src/test/resources/features/webMotor.feature

### Executar teste no eclipse a partir do Runner:

•	src/test/java/runner.com.br/TestRunner.java

### Evidências em :

•	target/cucumber-index/index.html
