# Amor Doce

    Projeto JavaFx - IFRS Campus Canoas 2022/1

- [Amor Doce](#amor-doce)
  - [Diretórios](#diretórios)
  - [Time de desenvolvimento](#time-de-desenvolvimento)
  - [Regras de Commit](#regras-de-commit)
    - [Types Permitidos](#types-permitidos)
    - [Referenciando uma Issue ao commit](#referenciando-uma-issue-ao-commit)
    - [Fechando Issues](#fechando-issues)
  - [Criando um fork (Bifurcação) do repositório para a sua conta](#criando-um-fork-bifurcação-do-repositório-para-a-sua-conta)
    - [Clonando o repositório](#clonando-o-repositório)
    - [Configurar o Git para sincronizar o fork (bifurcação) com o repositório original](#configurar-o-git-para-sincronizar-o-fork-bifurcação-com-o-repositório-original)
  - [Configurando o projeto no NetBeans](#configurando-o-projeto-no-netbeans)

## Diretórios

``src/amordoce`` - Diretório principal: telas, controladores, modelos, handlers e App.java

``src/assets`` - Diretório de recursos: imagens, áudios, vídeos, etc.

``src/css`` - Diretório de estilos CSS

## Time de desenvolvimento

- [Filipe Siota](https://github.com/FilipeSiota)
- [Gabriela Estigarribia](https://github.com/estigarribia08)
- [Giovani Signori](https://github.com/GioPach)

## Regras de Commit

Se possível (e quando necessário), o commit deve manter um corpo estrutural padronizado. Utilizaremos o padrão utilizado em alguns projetos do Google (simplificado)

``TYPE(TARGET): DESCRIPTION``

O ``TARGET`` é o alvo de modificações do commit, podendo ser um arquivo, ou um módulo da aplicação. E a ``DESCRIPTION`` é uma descrição breve do que foi feito no commit.

### Types Permitidos

- FEAT: Commits com adição de funcionalidade (Seja ela pronta ou em progresso);
- FIX: Um bugfix. Se houver uma Issue relacionada, deve-se fechá-la;
- REFACT: Algumas melhorias de código (Sejam elas de performance, de limpeza, ou de documentação);

### Referenciando uma Issue ao commit

Para referenciar um commit a uma determinada Issue cadastrada aqui no Github, o commit deve conter (por padrão):

``COMMIT_MESSAGE #ISSUE_NUMBER``

``COMMIT_MESSAGE`` sendo a mensagem em si e ``ISSUE_NUMBER`` o número da Issue aqui no Github.

### Fechando Issues

Para fechar uma Issue cadastrada aqui no Github, o commit deve conter (por padrão):

``COMMIT_MESSAGE closes #ISSUE_NUMBER``

``COMMIT_MESSAGE`` sendo a mensagem em si e ``ISSUE_NUMBER`` o número da Issue aqui no Github.

## Criando um fork (Bifurcação) do repositório para a sua conta

Você pode bifurcar este projeto para propor alterações no repositório upstream ou original, ou então como ponto de partida para sua própria ideia.

Para isso:

- Clique em **Fork** no canto superior direito;
- Crie o Fork;
- Abra o repositório (fork) que foi criado dentro de *Repositories* na sua conta.

### Clonando o repositório

Após fazer os passos anteriores:

- Clique em code;
- Copie o link (HTTPS) do repositório;
- Abra o Git Bash em seu PC;
- Altere o diretório de trabalho atual para o local em que deseja ter o diretório clonado;
- Digite ``git clone`` (clonar git) e cole a URL que você copiou anteriormente. Ficará assim, com seu nome de usuário do GitHub no lugar de ``YOUR-USERNAME`` e o do respectivo repositório em ``YOUR_FORK``:

        $ git clone https://github.com/YOUR-USERNAME/YOUR_FORK.git

- Pressione **Enter**. Seu clone local estará criado.

### Configurar o Git para sincronizar o fork (bifurcação) com o repositório original

- Pelo Git Bash, acessando o seu repositório local que foi criado, digite ``git remote -v`` e pressione **Enter**. Você verá o repositório remote atual configurado para sua bifurcação.

        $ git remote -v
        > origin  https://github.com/YOUR_USERNAME/YOUR_FORK.git (fetch)
        > origin  https://github.com/YOUR_USERNAME/YOUR_FORK.git (push)

- Digite ``git remote add upstream``, cole o URL que você copiou anteriormente e pressione Enter. Ficará assim:

        

- Para verificar o novo repositório upstream que você especificou para sua bifurcação, digite novamente ``git remote -v``. Você deverá visualizar a URL da sua bifurcação como ``origin`` (origem) e a URL do repositório original como ``upstream``.

        $ git remote -v
        > origin    https://github.com/YOUR_USERNAME/YOUR_FORK.git (fetch)
        > origin    https://github.com/YOUR_USERNAME/YOUR_FORK.git (push)
        > upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (fetch)
        > upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (push)

Agora é possível manter a bifurcação sincronizada com o repositório upstream usando apenas alguns comandos Git. Para obter mais informações, consulte "[Sincronizar uma bifurcação](https://docs.github.com/pt/pull-requests/collaborating-with-pull-requests/working-with-forks/syncing-a-fork)".

## Configurando o projeto no [NetBeans](https://netbeans.apache.org/download/index.html)

Após realizar os passos anteriores, você terá todos os arquivos do repositório localmente em seu PC. Agora, para finalizar a configuração do projeto no NetBeans:

- Abra a pasta do projeto no NetBeans;
- Clique na aba ``Run`` no topo da tela;
- Selecione a opção ``Clean and Build Project (NOME-PROJETO)``
- Assim, os arquivos serão compilados e você conseguirá executar o programa tranquilamente clicando em ``Run Project (NOME-PROJETO)``.

**Feito! Agora é só se divertir.**