package amordoce.model.personagens;

import amordoce.model.Personagem;
import amordoce.model.Conversa;
import amordoce.model.Resposta;
import java.util.HashSet;
import java.util.Set;

public class EmaMontenegro extends Personagem {
    
    public EmaMontenegro() {
        super("Ema Montenegro", 21, "Gêmeos", "Espanhola", 'F', "Neutro", 100, 0, "Fácil");     
        setarConversas();
    }
    
    public void setarConversas() {
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta("Sim. Eu sou o aluno novo!", "Empolgada", 10, 10));
        respostasPossiveis.add(new Resposta("Sim.", "Neutro", 5));
        respostasPossiveis.add(new Resposta("Não viaja!", "Irritada", -20, -5));
        
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Que ótimo! Seja bem-vindo!"));
        reacoesPossiveis.add(new Resposta(1, "Bem-vindo..."));
        reacoesPossiveis.add(new Resposta(2, "Como?"));

        Conversa conversa = new Conversa(this, "Você é novo por aqui, né?", respostasPossiveis, reacoesPossiveis);
        this.conversas.add(conversa);
    }
    
}
