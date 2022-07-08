package amordoce.model.personagens;

import amordoce.model.Personagem;
import amordoce.model.Conversa;
import amordoce.model.Resposta;
import enums.NivelDificuldade;

import java.util.HashSet;
import java.util.Set;

public class EmaMontenegro extends Personagem {
    
    /**
     * Constrói a personagem com suas conversas e atributos setados
     */
    public EmaMontenegro() {
        
    }
    
    public EmaMontenegro(String nome, String turma, int idade, String signo, String nacionalidade, char genero, String humor, double energia, double interesse, NivelDificuldade nivel) {
        super(nome, turma, idade, signo, nacionalidade, genero, humor, energia, interesse, nivel);
        setarConversas();
    }
    
    private void setarConversas() {
        Conversa conversa1 = criarConversa1();
        Conversa conversa2 = criarConversa2();
         // Conversa conversa3 = criarConversa1();
         //  Conversa conversa4 = criarConversa1();
           // Conversa conversa5 = criarConversa1();
        this.conversas.add(conversa1);
        this.conversas.add(conversa2);
       // this.conversas.add(conversa3);
       // this.conversas.add(conversa4);
       // this.conversas.add(conversa5);
    }
    
    private Conversa criarConversa1() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sim. Eu sou o aluno novo!", "Empolgada", 0.1, 0.1));
        respostasPossiveis.add(new Resposta(1, "Sim.", "Neutro", 0.05));
        respostasPossiveis.add(new Resposta(2, "Não viaja!", "Irritada", -0.2, -0.05));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Que ótimo! Seja bem-vindo!"));
        reacoesPossiveis.add(new Resposta(1, "Bem-vindo..."));
        reacoesPossiveis.add(new Resposta(2, "Como?"));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Você é novo por aqui, né?", respostasPossiveis, reacoesPossiveis);
    }
    
      private Conversa criarConversa2() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sou de DS3, e você?", "Empolgada", 0.05, 0.05));
        respostasPossiveis.add(new Resposta(1, "Sou de DS3.", "Neutro", 0.0));
        respostasPossiveis.add(new Resposta(2, "Nem eu sei! Será que você poderia me apresentar o campus?", "Incomodada", -0.05, -0.05));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Sou de ELE3, Ema, prazer."));
        reacoesPossiveis.add(new Resposta(1, "Ah..."));
        reacoesPossiveis.add(new Resposta(2, "Que tipo de calouro não\nsabe nem a própria turma?"));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "De que turma você é?", respostasPossiveis, reacoesPossiveis);
    }
    
    
}
