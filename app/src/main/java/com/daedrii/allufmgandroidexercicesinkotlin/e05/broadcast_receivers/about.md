# Broadcast Receiver - Receptor de transmissões
É o método que os desenvolvedores têm para interceptar as mensagens **transmitidas** pelo sistema.
A partir do momento que é implementado, ele age como um observador de eventos,
permitindo que o aplicativo responda a alterações ou eventos específicos que acontecem no dispositivo.

## Exemplo apresentado
No exemplo apresentado, o Theme do aplicaivo é alterado para o DarkMode assim que a bateria do dispositivo é <= 20
Em Kotlin, isso é possível de implementar muito facilmente com a classe **AppCompatDelegate**, que delega comportamentos do sistema de forma simples,
diferente do java que precisa de perações intermediárias, como interromper a Activity atual e inicia-la novamente.

## Transmissões personalizadas
Além das transmissões do sistema, também é possível criar as próprias transmissões personalziadas para que outros componentes do aplicativo,
ou até mesmo aplicativos externos possam interagir com o meu aplicativo.

## Em Resumo
Um BroadcastReceiver é uma parte fundamental do desenvolvimento Android para receber e responder a eventos ou transmissões que ocorrem no 
dispositivo, permitindo que você tome ações apropriadas em resposta a esses eventos.