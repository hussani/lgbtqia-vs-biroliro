# LGBTQIA+ vs Biroliro

> Exercício-Programa 2 da disciplina MAC5710
> 
> Hussani Silva de Oliveira - NUSP 12578741


A solução consiste em calcular o caminho mínimo utilizando o algoritmo de Dijkstra para
cada um dos membros da comunidade LGBTQIA+ e Biroliro.
As cidades seguras são as que o caminho mínimo máximo de todos os membros da comunidade
é menor que o caminho mínimo para Biroliro.

Para representar o grafo foi utilizada uma lista de adjacência. A implementação
do algoritmo de Dijkstra utiliza uma fila de prioridade. Este algoritmo pode ser
otimizado com o uso de Fibonacci Heap, porém não foi implementado.

## Instruções para compilar e executar

#### Requisitos
- [Maven](http://maven.apache.org/)
- JDK 11+

#### Executando como programa Java

Compile o projeto
```shell
mvn clean compile
```

Execute o projeto
```shell
java -classpath target/classes com.hussani.lgbtqia.App <caminho para um arquivo de entrada>
```

É possível utilizar a flag `-v` para ver estatísticas de tempo de execução do programa.

Exemplo 
```shell
java -classpath target/classes com.hussani.lgbtqia.App ~/Downloads/Entrada6.txt -v
```

#### Executando como pacote JAR

Gere o pacote
```shell
mvn clean package
```

Exececute o pacote
```shell
java -jar target/lgbtqia-pride-1.0-SNAPSHOT.jar <caminho para um arquivo de entrada>
```

