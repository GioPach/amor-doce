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
    
    public EmaMontenegro(String nome, String turma, int idade, String signo, String nacionalidade, char genero, NivelDificuldade nivel) {
        super(nome, turma, idade, signo, nacionalidade, genero, nivel);
        setarConversas();
    }
     private void setarConversas() {
        this.conversas.add(0, criarConversa1());
        this.conversas.add(1, criarConversa2());
        this.conversas.add(2, criarConversa3());
        this.conversas.add(3, criarConversa4());
        this.conversas.add(4, criarConversa5());
        this.conversas.add(5, criarConversa6());
        this.conversas.add(6, criarConversa7());
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
        respostasPossiveis.add(new Resposta(0, "Sou de Administração.", this.getHumor(), 0.0, 0.05));
        respostasPossiveis.add(new Resposta(1, "Sou de Música.", "Empolgado", 0.07, 0.07));
        respostasPossiveis.add(new Resposta(2, "Sou de Informática", this.getHumor(), 0.0, 0.05));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Ah...legal."));
        reacoesPossiveis.add(new Resposta(1, "AE! Tomara que curta o curso!"));
        reacoesPossiveis.add(new Resposta(2, "Bacana...é um campo muito amplo."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Tu é de que turma mesmo?", respostasPossiveis, reacoesPossiveis);
    }
    
    /**
     * Carrega uma conversa diferente se o usuário tiver escolhido a segunda opção da segunda conversa
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
        respostasPossiveis.add(new Resposta(0, "Eae, o quê vocês fazem pra se divertir aqui?", "Interessado", 0.08, 0.15));
        respostasPossiveis.add(new Resposta(1, "Sabe de algum projeto bom pra calouro entrar?", "Neutro", -0.08, -0.1));
        respostasPossiveis.add(new Resposta(2, "Que tipo de música tu gosta?", "Neutro", 0.05, 0.1));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Opa! Geralmente fazemos um monte de festas e eventos pro pessoal..."));
        reacoesPossiveis.add(new Resposta(1, "Só lembro daquele as redações do Enem, mas esse já está cheio..."));
        reacoesPossiveis.add(new Resposta(2, "Escuto muito sertanejo universitário e pop."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "...", respostasPossiveis, reacoesPossiveis);
    }  
    
    /**
     * Instancia uma conversa alternativa para ser utilizada caso o usuário tenha escolhido a segunda opção da segunda conversa
     * @return conversa alternativa
     */
     private Conversa conversaAlternativa3() {
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sou do rock!", "Neutro", -0.05, -0.1));
        respostasPossiveis.add(new Resposta(1, "Escuto muito sertanejo universitário.", this.getHumor(), 0.08, 0.08));
        respostasPossiveis.add(new Resposta(2, "Curto música clássica...", "Neutro", -0.07, -0.1));
        
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
        respostasPossiveis.add(new Resposta(0, "Com certeza! Não perco por nada.", "Empolgado", 0.08, 0.1));
        respostasPossiveis.add(new Resposta(1, "Festa? Que horas?", "Neutro", 0.03, 0.05));
        respostasPossiveis.add(new Resposta(2, "Sim.", this.getHumor(), 0.05, 0.07));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Show! Só chegar e eras isso."));
        reacoesPossiveis.add(new Resposta(1, "Começa às 13h, mas se quiser vir antes pra ajudar..."));
        reacoesPossiveis.add(new Resposta(2, "Beleza. Não esquece de trazer dinheiro pra entrada."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Olha só, segunda tem uma festa pros calouros. Vai vir?", respostasPossiveis, reacoesPossiveis);
    }
    
    /**
     * Carrega uma conversa diferente se o usuário tiver escolhido a primeira opção da quarta conversa
     */
    public void verificarConversa4() {
        int idConversa4 = 3, idRespostaTarget = 1;
        if(validarConversaAlternativa(idConversa4, idRespostaTarget)) {
            this.getConversas().set(0, conversaAlternativa5());
        }
    }  
    
    /********************************
     * Conversa 5
     *  
    *******************************/
    private Conversa criarConversa5() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Que horas é a festa?", this.getHumor(), 0.08, 0.1));
        respostasPossiveis.add(new Resposta(1, "Vai ter muita gente?", this.getHumor(), 0.03, 0.05));
        respostasPossiveis.add(new Resposta(2, "O quê vai ter pra fazer?", this.getHumor(), -0.1, -0.15));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Às 13h"));
        reacoesPossiveis.add(new Resposta(1, "Sim! De todo o tipo!"));
        reacoesPossiveis.add(new Resposta(2, "Que tipo de pergunta é essa? É uma festa..."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "...", respostasPossiveis, reacoesPossiveis);
    }
    
     /**
     * Instancia uma conversa alternativa para ser utilizada caso o usuário tenha escolhido a primeira opção da quarta conversa
     * @return conversa alternativa
     */
    private Conversa conversaAlternativa5() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Que horas é a festa?", "Irritado", -0.15, -0.1));
        respostasPossiveis.add(new Resposta(1, "Bebida é liberada?", "Interessado", 0.1, 0.15));
        respostasPossiveis.add(new Resposta(2, "Vai vir gente de fora?", this.getHumor(), 0.05, 0.05));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Tu é DDA? Eu literalmente acabei de te dizer..."));
        reacoesPossiveis.add(new Resposta(1, "Infelizmente não...mas nas festas privadas a gente aproveita!"));
        reacoesPossiveis.add(new Resposta(2, "Sim! Vêm alguns de outros campus."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "...", respostasPossiveis, reacoesPossiveis);
    }
    
    /********************************
     * Conversa 6
     *  
    *******************************/
    
    private Conversa criarConversa6() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Sabe se a Catherine vai vir?", "Neutro", -0.12, -0.12));
        respostasPossiveis.add(new Resposta(1, "Alguma dica pra festa?", "Interessado", 0.03, 0.05));
        respostasPossiveis.add(new Resposta(2, "Tu vai vir como?", "Interessado", 0.05, 0.08));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Provavelmente..."));
        reacoesPossiveis.add(new Resposta(1, "Relaxa e aproveita!"));
        reacoesPossiveis.add(new Resposta(2, "Bah, não sei ainda..."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "...", respostasPossiveis, reacoesPossiveis);
    }
    
    /**
     * Carrega uma conversa diferente se o usuário tiver escolhido a terceira opção da sexta conversa
     */
    public void verificarConversa6() {
        int idConversa6 = 5, idRespostaTarget = 2;
        if(validarConversaAlternativa(idConversa6, idRespostaTarget)) {
            this.getConversas().set(0, conversaAlternativa7());
        }
    }  
    
     /********************************
     * Conversa 7
     *  
    *******************************/
    
    public Conversa criarConversa7() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Já! Fui de penetra em umas três...adoro festas", "Empolgado", 0.1, 0.1));
        respostasPossiveis.add(new Resposta(1, "Sim. Da vez que eu fui, curti demais a recepção do pessoal!", "Neutro", 0.0, 0.0));
        respostasPossiveis.add(new Resposta(2, "Sim! Adoro festa!", "Aliviado", 0.1, 0.1));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Meu número é 99022-8922...se quiser me chamar pra invadir mais alguma hehe"));
        reacoesPossiveis.add(new Resposta(1, "É sempre uma ótima oportunidade pra conhecer gente."));
        reacoesPossiveis.add(new Resposta(2, "Meu número é 99022-8922...se quiser me convidar pra ir em alguma hehe"));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "Tu já foi em alguma festa de calouro antes?", respostasPossiveis, reacoesPossiveis);
    }
    
    /**
     * Instancia uma conversa alternativa para ser utilizada caso o usuário tenha escolhido a terceira opção da sexta conversa
     * @return conversa alternativa
     */
    private Conversa conversaAlternativa7() {
        // Respostas que podem ser escolhidas pelo usuário
        Set<Resposta> respostasPossiveis = new HashSet();
        respostasPossiveis.add(new Resposta(0, "Quer que eu te dê uma carona?", "Neutro", 0.0, 0.0));
        respostasPossiveis.add(new Resposta(1, "Me passa teu número? Dependendo a gente combina de eu te pegar em casas", "Interessado", 0.2, 0.2));
        respostasPossiveis.add(new Resposta(2, "Quer rachar um Uber?", "Aliviado", 0.08, 0.05));
        
        // Possíveis reações a resposta do usuário
        Set<Resposta> reacoesPossiveis = new HashSet();
        reacoesPossiveis.add(new Resposta(0, "Não precisa...eu me viro."));
        reacoesPossiveis.add(new Resposta(1, "Claro. Anota aí: 99022-8922."));
        reacoesPossiveis.add(new Resposta(2, "Pode ser. A gente combina mais tarde então."));

        // Implementa a pergunta, criando um objeto Conversa e o colocando no array de conversas
        return new Conversa(this, "...", respostasPossiveis, reacoesPossiveis);
    }
}
    
