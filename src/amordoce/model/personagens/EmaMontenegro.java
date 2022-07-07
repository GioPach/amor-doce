package amordoce.model.personagens;

import amordoce.model.Personagem;
import amordoce.model.Conversa;
import amordoce.model.Resposta;

import java.util.HashSet;
import java.util.Set;

public class EmaMontenegro extends Personagem {
    
    /**
     * Constrói a personagem com suas conversas e atributos setados
     */
    public EmaMontenegro() {
        
    }
    
    public EmaMontenegro(String nome, int idade, String signo, String nacionalidade, char genero, String humor, int energia, int interesse, String nivel) {
        super(nome, idade, signo, nacionalidade, genero, humor, energia, interesse, nivel);
        setarConversas();
    }
    
    private void setarConversas() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta("Sim. Eu sou o aluno novo!", "Empolgada", 10, 10));
        respostasPossiveis.add(new Resposta("Sim.", "Neutro", 5));
        respostasPossiveis.add(new Resposta("Não viaja!", "Irritada", -20, -5));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Que ótimo! Seja bem-vindo!"));
        reacoesPossiveis.add(new Resposta(1, "Bem-vindo..."));
        reacoesPossiveis.add(new Resposta(2, "Como?"));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        Conversa conversa = new Conversa(this, "Você é novo por aqui, né?", respostasPossiveis, reacoesPossiveis);
        this.conversas.add(conversa);
    }
    
}
