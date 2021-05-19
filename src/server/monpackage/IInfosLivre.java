package monpackage;

import javax.ejb.Remote;

@Remote
public interface IInfosLivre
{
    public String getTitre(String isbn);
    public Livre[] getLivres();
}