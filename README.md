# Amor Doce
### Projeto JavaFx - IFRS Campus Canoas 2022/1

<p>amordoce - diretório principal: telas, controladores, modelos, handlers e App.java</p>
<p>assets - diretório de recursos: imagens, áudios, vídeos, etc.</p>
<p>css - diretório de estilos CSS</p>

# Time de desenvolvimento
<p>Filipe Siota</p>
<p>Gabriela Estigarribia</p>
<p>Giovani Signori</p>

# Classes

## App (Comentada)

- [ ] `public static Personagem usuario` - Nome do usuário
- [ ] `public static Set<Personagem> personagens = new HashSet<>()` - Array de personagens para fofoca
- [x] `Scene` - Trocas de cena

## Personagem (Comentada)

- [x] - nome: String
- [x] - idade: int
- [x] - signo: String
- [x] - nacionalidade: String
- [x] - genero: char
- [x] + conversas: Set<Conversa>
- [x] + conversasConcluidas: Set<Conversa>

- Barras:

- [x] - humor: String (feliz, empolgado, etc)
- [ ] - energia: double (REVISAR)
- [ ] - interesse: double (REVISAR)
- [x] - nivel: String

- Métodos:

- [x] + getConversaAtual(): Conversa
- [x] + concluirConversa(): void (adicionado a conversa às já concluídas para ter o log depois)
- [x] + atualizarInteresse(): void
- [x] + atualizarHumor(): void
- [x] + atualizarEnergia(): void
- [x] + logPersonagem(): ObservableList<String> (????)

### Herança (NomePersonagem)

- [ ] construção da personagem pelo método `super` dentro do contrutor (REVISAR)
- [x] - setarConversas(): void (seta as conversas referentes a esta personagem)

## Conversa (Comentada)

- [x] - id: int
- [x] - personagem: Personagem
- [x] - pergunta: String
- [x] - respostasPossiveis: Set<Resposta>
- [x] - reacoesPossiveis: Set<Resposta> (possíveis respostas dos personagens de acordo com a opção escolhida pelo usuário)
- [x] - respostaUsuario: Resposta

- Métodos:

- [x] + setRespostaUsuario(): void (atualiza os valores das barras do personagem de acordo com a resposta escolhida pelo usuário)
- [x] + getResposta(): String (o texto da resposta do usuário)
- [x] + getReacao(): String (o texto da reação do personagem)
- [x] + escolherResposta(): void (faz a escolha da resposta de uma conversa)
- [x] - buscarReacao(): Resposta (valida a busca pela reação de acordo com a opção escolhida)
- [x] - buscarResposta(): Resposta (valida a busca pela resposta de acordo com a opção escolhida)

## Resposta (Comentada)

- [x] - id: int
- [x] - texto: String
- [x] - humorFinal: String
- [ ] - deltaEnergia: double (REVISAR)
- [ ] - deltaInteresse: double (REVISAR)