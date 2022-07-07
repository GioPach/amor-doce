package amordoce.model;

import java.util.Set;
import java.util.HashSet;

public class Conversa {
    
    private static int seqId = 0;
    
    private int id;
    private Personagem personagem;
    private String pergunta;
    private Set<Resposta> respostasPossiveis = new HashSet<>();
    private Set<Resposta> reacoesPossiveis = new HashSet<>();
    private Resposta respostaUsuario;
    final private int numRespostasPossiveis = 3;
    
    public Conversa() {
    
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

    public Set<Resposta> getReacoesPossiveis() {
        return reacoesPossiveis;
    }

    public void setReacoesPossiveis(Set<Resposta> reacoesPossiveis) {
        this.reacoesPossiveis = reacoesPossiveis;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
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
        this.personagem.atualizarInteresse(this.respostaUsuario.getDeltaInteresse());
        this.personagem.atualizarHumor(this.respostaUsuario.getHumorFinal());
        this.personagem.atualizarEnergia(this.respostaUsuario.getDeltaEnergia());
    }
    
    public String getResposta(int idResposta) {
        return this.buscarResposta(idResposta).getTexto();
    }
    
    public String getReacao(int idResposta) {
        return this.buscarReacao(idResposta).getTexto();
    }

    public void escolherResposta(int idResposta) {
        if(idResposta < 0 || idResposta > 2) {
            throw new Error("Modelo Conversa -> metodo escolherResposta: o id da resposta deve ser: 0, 1 ou 2");
        }
        
        this.setRespostaUsuario(buscarResposta(idResposta));
       
    } 
    
    private Resposta buscarReacao(int idResposta) {
        for(Resposta reacao : this.reacoesPossiveis) {
            if(reacao.getId() == idResposta) {
                return reacao;
            }
        }
        throw new Error("Modelo Conversa -> metodo buscarReacao: reacao nao encontrada...");
    }
    
    private Resposta buscarResposta(int idResposta) {
        for(Resposta resposta : this.respostasPossiveis) {
            if(resposta.getId() == idResposta) {
                return resposta;
            }
        }
        throw new Error("Modelo Conversa -> metodo buscarResposta: resposta nao encontrada...");
    }
    
}
