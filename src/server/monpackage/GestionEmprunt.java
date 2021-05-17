package monpackage;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class GestionEmprunt implements IGestionEmprunt
{
    @PersistenceContext(unitName="BiblioCERIPU")
    private EntityManager em;

    private Emprunteur emprunteur;

    @Override
    public void creerEmprunt(int numEmprunteur)
    {
        this.emprunteur = this.em.find(Emprunteur.class, numEmprunteur);
    } 

    @Override
    public void emprunterLivre(String isbn)
    {
        Livre livre = this.em.find(Livre.class, isbn);
        livre.setDispo(0);

        this.emprunteur.incNbLivresEmp();

        LivreEmp emp = new LivreEmp(isbn, livre.getTitre(), this.emprunteur.getNum());
        this.em.persist(emp);
    }

    @Override
    public void rendreLivre(String isbn)
    {
        Livre livre = this.em.find(Livre.class, isbn);
        livre.setDispo(1);

        this.emprunteur.decNbLivresEmp();

        LivreEmp emp = this.em.find(LivreEmp.class, isbn);
        this.em.remove(emp);
    }

    // @Override
    // public void ajouterLivre(String isbn, String titre)
    // {
    //     this.em.persist(new Livre(isbn, titre));
    // }

    // @Override
    // public void supprimerLivre(String isbn)
    // {
    //     Livre livre = this.em.find(Livre.class, isbn);
    //     this.em.remove(livre);
    // }
}