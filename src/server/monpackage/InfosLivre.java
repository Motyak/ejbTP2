package monpackage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InfosLivre implements IInfosLivre
{
    @PersistenceContext(unitName="BiblioCERIPU")
    private EntityManager em;

    @Override
    public String getTitre(String isbn)
    {
        Livre livre = this.em.find(Livre.class, isbn);
        return livre.getTitre();
    }

    @Override
    public Livre[] getLivres()
    {
        return (Livre[])this.em.createNamedQuery("Livre.findAll").getResultList().toArray();
    }
}