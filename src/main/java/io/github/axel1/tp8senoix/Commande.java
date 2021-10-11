package io.github.axel1.tp8senoix;

import java.time.LocalDate;

public class Commande {
    private int id;
    private Produit leProduit;
    private Float prixHt;
    private String conditionnement;
    private int quantite;
    private LocalDate dateConditionnement;
    private LocalDate dateEnvoi;

    public Commande(int id, Produit leProduit, Float prixHt, String conditionnement, int quantite, LocalDate dateConditionnement, LocalDate dateEnvoi) {
        this.id = id;
        this.leProduit = leProduit;
        this.prixHt = prixHt;
        this.conditionnement = conditionnement;
        this.quantite = quantite;
        this.dateConditionnement = dateConditionnement;
        this.dateEnvoi = dateEnvoi;
    }

    public Boolean isEnCours() {
        return this.dateEnvoi == null;
    }

    public String xmlCommande() {
        return this.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produit getLeProduit() {
        return leProduit;
    }

    public void setLeProduit(Produit leProduit) {
        this.leProduit = leProduit;
    }

    public Float getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(Float prixHt) {
        this.prixHt = prixHt;
    }

    public String getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(String conditionnement) {
        this.conditionnement = conditionnement;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDateConditionnement() {
        return dateConditionnement;
    }

    public void setDateConditionnement(LocalDate dateConditionnement) {
        this.dateConditionnement = dateConditionnement;
    }

    public LocalDate getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDate dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", produit=" + leProduit +
                ", prixHt=" + prixHt +
                ", conditionnement='" + conditionnement + '\'' +
                ", quantite=" + quantite +
                ", dateConditionnement=" + dateConditionnement +
                ", dateEnvoi=" + dateEnvoi +
                '}';
    }
}
