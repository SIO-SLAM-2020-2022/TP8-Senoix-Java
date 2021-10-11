package io.github.axel1.tp8senoix;

import java.util.ArrayList;
import java.util.List;

public class Distributeur {
    private int id;
    private String nom;
    private List<Commande> lesCommandes = new ArrayList<>();

    public Distributeur(int id, String nom, List<Commande> lesCommandes) {
        this.id = id;
        this.nom = nom;
        this.lesCommandes = lesCommandes;
    }

    public Distributeur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public List<Commande> getCommandesEnCours() {
        List<Commande> commandesEnCours = new ArrayList<>();
        for (Commande commande : this.lesCommandes) {
            if (commande.isEnCours()) {
                commandesEnCours.add(commande);
            }
        }

        return commandesEnCours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    @Override
    public String toString() {
        return "Distributeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", lesCommandes=" + lesCommandes +
                '}';
    }
}
