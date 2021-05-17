package monpackage;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="livre_emp")
public class LivreEmp
{
    @Id 
    private String isbn;
    private String titre;
    private int empruntepar;

    public LivreEmp()
    {
        this.isbn = "";
        this.titre = "";
        this.empruntepar = -1;
    }

    public LivreEmp(String isbn, String titre, int empruntepar)
    {
        this.isbn = isbn;
        this.titre = titre;
        this.empruntepar = empruntepar;
    }

    public void setEmpruntePar(int empruntepar)
    {
        this.empruntepar = empruntepar;
    }
}