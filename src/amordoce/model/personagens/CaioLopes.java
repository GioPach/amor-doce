package amordoce.model.personagens;

import amordoce.model.Personagem;
import amordoce.model.Conversa;
import amordoce.model.Resposta;
import enums.NivelDificuldade;

import java.util.HashSet;
import java.util.Set;

public class CaioLopes extends Personagem {
    
    /**
     * Constrói a personagem com suas conversas e atributos setados
     */
    public CaioLopes() {
        
    }
    
    public CaioLopes(String nome, String turma, int idade, String signo, String nacionalidade, char genero, NivelDificuldade nivel) {
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
    
    /********************************
     * Conversa 1
     *  
    *******************************/
    
    private Conversa criarConversa1() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sim, sou. E tu?", this.getHumor(), 0.0, 0.0));
        respostasPossiveis.add(new Resposta(1, "Sim. Tu é daqui?", "Irônico", -0.05, -0.05));
        respostasPossiveis.add(new Resposta(2, "SIm. Tu é de que turma?", this.getHumor(), 0.0, 0.0));
               
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, this.getMsgApresentacao()));
        reacoesPossiveis.add(new Resposta(1, "Não não...estudo lá na esquina!"));
        reacoesPossiveis.add(new Resposta(2, this.getMsgApresentacao()));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Eae, tu é um dos alunos novos?", respostasPossiveis, reacoesPossiveis);
    }
    
    /********************************
     * Conversa 2
     *  
    *******************************/
    
    private Conversa criarConversa2() {
        // Respostas que podem ser escolhidas pelo usuário        
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sou de Administração.", this.getHumor(), 0.0, 0.0));
        respostasPossiveis.add(new Resposta(1, "Sou de Música.", "Empolgado", 0.1, 0.1));
        respostasPossiveis.add(new Resposta(2, "Sou de Informática", this.getHumor(), 0.0, 0.0));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Ah...legal."));
        reacoesPossiveis.add(new Resposta(1, "AE! Tomara que curta o curso!"));
        reacoesPossiveis.add(new Resposta(2, "Bacana...é um campo muito amplo."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Tu é de que turma mesmo?", respostasPossiveis, reacoesPossiveis);
    }
    
    /**
     * Carrega uma conversa diferente na quarta se o usuário tiver escolhido a segunda opção da segunda conversas
     */
    public void verificarConversa2() {
        int idConversa2 = 1, idRespostaTarget = 1;
        if(validarConversaAlternativa(idConversa2, idRespostaTarget)) {
            this.getConversas().set(0, conversaAlternativa3());
        }
    }  
    
    /********************************
     * Conversa 3
     *  
    *******************************/
    
    private Conversa criarConversa3() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Eae, o que vocês fazem pra se divertir aqui?", "Interessado", 0.1, 0.1));
        respostasPossiveis.add(new Resposta(1, "Pois é...e esse tempo que não muda!", "Neutro", -0.05, -0.05));
        respostasPossiveis.add(new Resposta(2, "Que tipo de música tu gosta?", "Neutro", 0.05, 0.05));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Opa! Agora de início geralmente\nfazemos uma festa privada\npara alguns calouros..."));
        reacoesPossiveis.add(new Resposta(1, "Pois é..."));
        reacoesPossiveis.add(new Resposta(2, "Escuto muito sertanejo universitário e pop."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "...", respostasPossiveis, reacoesPossiveis);
    }  
    
    /**
     * Instancia uma conversa alternativa para ser utilizada caso o usuário ter escolhido a segunda opção da segunda conversa
     * @return conversa alternativa
     */
     private Conversa conversaAlternativa3() {
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sou do rock!", "Neutro", -0.05, -0.05));
        respostasPossiveis.add(new Resposta(1, "Escuto muito sertanejo universitário.", this.getHumor(), 0.15, 0.15));
        respostasPossiveis.add(new Resposta(2, "Curto música clássica...", "Neutro", -0.07, -0.07));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Legal..."));
        reacoesPossiveis.add(new Resposta(1, "Jura?? Eu adoro sertanejo universitário!!"));
        reacoesPossiveis.add(new Resposta(2, "Bacana..."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Qual é o teu estilo?", respostasPossiveis, reacoesPossiveis);
    }
     
    /********************************
     * Conversa 4
     *  
    *******************************/
    
    private Conversa criarConversa4() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sim! Tenho que levar alguma coisa?", "Envergonhada", 0.1, 0.1));
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
    
   
 
    
}
    
