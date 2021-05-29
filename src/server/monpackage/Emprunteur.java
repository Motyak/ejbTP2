package monpackage;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="emprunteur")
public class Emprunteur
{
    @Id 
    private int numemp;
    private String nom;
    private int nblivresemp;

    public Emprunteur()
    {
        this.numemp = -1;
        this.nom = "";
        this.nblivresemp = -1;
    }

    public Emprunteur(int numemp, String nom, int nblivresemp)
    {
        this.numemp = numemp;
        this.nom = nom;
        this.nblivresemp = nblivresemp;
    }

    public void incNbLivresEmp()
    {
        this.nblivresemp = this.nblivresemp + 1;
    }

    public void decNbLivresEmp()
    {
        this.nblivresemp = this.nblivresemp - 1;
    }

    public int getNum()
    {
        return this.numemp;
    }

    public int getNbLivresEmp()
    {
        return this.nblivresemp;
    }
}