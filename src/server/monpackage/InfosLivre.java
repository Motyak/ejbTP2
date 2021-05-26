package monpackage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    public List<Livre> getLivres()
    {
        TypedQuery<Livre> query = this.em.createNamedQuery("Livre.findAll", Livre.class);
        return query.getResultList();
    }
}