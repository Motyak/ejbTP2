package monpackage;

import javax.ejb.Remote;

@Remote
public interface IGestionEmprunt
{
    public void creerEmprunt(int numEmprunteur);
    public void emprunterLivre(String isbn);
    public void rendreLivre(String isbn);

    // public void ajouterLivre(String isbn, String titre);
    // public void supprimerLivre(String isbn);
}