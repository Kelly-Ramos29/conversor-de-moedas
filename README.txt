# Conversor de Moedas - Java (com API e GSON)

### Requisitos:
- Java JDK instalado
- Conexão com a internet (para buscar dados da API)
- Biblioteca `gson-2.10.1.jar` incluída na pasta `lib`

### Como compilar:

Abra o terminal na pasta do projeto e execute:

$arquivos = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -cp ".\lib\gson-2.10.1.jar" -d out $arquivos

### Como executar:

java -cp "out;lib/gson-2.10.1.jar" ConversorDeMoedas.Main

### Observações:
- A API utilizada é gratuita e pública (https://www.exchangerate-api.com/)
- O conversor cobre as moedas: USD, BRL e EUR