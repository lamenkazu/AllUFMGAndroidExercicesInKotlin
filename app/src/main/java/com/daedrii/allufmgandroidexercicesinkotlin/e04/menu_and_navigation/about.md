# Exercício sobre utilização da ActionBar.

## Fluxo de Telas
- Através de um botão da MainActivity a SecondActivity é aberta.
- A SecondActivity por sua vez exibe um ActionBar com um UpNavigation que o retorna para a tela anterior.
- Ela também tem um botão para a terceira tela.
- Na terceira tela também há um UpNavigation que retorna direto para a Main, sem passar pela Second.
- Há um Menu De Opções na SecondActivity

## UpNavigation
- Para criar um Tema com Action Bar sem comprometer o Tema principal do projeto, foi criado um Style chamdo
AppThemeWithActionBar no styles.xml, ele é adicionado no AndroidManifest em todas as Activitys que precisarem de uma ActionBar.
- Para confirmar que o UpNavigation não é um botão de BackButton, você define um Pai para as Activity's de modo que mesmo da Terceira você volte para a Main. 
para isso, é definido no AndroidManifest qual é o Pai da Activity.

## Adicionando Ações na ActionBar
Foi adicionado à ActionBar tela SecondActivity as seguintes ações:
- Atualizar (Sempre visível)
- Buscar (Sempre visível)
- Compartilhar (Visível se houver espaço)
- Configurações (Nunca visível)
- About (Nunca visível)
- Sair (Nunca visível)

Essas ações são definidas em um Menu .xml que é associado à Activity dentro do código da própria Activity
Os botões de buscar e atualizar são representados por ícones para melhor identificação das ações pelo usuário.

Estes comportamentos foram implementados na ActionBar (onOptionsItemSelected):
- Atualizar: Mostra Toast na tela
- About: Mostra Dialog com informações do aplicativo e Desenvolvedor
- Sair: Mostra Dialog que oferece Sair do Aplicativo ou Permanecer (Positive & Negative Button)

Implementação necessaria no XML do Menu (Além de implementação necessária no Create do Menu):
- Find: Implementa SearchView que pesquisa texto enviado ou alterado durante a escrita. 
- Compartihar: Implementa Share Provider de um txt com uma intent que será exibida pelo provider.