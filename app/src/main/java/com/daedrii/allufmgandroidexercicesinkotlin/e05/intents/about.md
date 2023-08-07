# Intents Nativas
## startActivityForResult to registerForActivityResult
Para iniciar uma intenção nativa para outra aplicação do sistema,
é necessario registrar a ação que será recebida. Para isso é necessário criar uma variável
registerForActivityResult com um Contract que inicia uma ActivityForResult¹ e então chamar o Launch para realizar a ação²

## Extras
Definir a ação, o tipo e os conteúdos extras a serem inseridos é feito no Kotlin através do apply na Intent.

## URI
Uri.parse é feito da mesma forma que no Java, já que é um método do java.

# Intents Customizadas