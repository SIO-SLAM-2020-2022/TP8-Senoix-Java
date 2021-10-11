package io.github.axel1.tp8senoix;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersistanceSQL {
    private Connection con;

    public PersistanceSQL(String url, String username, String password) {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Produit> findProduitById(int idProduit) {
        Optional<Produit> produit = Optional.empty();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Produit WHERE id = " + idProduit);
            if (rs.next()) {
                Produit newProduit = new Produit(rs.getInt("id"), rs.getString("variete"), rs.getString("type"), rs.getInt("calibre"));
                produit = Optional.of(newProduit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }

    public Optional<Commande> findCommandeById(int idCommande) {
        Optional<Commande> commande = Optional.empty();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Commande WHERE id = " + idCommande);
            if (rs.next()) {
                Commande newCommande = new Commande(rs.getInt("id"), findProduitById(rs.getInt("id_produit")).get(), rs.getFloat("prix_ht"), rs.getString("conditionnement"), rs.getInt("quantite"), rs.getObject("date_conditionnement", LocalDate.class), rs.getObject("date_envoi", LocalDate.class));
                commande = Optional.of(newCommande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return commande;
    }

    public Optional<Distributeur> findDistributeurById(int idDistributeur) {
        Optional<Distributeur> distributeur = Optional.empty();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Distributeur WHERE id = " + idDistributeur);
            if (rs.next()) {
                Distributeur newDistributeur = new Distributeur(rs.getInt("id"), rs.getString("nom"), findCommandeByIdDistributeur(rs.getInt("id")));
                distributeur = Optional.of(newDistributeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return distributeur;
    }

    private List<Commande> findCommandeByIdDistributeur(int idDistributeur) {
        List<Commande> commandes = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Commande WHERE id_distributeur = " + idDistributeur);
            while (rs.next()) {
                commandes.add(new Commande(rs.getInt("id"), findProduitById(rs.getInt("id_produit")).get(), rs.getFloat("prix_ht"), rs.getString("conditionnement"), rs.getInt("quantite"), rs.getObject("date_conditionnement", LocalDate.class), rs.getObject("date_envoi", LocalDate.class)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return commandes;
    }
}
