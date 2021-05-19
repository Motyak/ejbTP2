package monpackage;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@Table(name="livre")
@NamedQuery(name="Livre.findAll", query="SELECT l FROM Livre l where l.dispo=1")
public class Livre implements Serializable
{
    @Id 
    private String isbn;
    private String titre;
    private int dispo;

    public Livre()
    {
        this.isbn = "";
        this.titre = "";
        this.dispo = 1;
    }

    public Livre(String isbn, String titre)
    {
        this.isbn = isbn;
        this.titre = titre;
        this.dispo = 1;
    }

    public void setDispo(int dispo)
    {
        this.dispo = dispo;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    public String getTitre()
    {
        return this.titre;
    }
}