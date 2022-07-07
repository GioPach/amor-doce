package amordoce.model;

public class Resposta {
    
    private static int seqId = 0;
    
    private int id;
    private String texto;
    private String humorFinal;
    private int deltaEnergia;
    private int deltaInteresse;  
    
    public Resposta() {
    
    }

    public Resposta(int id, String reacao) {
        this.id = id;
        this.texto = reacao;
    }    
    
    public Resposta(String texto, String humorFinal, int deltaInteresse) {
        this.id = seqId++;
        this.humorFinal = humorFinal;
        this.texto = texto;
        this.deltaInteresse = deltaInteresse;
    }
    
     public Resposta(String texto, String humorFinal, int deltaEnergia, int deltaInteresse) {
        this.id = seqId++;
        this.humorFinal = humorFinal;
        this.texto = texto;
        this.deltaEnergia = deltaEnergia;
        this.deltaInteresse = deltaInteresse;
    }

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

    public int getDeltaInteresse() {
        return this.deltaInteresse;
    }

    public void setDeltaInteresse(int deltaInteresse) {
        this.deltaInteresse = deltaInteresse;
    }
     
     public int getDeltaEnergia() {
        return this.deltaEnergia;
    }

    public void setDeltaEnergia(int deltaEnergia) {
        this.deltaEnergia = deltaEnergia;
    }
     
}
