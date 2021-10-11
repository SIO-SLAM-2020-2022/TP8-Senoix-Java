package io.github.axel1.tp8senoix;

public class Produit {
    private int id;
    private String variete;
    private String type;
    private int calibre;

    public Produit(int id, String variete, String type, int calibre) {
        this.id = id;
        this.variete = variete;
        this.type = type;
        this.calibre = calibre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVariete() {
        return variete;
    }

    public void setVariete(String variete) {
        this.variete = variete;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", variete='" + variete + '\'' +
                ", type='" + type + '\'' +
                ", calibre=" + calibre +
                '}';
    }
}
