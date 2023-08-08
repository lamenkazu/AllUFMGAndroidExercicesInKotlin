# RESTFul APIs
A comunicação REST no Android pode ser feita nativamente.
Para isso, é necessário:
- Estabelecer conexão com o servição
- Requisitar os dados necessários
- Fazer a conversão do dado recebido para um respectivo objeto

Uma alternativa seria **utilizar uma biblioteca de consumo de serviços REST**

# Retrofit
Retrofit é uma das bibliotecas mais utilizadas no universo android para facilitar a comunicação com Serviços REST.
Com ele é possível
- Mapear JSON para objetos
- Definir requisições por meio de interfaces

## Retrofit - Instalação
- É necessário implementar as dependencias de **com.squareup.retrofit2** retrofit e converter-gson
- É necessário adicionar a permissão de acesso à internet para o aplicativo no Android Manifest

## Retrofit - Configuração
Para trabalhar com o Retrofit é necessário
- Configurar o Serviço
- Configurar Interface
- Fazer chamada do Serviço

### Configurando o Serviço (RetrofitConfig)
A configuração do serviço define parâmetros gerais do funcionamento.
- Qual o endereço do serviço?
- Como o dado retornado será desempacotado?

Essa configuração é feita através da função Retrofit.Builder()

### Configurando a Interface (Service - GitHubAPIService)
No Retrofit, o acesso aos dados do serviço são feitos através de services.
Os Services são interfaces que possuem anotações indicando como a requisição deve ser feita no serviço.

### Chamada do Serviço (RestServicesActivity)
Para fazer a chamada ao retrofit é necessário
- Criar uma nova instância do serviço a ser chamada
- Fazer requisição ao serviço

Para isso, é necessario criar uma variavel service do tipo da interface que é igual a retrofit.create(), que deve ser retornada do RetrofitConfig.

Para fazer uma chamada assíncrona, utilizamos o enqueue(object: Callback<T>)
- onResponse = caso de sucesso na requisição
- onFailure = caso de erro na requisição
