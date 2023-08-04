# Exercicio sobre utlização de BackgroundTasks

## Neste código
Foi re-implementada a classe ImageDownloader, que originalmente foi dada em Java. 
Após traduzir essa classe que permite fazer o download de uma imagem através de uma URL,
foi automaticamente necessária a implementação de uma Coroutine para que o código funcionasse, diferente do código Java que apresentaria
um erro para se verificar necessária a utilização de algum método assíncrono, em Kotlin o código já mostra a necessidade disso de forma sintática.

Esse exercício foi um estudo sobre Coroutines, uma forma nova de utilizar métodos assíncronos no Kotlin.

## Threads to Coroutine

### O que são Coroutines
As Coroutines fornecem uma maneira mais elegante e eficiente de lidar com as tarefas assíncronas em Kotlin.
Elas são um conceito de programação assíncrona mais leves que as Threads tradicionais.
Enquanto as Threads são unidades de execução do sistema operacional, as coroutines são gerenciadas pela biblioteca do próprio Kotlin.
Isso significa que as coroutines podem ser lançadas e executadas em threads existentes sem precisar criar uma nova thread separad para cada tarefa.

### Escopos
Coroutines são excutadas dentro de um escopo específico, que determina sua vida útil.
O escopo mais comum é o GlobalScope (Utilizado no código), que vive durante toda a vida do aplicativo.
No entanto, é recomendado criar escopos mais limitados, como o escopo da atividade ou fragmento, para que as coroutines sejam encerradas adequadamente quando não forem necessárias.

### Dispatchers
O **'Dispatche'** é responsável por determinar em qual thread a coroutine será executada.
O Kotlin offerece vários Dispatchers predefinidos, como **'Dispatchers.IO'** para tarefas de I/O assíncronas,
**'Dispatchers.Default'** para tarefas computacionais intensivas e **'Dispatchers.Main'** para a thread principal da UI, onde a atualização da UI deve ocorrer.

### Funções de Suspensão
As coroutines podem marcar funções com a palavra chave **'suspend'**. Essa funções de suspensão podem pausar sua execução sem bloquear a thread,
permitindo que outras coroutines sejam executadas. Isso torna mais fácil escrever código assíncrono de maneira sequencial e imperativa, como se fosse código síncrono.

### Lançamentos de Coroutines
Coroutines podem ser lançadas usando a função **'launch'** ou **'async'**
- A função **launch** é usada para coroutines que não retornam um resultado
- A função **async** é usada quando você espera um resultado. Ela retorna um objeto do tipo **Deferred**, que é semelhante a um **Future** em outras linguagens de programação, e é possível utilizar o método **await()** para obter o resultado quando estiver pronto.

### Tratamento de Exceções
É possível usar um bloco **try-catch** em torno do corpo de uma coroutine para lidar com exceções. Além disso, o **withContext()** serve para capturar exceções lançadas por outras coroutines.

### Exemplo comparativo
```
fun main() {
    GlobalScope.launch {
        // Coroutines começam a ser executadas aqui
        delay(1000) // Pausa a execução por 1 segundo sem bloquear a thread
        println("Hello")
    }

    println("World")
    Thread.sleep(2000) // Pausa a thread principal por 2 segundos para esperar a execução da coroutine
}
```