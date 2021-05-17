package monpackage;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="livre")
public class Livre
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