package amordoce.model;

import java.util.Set;
import java.util.HashSet;

public class Personagem {

    private String nome;
    private int idade;
    private String signo;
    private String nacionalidade;
    private char genero;
    private String humor;
    private int energia;
    private int interesse;
    private String nivel;
    public Set<Conversa> conversas = new HashSet<>();
    public Set<Conversa> conversasConcluidas = new HashSet<>();


    public Personagem() {
    }

    public Personagem(String nome, int idade, String signo, String nacionalidade, char genero, String humor, int energia, int interesse, String nivel) {
        this.nome = nome;
        this.idade = idade;
        this.signo = signo;
        this.nacionalidade = nacionalidade;
        this.genero = genero;
        this.humor = humor;
        this.energia = energia;
        this.interesse = interesse;
        this.nivel = nivel;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public Conversa getConversaAtual() {
        return this.conversas.iterator().next(); // retorna primeiro elemento da fila de conversas
    }    
    
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
    
    public void atualizarHumor(String humorFinal) {
        this.humor = humorFinal;
    }
    
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
    
}