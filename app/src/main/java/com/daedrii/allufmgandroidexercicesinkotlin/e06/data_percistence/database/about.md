# Gravando Informações do Usuário no Banco de Dados
Foi implementado uma tela no app que faz o armazenamento de produtos.
Essa tela contém o formulário com dois campos:
- nome do protudo
- preço do produto

Foi implementada uma classe chamada ProductDAO
responsável pelo armazenamento e leitura dos produtos cadastrados.
- A classe possui o método insert(produto: Product) que faz a inserçao do produto
- Há também um método getAll(): List<Product>, que retorna todos os produtos cadastados.

# Android e SQLite
O Android possui suporte nativo ao SQLite através do SQLiteOpenHelper
Também é possível criar um anco de dados manualmente, importanto banco de dados ja pronto.

# SQLiteOpenHelper
É uma classe abstrata responsável por gerenciar o banco de dados do aplicativo.
O desenvolvedor herda a classe SQLiteOpenHelper e implementa as funções necessárias para a comunicação com o banco de dados.
O Android cuida do resto.


