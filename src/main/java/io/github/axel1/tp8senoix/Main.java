package io.github.axel1.tp8senoix;

public class Main {
    public static void main(String[] args) {
        GestionCommandes gestionCommandes = new GestionCommandes(new PersistanceSQL("jdbc:mariadb://localhost/Senoix", "", ""));

        System.out.println(gestionCommandes.xmlNonLivrees(gestionCommandes.getDistributeur(1).get()));
    }
}
