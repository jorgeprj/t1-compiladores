# T1 Compiladores

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

### Integrantes

- Jorge Pires (790942)
- Giullio Gerolamo (790965)

## Analisador Léxico para Linguagem Algorítmica (LA)
Este é o trabalho 1 (T1) da disciplina, que consiste na implementação de um analisador léxico para a linguagem LA 
(Linguagem Algorítmica) desenvolvida pelo professor Jander, no âmbito do DC/UFSCar. O analisador léxico lê um 
programa-fonte e produz uma lista de tokens identificados.

### Funcionamento
O analisador léxico deve ser capaz de identificar os tokens da linguagem LA no programa-fonte fornecido como entrada.
Os tokens são palavras-chave, identificadores, literais, símbolos especiais, etc. O analisador deve ignorar espaços 
em branco e comentários.

Em caso de erro léxico, o programa deve interromper a execução e reportar o erro, indicando o primeiro símbolo onde 
o erro ocorre. Os erros a serem reportados incluem símbolos não identificados, comentários não fechados na mesma 
linha e cadeias não fechadas na mesma linha.

## Pré Requisitos
Antes de compilar e executar o analisador léxico, verifique se o seguinte software está instalado em seu sistema:

- Java 11 ou superior
- Apache Maven 3.6.3 ou superior


## Como executar o Analisador Léxico
### Compilação com Maven
Siga estas etapas para compilar o analisador léxico usando Maven:

1. Abra um terminal ou prompt de comando.
2. Navegue até o diretório raiz do projeto onde está localizado o arquivo pom.xml.
3. Execute o seguinte comando para limpar o projeto e compilar os arquivos fonte:
    ```
    mvn clean compile 
    ```
   Este comando irá limpar os arquivos compilados antigos e compilar os novos.

### Empacotamento do Projeto
Após a compilação com sucesso, você pode empacotar o projeto usando o seguinte comando Maven:
```
mvn package
```
Este comando irá gerar um arquivo JAR executável no diretório target, com todas as dependências incluídas.

### Execução do Analisador Léxico
Após empacotar o projeto, você pode executar o analisador léxico para um par de entrada e saída arbitrário. Use o 
seguinte comando:
    
```
java -jar target/lalex-1.0-SNAPSHOT-jar-with-dependencies.jar caminho_entrada caminho_saida
```
    
- ``caminho_entrada``: Caminho completo do arquivo contendo o programa-fonte em linguagem LA.

- ``caminho_saída``: Caminho completo do arquivo onde a saída será salva.


Substitua ``target/lalex-1.0-SNAPSHOT-jar-with-dependencies.jar`` pelo caminho correto do arquivo JAR gerado pelo Maven.