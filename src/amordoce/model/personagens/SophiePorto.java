package amordoce.model.personagens;

import amordoce.model.Personagem;
import amordoce.model.Conversa;
import amordoce.model.Resposta;
import enums.NivelDificuldade;

import java.util.HashSet;
import java.util.Set;

public class SophiePorto extends Personagem {
    
    /**
     * Constrói a personagem com suas conversas e atributos setados
     */
    public SophiePorto() {
        
    }
    
    public SophiePorto(String nome, String turma, int idade, String signo, String nacionalidade, char genero, NivelDificuldade nivel) {
        super(nome, turma, idade, signo, nacionalidade, genero, nivel);
        setarConversas();
    }
    
    private void setarConversas() {
        this.conversas.add(0, criarConversa1());
        this.conversas.add(1, criarConversa2());
        this.conversas.add(2, criarConversa3());
        this.conversas.add(3, criarConversa4());
        //this.conversas.add(4, criarConversa5());
    }
    
    private Conversa criarConversa1() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sim. Eu sou o aluno novo!", "Empolgada", 0.2));
        respostasPossiveis.add(new Resposta(1, "Sim...", "Neutro", 0.1));
        respostasPossiveis.add(new Resposta(2, "E se eu fosse?", "Irritada", -0.2, -0.1));
               
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Que ótimo! Seja bem-vindo!"));
        reacoesPossiveis.add(new Resposta(1, "Bem-vindo..."));
        reacoesPossiveis.add(new Resposta(2, "Como?"));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Oi, você é novo por aqui, né?", respostasPossiveis, reacoesPossiveis);
    }
    
    private Conversa criarConversa2() {
        // Respostas que podem ser escolhidas pelo usuário        
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Nem eu sei hahaha! Será que você poderia me apresentar o campus?", this.getHumor(), -0.1, -0.1));
        respostasPossiveis.add(new Resposta(1, "Sou de DS3, e tu?", this.getHumor(), 0.1, 0.1));
        respostasPossiveis.add(new Resposta(2, "Sou de DS3.", this.getHumor(), 0.0, 0.0));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Que tipo de calouro não\nsabe nem a própria turma?"));
        reacoesPossiveis.add(new Resposta(1, this.getMsgApresentacao()));
        reacoesPossiveis.add(new Resposta(2, "Ah..."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "De que turma você é?", respostasPossiveis, reacoesPossiveis);
    }
    
    private Conversa criarConversa3() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Tu curte um rock?", "Feliz", 0.1, 0.1));
        respostasPossiveis.add(new Resposta(1, "Qual é o teu nome mesmo?", this.getHumor(), -0.1, -0.1));
        respostasPossiveis.add(new Resposta(2, "Tô pensando em passar no laboratório de informática...", this.getHumor(), 0.0, 0.0));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Adoro! Sou muito fã de Queen!", "Alegre"));
        reacoesPossiveis.add(new Resposta(1, "Me chamo Sophie..."));
        reacoesPossiveis.add(new Resposta(2, "É só virar à esquerda e entrar \nno segundo bloco \nda direita..."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "...", respostasPossiveis, reacoesPossiveis);
    }
    
    private Conversa criarConversa4() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sim! Tenho que levar alguma coisa?", "Envergonhada", 0.07, 0.07));
        respostasPossiveis.add(new Resposta(1, "Obrigado pelo convite, mas já tenho compromisso", "Irritada", -0.2, -0.2));
        respostasPossiveis.add(new Resposta(2, "Claro! Onde vai ser?", this.getHumor(), 0.05, 0.05));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Traz esse teu rostinho e \nvai estar tudo certo!"));
        reacoesPossiveis.add(new Resposta(1, "Mas eu nem disse quando vai ser!"));
        reacoesPossiveis.add(new Resposta(2, "Aqui no campus mesmo! A festa dos calouros é uma das melhores..."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Ei, segunda tem uma festa...\ntá afim de vir?", respostasPossiveis, reacoesPossiveis);
    }
    
    /**
     * Carrega uma conversa diferente na quarta se o usuário tiver escolhido a opção 0 na terceira conversa
     */
    public void verificarRespostaConversa3() {
        if(this.getConversaAtual().getId() == 3) {
            Resposta respostaAnterior = this.getConversasConcluidas().get(2).getRespostaUsuario();
            if(respostaAnterior.getId() == 0) {
                this.getConversas().set(0, conversaAlternativa4());
            }
        }
    }
    
    /**
     * Instancia uma conversa alternativa para ser utilizada caso o usuário ter escolhido a opção 0 na terceira conversa
     * @return conversa alternativa
     */
    private Conversa conversaAlternativa4() {
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Mais ou menos", "Neutro", -0.05, -0.05));
        respostasPossiveis.add(new Resposta(1, "É a minha vida! Tenho uma banda desde piá!", this.getHumor(), 0.1, 0.1));
        respostasPossiveis.add(new Resposta(2, "Mais ou menos...gosto mais de Imagine Dragons", "Irritada", -0.15, -0.15));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Hm..."));
        reacoesPossiveis.add(new Resposta(1, "É mesmo?? Onde vocês tocam??"));
        reacoesPossiveis.add(new Resposta(2, "Pff...Imagine Dragons nem é uma banda de rock!"));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Tu curte também?", respostasPossiveis, reacoesPossiveis);
    }
}
    
