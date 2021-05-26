package monpackage;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IInfosLivre
{
    public String getTitre(String isbn);
    public List<Livre> getLivres();
}