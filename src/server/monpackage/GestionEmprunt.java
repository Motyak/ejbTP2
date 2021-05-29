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
    public void emprunterLivre(String isbn) throws NbMaxEmpAtteint, LivreNonDisponible
    {
        Livre livre = this.em.find(Livre.class, isbn);

        if(this.emprunteur.getNbLivresEmp() > 2)
            throw new NbMaxEmpAtteint();

        if(livre.getDispo() == 0)
            throw new LivreNonDisponible();

        livre.setDispo(0);
        LivreEmp emp = new LivreEmp(isbn, livre.getTitre(), this.emprunteur.getNum());
        this.em.persist(emp);

        this.emprunteur.incNbLivresEmp();
        this.em.merge(emprunteur);
    }

    @Override
    public void rendreLivre(String isbn)
    {
        Livre livre = this.em.find(Livre.class, isbn);
        livre.setDispo(1);

        this.emprunteur.decNbLivresEmp();
        this.em.merge(emprunteur);

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