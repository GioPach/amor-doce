# Amor Doce

    Projeto JavaFx - IFRS Campus Canoas 2022/1

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