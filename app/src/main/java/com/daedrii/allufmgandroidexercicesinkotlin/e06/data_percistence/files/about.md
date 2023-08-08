# Persistência em Arquivos

# Shared Preferences
- Uma classe que proporciona armazenamento de dados simples
- OS dados são armazenados por meio de tuplas chave-valor, similar a uma HashTable
- Permite manipular apenas dados primitivos
- Salva os dados num Arquivo XML

Nesse exercício, foi utilizado o Shared Preferences para armazenar a data/hora referente ao último acesso do usuário no aplicativo.
Foi adicionado um registro na inicialização do aplicativo para armazenar e exibir a data/hora do último acesso.
- Toda vez que o usuário abrir o aplicativo, um Toast deverá ser exibido informando a data e hora do último acesso no formado dd/mm/yyyy - HH:MM
- No primeiro acesso o aplicativo deverá apenas registrar a data e hora do acesso.


# Arquivos
No exemplo dessa aplicação, foi implementado uma Intenção de tirar uma foto, na qual, após tirada a foto, é armazenada no aplicativo.
É possível, após esse armazenamento não persistente, salvar essa imagem tanto no armazenamento interno quanto no externo, através de 2 botões diferentes.
Tudo que muda para realizar esse armazenmento é definir o path do arquivo.

Tanto para **ler** quanto para **escrever** arquivos na memória externa, é necessário dar essa permição para o aplicativo no Android Manifest.
Essa permissão não é necessária para o armazenamento interno.

Salvar Arquivos é um método basico do Java, que foi implementado nesse código em Kotlin, então não há funcionalidades especiais do Android,
se trata apenas de um recurso da linguagem.