# Intents
- Uma intenção é uma mensagem enviada que solicita alguma ação. 
- Quando quiser enviar uma intenção ao S.O, use uma Intent, um objeto que porta a mensagem.
- Há diferentes formas de montar a mensagem através da classe Intent.
- Há duas formas diferentes de Intents, as Nativas e Customizadas.
- Uma intent é apenas uma mensagem, então para enviá-la, é utilizado o método **startActivity()** 

# Intents Nativas
Através de Intents Nativas, é possível utilizar os comportamentos predefinidos que o sistema Android oferece. 
Ações do android estão ENUMeradas na classe Intent, então é possível identifica-las através de: Intent.ACTION_"something" 

É possível chamar uma Intent com a ação explicitamente ou montar uma Intent através do apply, onde devemos setar seus parâmetros.
Ambas as formas foram explodaras no exercício **IntentsNativasActivity.kt**

# Intents Customizadas
Através de Intents Customizzadas, o desenvolvedor pode criar ou usar Intents criadas por outros desenvolvedores.
Dessa forma é possível fazer o seu aplicativo iniciar outros aplicativos que não tenham sido desenvolvidos pra você.
Para isso é necessario ter a Action desse aplicativo, que costuma ser o AppID, como todos os apps androids devem ter
o AppId desse aplicativo é: com.daedrii.allufmgandroidexercicesinkotlin"
Então é necessário encontrar o ID dos apps em que se quer abrir.

# Implict Extra Infos

## startActivityForResult to registerForActivityResult
Para iniciar uma intenção nativa para outra aplicação do sistema,
é necessario registrar a ação que será recebida. Para isso é necessário criar uma variável
registerForActivityResult com um Contract que inicia uma ActivityForResult¹ e então chamar o 
Launch para realizar a ação²

## Extras
Definir a ação, o tipo e os conteúdos extras a serem inseridos é feito no Kotlin através do apply na Intent.

## URI
Uri.parse é feito da mesma forma que no Java, já que é um método do java.