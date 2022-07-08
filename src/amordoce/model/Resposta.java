package amordoce.model;

public class Resposta {
    
    private int id;
    private String texto;
    private String humorFinal;
    private double deltaEnergia;
    private double deltaInteresse;
    
    public Resposta() {
    }
    
    public Resposta(int id) {
        this.id = id;
        this.texto = "...";
    }

    public Resposta(int id, String reacao) {
        this.id = id;
        this.texto = reacao;
    }    
    
    public Resposta(int id, String texto, String humorFinal, double deltaInteresse) {
        this.id = id;
        this.humorFinal = humorFinal;
        this.texto = texto;
        this.deltaInteresse = deltaInteresse;
    }
    
     public Resposta(int id, String texto, String humorFinal, double deltaEnergia, double deltaInteresse) {
        this.id = id;
        this.humorFinal = humorFinal;
        this.texto = texto;
        this.deltaEnergia = deltaEnergia;
        this.deltaInteresse = deltaInteresse;
    }

    /*===============================
    # Getters e Setters
    ===============================*/
     
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String getHumorFinal() {
        return this.humorFinal;
    }
    
    public void setHumorFinal(String humorFinal) {
        this.humorFinal = humorFinal;
    }

    public double getDeltaInteresse() {
        return this.deltaInteresse;
    }

    public void setDeltaInteresse(double deltaInteresse) {
        this.deltaInteresse = deltaInteresse;
    }
     
     public double getDeltaEnergia() {
        return this.deltaEnergia;
    }

    public void setDeltaEnergia(double deltaEnergia) {
        this.deltaEnergia = deltaEnergia;
    }
     
}
