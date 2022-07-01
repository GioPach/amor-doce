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
    private double interesse;
    // private Set<Conversa> conversas = new HashSet<>();
    private String nivel;


    public Personagem() {
    }

    public Personagem(String nome, int idade, String signo, String nacionalidade, char genero, String humor, int energia, double interesse, String nivel) {
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

    public double getInteresse() {
        return this.interesse;
    }

    public void setInteresse(double interesse) {
        if(interesse >= 0 && interesse <= 1)
        {
            this.interesse = interesse * 100;
        }
        
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", idade='" + getIdade() + "'" +
            ", signo='" + getSigno() + "'" +
            ", nacionalidade='" + getNacionalidade() + "'" +
            ", genero='" + getGenero() + "'" +
            ", humor='" + getHumor() + "'" +
            ", energia='" + getEnergia() + "'" +
            ", interesse='" + getInteresse() + "'" +
            ", nivel='" + getNivel() + "'" +
            "}";
    }


}