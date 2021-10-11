package io.github.axel1.tp8senoix;

import java.util.Optional;

public class GestionCommandes {
    private final PersistanceSQL donnees;

    public GestionCommandes(PersistanceSQL donnees) {
        this.donnees = donnees;
    }

    public Optional<Distributeur> getDistributeur(int idDistributeur) {
        return donnees.findDistributeurById(idDistributeur);
    }

    public String xmlNonLivrees(Distributeur distributeur) {
        StringBuilder xml = new StringBuilder();
        for (Commande commande : distributeur.getCommandesEnCours()) {
            xml.append(commande.xmlCommande());
            xml.append(", ");
        }

        return xml.toString();
    }
}
