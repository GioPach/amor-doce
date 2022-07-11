package amordoce.model;

import enums.NivelDificuldade;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personagem {

    private String nome;
    private String turma;
    private Set<Personagem> colegas = new HashSet<>();
    private int idade;
    private String signo;
    private String nacionalidade;
    private char genero;
    private String msgApresentacao;
    private String humor; // barra
    private double energia; // barra
    private double interesse; // barra
    private NivelDificuldade nivel;
    private double fatorNivel; // determina o valor máximo do intervalo a ser utilizado para sorteio ao pedir em namoro
    private String fofoca;
    private boolean pedidoEmNamoro;
    public List<Conversa> conversas = new ArrayList<>(); // conversas do personagem
    public List<Conversa> conversasConcluidas = new ArrayList<>(); // conversas concluídas para gerar o log de conversas
    
    final private int converterParaPorcentagem = 100;

    public Personagem() {
    }
    
    public Personagem(String nome, String turma, int idade, String signo, String nacionalidade, char genero, NivelDificuldade nivel) {
        this.nome = nome;
        this.turma = turma;
        this.idade = idade;
        this.signo = signo;
        this.nacionalidade = nacionalidade;
        this.genero = genero;
        String primeiroNome = this.getNome().substring(0, this.getNome().indexOf(" "));
        this.msgApresentacao = "Me chamo " + primeiroNome + ", sou da turma de " + this.getTurma();
        this.humor = "Neutro";
        this.energia = 1.0;
        this.interesse = 0.0; // começa por padrão para implementar a lógica de sorteio do pedido de namoro
        this.nivel = nivel;
        this.setFatorNivel();
        this.fofoca = "";
        this.pedidoEmNamoro = false;
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

    public Set<Personagem> getColegas() {
        return this.colegas;
    }

    public void setColega(Personagem colega) {
        this.colegas.add(colega);
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

    public String getMsgApresentacao() {
        return msgApresentacao;
    }

    public void setMsgApresentacao(String msgApresentacao) {
        this.msgApresentacao = msgApresentacao;
    }

    public String getHumor() {
        return this.humor;
    }

    public void setHumor(String humor) {
        this.humor = humor;
    }

    public List<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(List<Conversa> conversas) {
        this.conversas = conversas;
    }

    public List<Conversa> getConversasConcluidas() {
        return conversasConcluidas;
    }

    public void setConversasConcluidas(List<Conversa> conversasConcluidas) {
        this.conversasConcluidas = conversasConcluidas;
    }

    public int getEnergia() {
        return (int) Math.round(this.energia * converterParaPorcentagem);
    }

    public void setEnergia(double energia) {
        this.atualizarEnergia(energia);
    }

    public int getInteresse() {
        return (int) Math.round(this.interesse * converterParaPorcentagem);
    }

    public void setInteresse(double interesse) {
        this.atualizarInteresse(interesse);
    }

    public NivelDificuldade getNivel() {
        return this.nivel;
    }

    public void setNivel(NivelDificuldade nivel) {
        this.nivel = nivel;
    }

    public double getFatorNivel() {
        return this.fatorNivel;
    }

    /**
     * Setta o desconto para o valor configurado no enum NivelDificuldade
     */
    public final void setFatorNivel() {
        this.fatorNivel = this.getNivel().getDesconto();
    }
    
    public String getFofoca() {
        return fofoca;
    }

    public void setFofoca(String fofoca) {
        this.fofoca = fofoca;
    }
    
    public boolean isPedidoEmNamoro() {
        return pedidoEmNamoro;
    }

    public void setPedidoEmNamoro(boolean pedidoEmNamoro) {
        this.pedidoEmNamoro = pedidoEmNamoro;
    }
     
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
    
    /*===============================
    # Demais métodos
    ===============================*/
    
    
    /**
     * Atualiza a energia do personagem após um diálogo
     * @param deltaEnergia 
     */
    public void atualizarEnergia(double deltaEnergia) {
        double tmpEnergia = arredondarDuasCasasDecimais(deltaEnergia + this.energia);
        
        if(tmpEnergia > 1.0) {
            this.energia = 1.0;
        } else if (tmpEnergia < 0.0){
            this.energia = 0.0;
        } else {
            this.energia = tmpEnergia;
        }
        
    }
    
    /**
     * Atualiza o interesse do personagem pelo usuário
     * @param deltaInteresse 
     */    
    public void atualizarInteresse(double deltaInteresse) {   
        double interesseFinal = arredondarDuasCasasDecimais(this.interesse + deltaInteresse);
        
        if(interesseFinal > 1) {
            this.interesse = 1.0;
        } else if(interesseFinal < 0) {
            this.interesse = 0.0;
        } else {
            this.interesse = interesseFinal;
        }
    }
    
    /**
     * Atualiza o humor do personagem após um diálogo
     * @param humorFinal 
     */
    public void atualizarHumor(String humorFinal) {
        this.humor = humorFinal;
    }
       
    public void atualizarColegas(double deltaInteresse) {
        for(Personagem colega : this.colegas) {
            colega.atualizarInteresse(deltaInteresse);
            double influenciaFofoca = arredondarDuasCasasDecimais(deltaInteresse * converterParaPorcentagem);
            String fofocaMensagem = this.getNome() + " fofocou com " + colega.getNome() + ".\nO interesse de " + colega.getNome();
            
            if(deltaInteresse > 0) {
                fofocaMensagem += " aumentou em " + influenciaFofoca + "%.";
            }
            else if (deltaInteresse < 0){
                fofocaMensagem += " diminuiu em " + influenciaFofoca + "%.";
            }
            else {
                fofocaMensagem += " permaneceu igual.";
            }
            
            colega.setFofoca(fofocaMensagem);
        }
    }
    
    /**
     * Conclui uma conversa (diálogo) e adiciona ela às já concluídas para ter o log de conversas no futuro
     * @param idConversa 
     */
    public void concluirConversa(int idConversa) {
        Conversa conversaConcluida = this.conversas.stream().filter(conversa -> conversa.getId() == idConversa).findFirst().orElse(new Conversa());
        this.conversasConcluidas.add(conversaConcluida);
        this.conversas.remove(conversaConcluida);
    }
    
    public boolean validarConversaAlternativa(int idConversa, int idRespostaTarget) {
        Resposta respostaAnterior;
        try {
            respostaAnterior = this.conversasConcluidas.get(idConversa).getRespostaUsuario();
        } catch (Exception e) {
            System.out.println(e);
            respostaAnterior = new Resposta();
        }
        
        if(respostaAnterior.getId() == idRespostaTarget) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Método usado para settar visibilidade do botão de pedir em namoro. O botão
     * se tornará visível ao usuário caso o personagem tenha atingido 50% de interesse,
     * possibilitando o pedido de namoro, que será executado pelo método pedirEmNamoro.
     * @return true se o personagem tiver 50% de interesse no mínimo; false caso contrário.
     */
    public boolean validarInteresse() {
        return this.interesse >= 0.5;
    }   
    
    /**
     * Método utilizado para garantir a validade do valor sorteado ao pedir em namoro
     * @param valor
     * @return valor com duas casas decimais
     */
    private double arredondarDuasCasasDecimais(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
    
    /**
     * Método chamado quando o usuário clicar no botão Pedir Em Namoro.
     * Sorteará um número dentro do intervalo interesse-nivel
     * @return true para responder "SIM" (número sorteado maior ou igual a 0.5); false caso contrário
     */
    public boolean pedirEmNamoro() {
        if(!validarInteresse()) {
            throw new Error("Modelo Personagem -> pedirEmNamoro: interesse menor que 50%...");
        }
        final double corretorIntervalo = 0.5;
        Random rand = new Random();
        double resposta = arredondarDuasCasasDecimais(rand.nextDouble(this.interesse - corretorIntervalo, this.fatorNivel));
        return resposta >= 0.5;        
    }
    
    /**
     * ObservableList utilizada para o componente ListView logar as conversas concluídas
     * @return lista de strings compostas pela pergunta do personagem e a resposta escolhida pelo usuário
     */
    public ObservableList<String> logPersonagem() {
        ObservableList<String> perguntaResposta = FXCollections.observableArrayList();
        this.conversasConcluidas.forEach((conversa) -> {
            perguntaResposta.add(this.nome + ": " + conversa.getPergunta().replace("\n", " ") + "\nVocê: " + conversa.getRespostaUsuario().getTexto().replace("\n", " "));
        });
        return perguntaResposta;    
    }
    
}