package amordoce.model;

import java.util.Set;
import java.util.HashSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personagem {

    private String nome;
    private String turma;
    private Personagem colega;
    private int idade;
    private String signo;
    private String nacionalidade;
    private char genero;
    private String humor; // barra
    private int energia; // barra
    private int interesse; // barra
    private String nivel; // barra
    public Set<Conversa> conversas = new HashSet<>(); // conversas do personagem
    public Set<Conversa> conversasConcluidas = new HashSet<>(); // conversas concluídas para gerar o log de conversas

    public Personagem() {
    }

    public Personagem(String nome, String turma, int idade, String signo, String nacionalidade, char genero, String humor, int energia, int interesse, String nivel) {
        this.nome = nome;
        this.turma = turma;
        this.idade = idade;
        this.signo = signo;
        this.nacionalidade = nacionalidade;
        this.genero = genero;
        this.humor = humor;
        this.energia = energia;
        this.interesse = interesse;
        this.nivel = nivel;
    }
    
    /*===============================
    # Getters e Setters
    ===============================*/

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Personagem getColega() {
        return colega;
    }

    public void setColega(Personagem colega) {
        this.colega = colega;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSigno() {
        return this.signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public char getGenero() {
        return this.genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getHumor() {
        return this.humor;
    }

    public void setHumor(String humor) {
        this.humor = humor;
    }

    public Set<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(Set<Conversa> conversas) {
        this.conversas = conversas;
    }

    public Set<Conversa> getConversasConcluidas() {
        return conversasConcluidas;
    }

    public void setConversasConcluidas(Set<Conversa> conversasConcluidas) {
        this.conversasConcluidas = conversasConcluidas;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getInteresse() {
        return this.interesse;
    }

    public void setInteresse(int interesse) {
        this.interesse = interesse;
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    /*===============================
    # Demais métodos
    ===============================*/
    
    /**
     * O Padrão Iterator fornece uma maneira de acessar sequencialmente os elementos de um objeto agregado sem expor a sua representação subjacente
     * @return o primeiro elemento da fila de conversas
     */
    public Conversa getConversaAtual() {
               
        if(this.conversas.isEmpty()) {
            return new Conversa();
        } else {
            return this.conversas.iterator().next();
        }
    }    
    
    /**
     * Conclui uma conversa (diálogo) e adiciona ela às já concluídas para ter o log de conversas no futuro
     * @param idConversa 
     */
    public void concluirConversa(int idConversa) {
        for(Conversa conversa : this.conversas) {
            if(conversa.getId() == idConversa) {
                this.conversasConcluidas.add(conversa);
                this.conversas.remove(conversa);
            }
        }
    }
    
    /**
     * Atualiza o interesse do personagem pelo usuário
     * @param deltaInteresse 
     */    
    public void atualizarInteresse(int deltaInteresse) {
        int tmpInteresse = this.interesse + deltaInteresse;
        
        if(tmpInteresse < 0) {
            this.interesse = 0;
        }         
        else if(tmpInteresse > 100) {
            this.interesse = 100;
        }         
        else {
            this.interesse += deltaInteresse;
        }
    }
    
    /**
     * Atualiza o humor do personagem após um diálogo
     * @param humorFinal 
     */
    public void atualizarHumor(String humorFinal) {
        this.humor = humorFinal;
    }
    
    /**
     * Atualiza a energia do personagem após um diálogo
     * @param deltaEnergia 
     */
    public void atualizarEnergia(int deltaEnergia) {
        int tmpEnergia = this.energia + deltaEnergia;
        
        if(tmpEnergia < 0) {
            this.energia = 0;
        }         
        else if(tmpEnergia > 100) {
            this.energia = 100;
        }         
        else {
            this.energia += deltaEnergia;
        }
    }
    
    public void atualizarColega(int deltaInteresse, int deltaEnergia) {
        
    }
    
    /**
     * ObservableList??
     * @return 
     */
    public ObservableList<String> logPersonagem() {
        ObservableList<String> perguntaResposta = FXCollections.observableArrayList();
        this.conversasConcluidas.forEach((conversa) -> {
            perguntaResposta.add(conversa.getPergunta() + " " + conversa.getRespostaUsuario().getTexto());
        });
        return perguntaResposta;    
    }
    
}