package amordoce.model;

import java.util.Set;
import java.util.HashSet;

public class Conversa {
    
    private static int seqId = 0;
    
    private int id;
    private Personagem personagem;
    private String pergunta;
    private Set<Resposta> respostasPossiveis = new HashSet<>(3);
    private Set<Resposta> reacoesPossiveis = new HashSet<>(3);
    private Resposta respostaUsuario;
    final private int numRespostasPossiveis = 3; // constante
    
    public Conversa() {
        this.id = -1;
        this.pergunta = "...";
        for(int i = 0; i < numRespostasPossiveis; i++) {
            this.respostasPossiveis.add(new Resposta(i));
            this.reacoesPossiveis.add(new Resposta(i));
        }
    }
    
    public Conversa(Personagem personagem, String pergunta, Set<Resposta> respostas, Set<Resposta> reacoesPossiveis) {
        if(respostas.size() != numRespostasPossiveis) {
            System.out.println("Modelo Conversa: Instancie 3 respostas...");
            return;
        }
        this.id = seqId++;
        this.personagem = personagem;
        this.pergunta = pergunta;
        this.respostasPossiveis = respostas;
        this.reacoesPossiveis = reacoesPossiveis;
    }
    
    /*===============================
    # Getters e Setters
    ===============================*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personagem getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public String getPergunta() {
        return this.pergunta;
    }
    
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public Set<Resposta> getReacoesPossiveis() {
        return reacoesPossiveis;
    }

    public void setReacoesPossiveis(Set<Resposta> reacoesPossiveis) {
        this.reacoesPossiveis = reacoesPossiveis;
    }

    public Set<Resposta> getRespostasPossiveis() {
        return this.respostasPossiveis;
    }

    public void setRespostasPossiveis(Set<Resposta> respostasPossiveis) {
        this.respostasPossiveis = respostasPossiveis;
    }

    public Resposta getRespostaUsuario() {
        return this.respostaUsuario;
    }
    
    public void setRespostaUsuario(Resposta respostaUsuario) {
        this.respostaUsuario = respostaUsuario;
        this.personagem.atualizarInteresse(this.respostaUsuario.getDeltaInteresse()); // atualiza barra de interesse
        this.personagem.atualizarHumor(this.respostaUsuario.getHumorFinal()); // atualiza barra de humor
        this.personagem.atualizarEnergia(this.respostaUsuario.getDeltaEnergia()); // atualiza barra de energia  
        this.personagem.atualizarColegas(this.respostaUsuario.getDeltaInteresse() / 4); // fofoca com Personagem da mesma turma (25% de influência)
    }
    
    /*===============================
    # Demais métodos
    ===============================*/
    
    /**
     * Busca o texto da resposta através do seu id
     * @param idResposta
     * @return o texto da resposta do usuário
     */
    public String getResposta(int idResposta) {
        return this.buscarResposta(idResposta).getTexto();
    }
    
    /**
     * Busca a reação da resposta através do seu id
     * @param idResposta
     * @return o texto da reação do personagem
     */
    public String getReacao(int idResposta) {
        return this.buscarReacao(idResposta).getTexto();
    }

    /**
     * Faz a escolha da resposta de uma conversa
     * @param idResposta 
     */
    public void escolherResposta(int idResposta) {
        this.setRespostaUsuario(buscarResposta(idResposta));
    } 
    
    /**
     * Valida a busca pela reação de acordo com a opção escolhida
     * @param idResposta
     * @return o objeto da reação do personagem
     */
    private Resposta buscarReacao(int idResposta) {
        return this.reacoesPossiveis.stream()
            .filter(conversa -> conversa.getId() == idResposta)
            .findFirst()
            .orElse(new Resposta());
    }
    
    /**
     * Valida a busca pela resposta de acordo com a opção escolhida
     * @param idResposta
     * @return o objeto da resposta do usuário
     */
    private Resposta buscarResposta(int idResposta) {
        return this.respostasPossiveis.stream()
            .filter(conversa -> conversa.getId() == idResposta)
            .findFirst()
            .orElse(new Resposta());
    }
}